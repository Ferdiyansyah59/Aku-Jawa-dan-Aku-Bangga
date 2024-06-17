/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siswatable;

/**
 *
 * @author ferdiyansyah
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Nilai extends javax.swing.JFrame {
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet res = null;
    private DefaultTableModel tm = null;
    private String query = null;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private boolean adaRecord = false;
    /**
     * Creates new form Nilai
     */
    public Nilai() {
        super("Ferdiyansyah");
        initComponents();
        con = koneksi.getConnection();
        
        query = "SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester, nilai.nilai,"
                + " nilai.keterangan FROM siswa, mapel, nilai WHERE siswa.nis = nilai.nis"
                + " and mapel.kode = nilai.kodemapel";
        buttonGroup1.add(rbNis);
        buttonGroup1.add(rbNama);
        buttonGroup1.add(rbNilai);
        
        comboBox();
    }
    
    public Object[][] getAllNilai(){
        Object data[][] = null;
        try{
            pstmt = con.prepareStatement(query);
            if( (rbNis.isSelected()) || (rbNama.isSelected()) || (rbNilai.isSelected()) ){
                pstmt.setString(1, "%"+inFilter.getText()+"%");
            }
            res = pstmt.executeQuery();
            res.last();
            int baris = res.getRow();
            res.beforeFirst();
            data = new Object[baris][6];
            int i = 0;
            while(res.next()){
                data[i][0] = res.getString("nis");
                data[i][1] = res.getString("nama");
                data[i][2] = res.getString("mapel");
                data[i][3] = res.getString("semester");
                data[i][4] = res.getString("nilai");
                data[i][5] = res.getString("keterangan");
                    i++;
                }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public void tampil(){
        String[] judul = new String[] {"NIS","Nama","Mata Pelajaran","Semester","Nilai","Keterangan"};
        tm = new DefaultTableModel(getAllNilai(), judul);
        tabelNilai.setModel(tm);
    }
    
    public void comboBox(){
        String qry = "SELECT mapel FROM mapel";
        try{
            pstmt = con.prepareStatement(qry);
            res = pstmt.executeQuery();
            while(res.next()){
                inMapel.addItem(res.getString("mapel"));
            }
            res.last();
            int jumlah = res.getRow();
            res.first();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void mapelChange(){
        String qry = "SELECT kode, kelompok FROM mapel WHERE mapel=?";
        try{
            pstmt = con.prepareStatement(qry);
             pstmt.setString(1, (String) inMapel.getSelectedItem());
            res = pstmt.executeQuery();
            if(res.next()){
                inKode.setText(res.getString("kode"));
                inKel.setText(res.getString("kelompok"));
            }else{
                inKode.setText("");
                inKel.setText("");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void tampilNama(){
        String qry = "SELECT*FROM siswa WHERE nis=?";
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inNis.getText());
            res = pstmt.executeQuery();
            if(res.next()){
                inNama.setText(res.getString("nama"));
            }else{
                inNama.setText("");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }      
    }
    public void tampilField(){
        String qry = "SELECT siswa.nis, siswa.nama, nilai.semester, mapel.mapel, nilai.kodemapel ,"
                + "nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE nilai.nis = siswa.nis"
                + " and nilai.kodemapel = mapel.kode and nilai.nis like ?";
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inNis.getText());
            res = pstmt.executeQuery();
            if(res.next()){
                inNama.setText(res.getString("nama"));
                inKode.setText(res.getString("kodemapel"));
                inSemester.setSelectedItem(res.getString("semester"));
                inNilai.setText(res.getString("nilai"));
                inKet.setText(res.getString("keterangan"));
                inMapel.setSelectedItem(res.getString("mapel"));
                adaRecord = true;
            }else{
                inNama.setText("");
                inMapel.setSelectedIndex(0);
                inSemester.setSelectedIndex(0);
                inNilai.setText("");
                inKet.setText("");
                adaRecord = false;
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }            
    }
    
    public void simpanData(){
         String qry;
            qry = "INSERT INTO nilai (nis, kodemapel, semester, nilai, keterangan) VALUES (?,?,?,?,?)"; 
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inNis.getText());
            pstmt.setString(2, inKode.getText());
            pstmt.setString(3, inSemester.getSelectedItem().toString());
            pstmt.setString(4, inNilai.getText());
            pstmt.setString(5, inKet.getText());
            pstmt.executeUpdate();
            tampil();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void updateData(){
        String qry;
            qry = " UPDATE nilai SET nis='"+inNis.getText()+"',kodemapel='"+inKode.getText()+"'"
                    + ", semester='"+inSemester.getSelectedItem()+"', nilai='"+inNilai.getText()+"'"
                    + ", keterangan='"+inKet.getText()+"' where nis='"+ inNis.getText() +"' ";        
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.executeUpdate();
            tampil();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void deleteData(){
        if(adaRecord){
             int pilih = JOptionPane.showConfirmDialog(null, "Data Nilai milik " + inNis.getText() + 
                     " Akan dihapus?", "HAPUS MAPEL!",JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
                String qry = "DELETE FROM nilai WHERE nis=?";
                try{
                    pstmt = con.prepareStatement(qry);
                    pstmt.setString(1, inNis.getText());
                    pstmt.executeUpdate();
                    tampil();
                    adaRecord = false;
                }catch(SQLException e){
                    System.err.println(e);
                }
            }
        }
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        TableNilai = new javax.swing.JScrollPane();
        tabelNilai = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        inFilter = new javax.swing.JTextField();
        rbNis = new javax.swing.JRadioButton();
        rbNama = new javax.swing.JRadioButton();
        rbNilai = new javax.swing.JRadioButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inKel = new javax.swing.JTextField();
        inNama = new javax.swing.JTextField();
        inKode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inSemester = new javax.swing.JComboBox();
        inMapel = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        inKet = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        inNis = new javax.swing.JTextField();
        inNilai = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 150));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel1.setText("DATA NILAI RAPORT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        back.setBackground(new java.awt.Color(255, 204, 204));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 120));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelNilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelNilaiMouseClicked(evt);
            }
        });
        TableNilai.setViewportView(tabelNilai);

        jLabel9.setText("Filter");

        inFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inFilterActionPerformed(evt);
            }
        });
        inFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inFilterKeyReleased(evt);
            }
        });

        rbNis.setText("NIS");

        rbNama.setText("Nama");

        rbNilai.setText("Nilai");

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableNilai)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbNis)
                        .addGap(18, 18, 18)
                        .addComponent(rbNama)
                        .addGap(18, 18, 18)
                        .addComponent(rbNilai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(update)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(rbNis)
                    .addComponent(rbNama)
                    .addComponent(rbNilai)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(update))
                .addGap(18, 18, 18)
                .addComponent(TableNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 680, 260));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Keterangan");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        inKel.setEditable(false);
        inKel.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(inKel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 130, -1));

        inNama.setEditable(false);
        inNama.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(inNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 280, -1));

        inKode.setEditable(false);
        inKode.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.add(inKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 80, -1));

        jLabel4.setText("Nama");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel5.setText("Kode");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel6.setText("Kelompok");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jLabel7.setText("Mata Pelajaran");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel8.setText("Nilai");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        inSemester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));
        jPanel3.add(inSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 40, 30));

        inMapel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        inMapel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inMapelItemStateChanged(evt);
            }
        });
        inMapel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inMapelMouseClicked(evt);
            }
        });
        jPanel3.add(inMapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 170, 30));

        inKet.setColumns(20);
        inKet.setRows(5);
        jScrollPane1.setViewportView(inKet);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 430, 90));

        jLabel10.setText("NIS");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        inNis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inNisActionPerformed(evt);
            }
        });
        inNis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inNisKeyReleased(evt);
            }
        });
        jPanel3.add(inNis, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 120, -1));

        inNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inNilaiActionPerformed(evt);
            }
        });
        inNilai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inNilaiKeyReleased(evt);
            }
        });
        jPanel3.add(inNilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 70, -1));

        jLabel11.setText("Semester");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 680, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inFilterActionPerformed

    private void inNisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inNisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inNisActionPerformed

    private void inNisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inNisKeyReleased
        tampilField();
        tampilNama(); 
    }//GEN-LAST:event_inNisKeyReleased

    private void inMapelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inMapelMouseClicked
        
    }//GEN-LAST:event_inMapelMouseClicked

    private void inMapelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inMapelItemStateChanged
        mapelChange();
    }//GEN-LAST:event_inMapelItemStateChanged

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpanData();
        inNis.setText("");
        inNama.setText("");
        inMapel.setSelectedIndex(0);
        inSemester.setSelectedIndex(0);
        inNilai.setText("");
        inKet.setText("");
    }//GEN-LAST:event_btnSimpanActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void inNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inNilaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inNilaiActionPerformed

    private void inNilaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inNilaiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_inNilaiKeyReleased

    private void inFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inFilterKeyReleased
        if(rbNis.isSelected()){
            query = " SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester,"
                    + " nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE "
                    + "siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel and nilai.nis like? ";
        }else if(rbNama.isSelected()){
            query = "SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester,"
                    + " nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE "
                    + "siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel and siswa.nama like?";
        }else if(rbNilai.isSelected()){
            query = " SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester,"
                    + " nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE"
                    + " siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel and nilai.nilai like? ";
        }else{
            query = " SELECT siswa.nis, siswa.nama, mapel.mapel, nilai.semester, "
                    + "nilai.nilai, nilai.keterangan FROM siswa, mapel, nilai WHERE "
                    + "siswa.nis = nilai.nis and mapel.kode = nilai.kodemapel ";
        }
        tampil();
    }//GEN-LAST:event_inFilterKeyReleased

    private void tabelNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelNilaiMouseClicked
        inNis.setText(tm.getValueAt(tabelNilai.getSelectedRow(), 0).toString());
        inNama.setText(tm.getValueAt(tabelNilai.getSelectedRow(), 1).toString());
        inMapel.setSelectedItem(tm.getValueAt(tabelNilai.getSelectedRow(),2).toString());
        inSemester.setSelectedItem(tm.getValueAt(tabelNilai.getSelectedRow(),3).toString());
        inNilai.setText(tm.getValueAt(tabelNilai.getSelectedRow(), 4).toString());
        inKet.setText(tm.getValueAt(tabelNilai.getSelectedRow(), 5).toString());     
    }//GEN-LAST:event_tabelNilaiMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updateData();
        inNis.setText("");
        inNama.setText("");
        inMapel.setSelectedIndex(0);
        inSemester.setSelectedIndex(0);
        inNilai.setText("");
        inKet.setText("");
    }//GEN-LAST:event_updateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        deleteData();
        inNis.setText("");
        inNama.setText("");
        inMapel.setSelectedIndex(0);
        inSemester.setSelectedIndex(0);
        inNilai.setText("");
        inKet.setText("");
    }//GEN-LAST:event_btnHapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TableNilai;
    private javax.swing.JButton back;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inFilter;
    private javax.swing.JTextField inKel;
    private javax.swing.JTextArea inKet;
    private javax.swing.JTextField inKode;
    private javax.swing.JComboBox inMapel;
    private javax.swing.JTextField inNama;
    private javax.swing.JTextField inNilai;
    private javax.swing.JTextField inNis;
    private javax.swing.JComboBox inSemester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbNama;
    private javax.swing.JRadioButton rbNilai;
    private javax.swing.JRadioButton rbNis;
    private javax.swing.JTable tabelNilai;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

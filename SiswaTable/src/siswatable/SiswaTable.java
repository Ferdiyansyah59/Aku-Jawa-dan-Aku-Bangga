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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SiswaTable extends javax.swing.JFrame {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet res = null;
    private DefaultTableModel tm = null;
    private String query = null;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private boolean adaRecord = false;
    /**
     * Creates new form SiswaTable
     */
    public SiswaTable() {
        super("Ferdiyansyah");
        initComponents();
        con = koneksi.getConnection();
        query = "SELECT*FROM siswa order by nis";
        buttonGroup1.add(rbNis);
        buttonGroup1.add(rbNama);
        buttonGroup1.add(rbAlamat);
        
        buttonGroup2.add(rbYes);
        buttonGroup2.add(rbNo);
        
        btnSimpan.setText("SIMPAN");
    }
    
    public Object[][] getAllSiswa(){
        Object data[][] = null;
       try{
            pstmt = con.prepareStatement(query);
            if((rbNis.isSelected()) || (rbNama.isSelected()) || (rbAlamat.isSelected())){
                pstmt.setString(1, "%"+filter.getText()+"%");
            }
            res = pstmt.executeQuery(); //eksekusi query hasilnya disimpan dalam res
            res.last(); //menju record terakhir
            int baris = res.getRow(); //mengambil no baris record terakhir
            res.beforeFirst(); //kembali ke sebelum record pertama
            data = new Object[baris][8]; //definisikan panjang array (baris, kolom)
            int i=0; //counter atau variabel pencacah
            while(res.next()){ //pengulangan selama masih ada record berikutnya
                data[i][0] = res.getString("nis");
                data[i][1] = res.getString("nisn");
                data[i][2] = res.getString("nama");
                data[i][3] = res.getString("gender");
                data[i][4] = res.getString("tmplahir");
                try{
                    data[i][5] = res.getString("tgllahir");
                }catch(SQLException e){
                    data[i][5] = null;
                }
                data[i][6] = res.getString("alamat");
                data[i][7] = res.getString("telepon");
                i++;
            }
       }catch(SQLException e){
           System.err.println(e.getMessage());
       } 
        return data;
    }
    
    public void tampil(){
        String[] judul = new String[] {"NIS","NISN","Nama","Gender","Tmp_Lahir","Tgl_Lahir","Alamat","Telepon"};
        tm = new DefaultTableModel(getAllSiswa(), judul);
        tabelSiswa.setModel(tm);
    }
    
    public void tampilDataForm(){
        String qry = "SELECT*FROM siswa WHERE nis=?";
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inNis.getText());
            res = pstmt.executeQuery();
            if(res.next()){
                inNama.setText(res.getString("nama"));
                if(res.getString("gender").equals("Laki-Laki")){
                    inGender.setSelectedIndex(1);
                }else{
                    inGender.setSelectedIndex(2);
                }
                inTmplahir.setText(res.getString("tmplahir"));
                try{
                    String tgl = sdf.format(res.getDate("tgllahir"));
                    inTgllahir.setDate(Date.valueOf(tgl));
                }catch(SQLException e){
                    System.err.println(e.getMessage());
                }
                inNisn.setText(res.getString("nisn"));
                inAlamat.setText(res.getString("alamat"));
                inTelepon.setText(res.getString("telepon"));
                adaRecord = true;
            }else{
                inNama.setText("");
                inGender.setSelectedIndex(0);
                inTmplahir.setText("");
                inTgllahir.setCalendar(null);
                inNisn.setText("");
                inAlamat.setText("");
                inTelepon.setText("");
                adaRecord = false;
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void simpanData(){
        String qry;
        if(adaRecord){
            qry = "UPDATE siswa SET nisn=?, nama=?, gender=?, tmplahir=?, tgllahir=?, alamat=?, aktif=?,"
                    + " telepon=? WHERE nis=? ";         
        }else{
            qry = "INSERT INTO siswa (nisn, nama, gender, tmplahir, tgllahir, alamat, aktif, telepon, nis)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";  
        }
        
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inNisn.getText());
            pstmt.setString(2, inNama.getText());
            pstmt.setString(3, inGender.getSelectedItem().toString());
            pstmt.setString(4, inTmplahir.getText());
            if(inTgllahir.getDate() != null){
                String tgl = sdf.format(inTgllahir.getDate());
                pstmt.setDate(5, Date.valueOf(tgl));
            }else{
                pstmt.setNull(5, java.sql.Types.DATE);
            }
            pstmt.setString(6, inAlamat.getText());
            String aktif;
            if(rbYes.isSelected()){
                aktif="Y";
            }else{
                aktif="T";
            }
            pstmt.setString(7, aktif);
            pstmt.setString(8, inTelepon.getText());
            pstmt.setString(9, inNis.getText());
            pstmt.executeUpdate();
            tampil();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    } 
    
    public void hapus(){
        if(adaRecord){
            int pilih = JOptionPane.showConfirmDialog(null, "Data Siswa " + inNama.getText()
                    + " Akan dihapus?", "HAPUS DATA!",JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
                String qry = "DELETE FROM siswa WHERE nis=?";
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSiswa = new javax.swing.JTable();
        filter = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rbNis = new javax.swing.JRadioButton();
        rbNama = new javax.swing.JRadioButton();
        rbAlamat = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        inTmplahir = new javax.swing.JTextField();
        inNisn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inGender = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        inTelepon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inTgllahir = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        inNis = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        inAlamat = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        inNama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rbNo = new javax.swing.JRadioButton();
        rbYes = new javax.swing.JRadioButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 150));
        setMinimumSize(new java.awt.Dimension(900, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "NISN", "Nama", "Gender", "Tmp_Lahir", "Tgl_Lahir", "Alamat", "Telepon"
            }
        ));
        tabelSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSiswa);
        if (tabelSiswa.getColumnModel().getColumnCount() > 0) {
            tabelSiswa.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 730, 240));

        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });
        filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filterKeyTyped(evt);
            }
        });
        jPanel1.add(filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 150, -1));

        jLabel1.setText("FILTER DATA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        rbNis.setText("NIS");
        jPanel1.add(rbNis, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        rbNama.setText("Nama");
        rbNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNamaActionPerformed(evt);
            }
        });
        jPanel1.add(rbNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        rbAlamat.setText("Alamat");
        rbAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlamatActionPerformed(evt);
            }
        });
        jPanel1.add(rbAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 790, 340));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Tanggal Lahir");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));
        jPanel2.add(inTmplahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 210, -1));
        jPanel2.add(inNisn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 160, -1));

        jLabel4.setText("Aktif");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        inGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Laki-Laki", "Perempuan", " " }));
        jPanel2.add(inGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, -1));

        jLabel5.setText("Nama");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel2.add(inTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 200, -1));

        jLabel6.setText("Gender");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        jPanel2.add(inTgllahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 140, -1));

        jLabel7.setText("Tempat Lahir");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        inNis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inNisKeyReleased(evt);
            }
        });
        jPanel2.add(inNis, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 120, -1));

        jLabel8.setText("NIS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        inAlamat.setColumns(20);
        inAlamat.setRows(5);
        jScrollPane3.setViewportView(inAlamat);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 230, 90));

        jLabel9.setText("NISN");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));
        jPanel2.add(inNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 210, -1));

        jLabel10.setText("Alamat");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        jLabel11.setText("Telepon");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        rbNo.setText("NO");
        jPanel2.add(rbNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        rbYes.setText("YES");
        jPanel2.add(rbYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 790, 290));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("DATA SISWA");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        back.setBackground(new java.awt.Color(255, 204, 204));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterActionPerformed

    private void rbNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNamaActionPerformed

    private void rbAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAlamatActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void filterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterKeyTyped

    }//GEN-LAST:event_filterKeyTyped

    private void filterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterKeyReleased
        if(rbNis.isSelected()){
            query = "SELECT*FROM siswa WHERE nis LIKE ?";
        }else if(rbNama.isSelected()){
            query = "SELECT*FROM siswa WHERE nama LIKE ?";
        }else if(rbAlamat.isSelected()){
            query = "SELECT*FROM siswa WHERE alamat LIKE ?";
        }else{
            query = "SELECT*FROM siswa ORDER BY nis";
        }
        tampil();
    }//GEN-LAST:event_filterKeyReleased

    private void tabelSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSiswaMouseClicked
          inNis.setText(tm.getValueAt(
                    tabelSiswa.getSelectedRow(),0).toString());
          tampilDataForm();
    }//GEN-LAST:event_tabelSiswaMouseClicked

    private void inNisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inNisKeyReleased
        tampilDataForm();
    }//GEN-LAST:event_inNisKeyReleased

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(inNis.getText().equals("")){
            JOptionPane.showMessageDialog(null, "NIS harus diisi");
            inNis.requestFocus();
        }else if(inNama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama harus diisi");
            inNama.requestFocus();
        }else{
          simpanData();  
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
        inNis.setText("");
        inNama.setText("");
        inGender.setSelectedIndex(0);
        inTmplahir.setText("");
        inTgllahir.setCalendar(null);
        inNisn.setText("");
        inAlamat.setText("");
        inTelepon.setText("");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(SiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SiswaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SiswaTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField filter;
    private javax.swing.JTextArea inAlamat;
    private javax.swing.JComboBox inGender;
    private javax.swing.JTextField inNama;
    private javax.swing.JTextField inNis;
    private javax.swing.JTextField inNisn;
    private javax.swing.JTextField inTelepon;
    private com.toedter.calendar.JDateChooser inTgllahir;
    private javax.swing.JTextField inTmplahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbAlamat;
    private javax.swing.JRadioButton rbNama;
    private javax.swing.JRadioButton rbNis;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbYes;
    private javax.swing.JTable tabelSiswa;
    // End of variables declaration//GEN-END:variables
}

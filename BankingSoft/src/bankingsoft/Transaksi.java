/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsoft;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Transaksi extends javax.swing.JFrame {
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet res = null;
    private DefaultTableModel tm = null;
    private String query = null;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private boolean adaRecord = false;
    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        super("Ferdiyansyah");
        initComponents();
        con = Koneksi.getConnection();
        
        query = "SELECT transaksi.notrans, nasabah.noakun, nasabah.nama, nasabah.telpon,"
                + " transaksi.tgltrans, transaksi.jnstrans, transaksi.jmltrans FROM nasabah,"
                + " transaksi WHERE nasabah.noakun = transaksi.noakun";
        buttonGroup1.add(rbAkun);
        buttonGroup1.add(rbTrans);
        buttonGroup1.add(rbNama);
    }
    
    public Object[][] getAllBank(){
        Object data[][] = null;
        try{
            pstmt = con.prepareStatement(query);
            if( (rbAkun.isSelected()) || (rbTrans.isSelected()) || (rbNama.isSelected()) ){
                pstmt.setString(1, "%"+inFilter.getText()+"%");
            }
            res = pstmt.executeQuery();
            res.last();
            int baris = res.getRow();
            res.beforeFirst();
            data = new Object[baris][7];
            int i = 0;
            while(res.next()){
                data[i][0] = res.getString("notrans");
                data[i][1] = res.getString("noAkun");
                data[i][2] = res.getString("nama");
                data[i][3] = res.getString("telpon");        
                data[i][4] = res.getString("tgltrans");
                data[i][5] = res.getString("jnstrans");
                data[i][6] = res.getString("jmltrans");
                i++;
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return data;
    }
    public void showTable(){
        String[] title = new String[] {"No Transaksi","No Akun","Nama Nasabah","Telpon Nasabah",
            "Tgl Transaksi","Jenis Transaksi","Jumlah Transaksi"};
        tm = new DefaultTableModel(getAllBank(), title);
        tableBank.setModel(tm);
    }
    public void showNasabahData(){
        String qry = "SELECT*FROM nasabah WHERE noakun=?";
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inAkun.getText());
            res = pstmt.executeQuery();
            if(res.next()){
                inNama.setText(res.getString("nama"));
                inTlp.setText(res.getString("telpon"));
                inKtp.setText(res.getString("noktp"));
            }else{
                inNama.setText("");
                inTlp.setText("");
                inKtp.setText("");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void showField(){
        String qry = "SELECT nasabah.noakun, transaksi.tgltrans, transaksi.jnstrans, transaksi.jmltrans,"
                + " nasabah.nama, nasabah.telpon, nasabah.noktp FROM nasabah, transaksi WHERE transaksi.notrans=?";
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inTrans.getText());
            res = pstmt.executeQuery();
            if(res.next()){
                inAkun.setText(res.getString("noakun"));
                try{
                    String tgl = sdf.format(res.getDate("tgltrans"));
                    inTgl.setDate(Date.valueOf(tgl));
                }catch(SQLException e){
                    System.err.println(e.getMessage());
                }
                inJenis.setSelectedItem(res.getString("jnstrans"));
                inJum.setText(res.getString("jmltrans"));
                inNama.setText(res.getString("nama"));
                inTlp.setText(res.getString("telpon"));
                inKtp.setText(res.getString("noktp"));
                adaRecord = true;
            }else{
                inAkun.setText("");
                inTgl.setCalendar(null);
                inJenis.setSelectedIndex(0);
                inJum.setText("");
                inNama.setText("");
                inTlp.setText("");
                inKtp.setText("");
                adaRecord = false;
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void saveData(){
        String qry;
        qry = "INSERT INTO transaksi (notrans,tgltrans,noakun,jnstrans,jmltrans) VALUES(?,?,?,?,?)";
        try{
            pstmt = con.prepareStatement(qry);
            pstmt.setString(1, inTrans.getText());
            if(inTgl.getDate() != null){
                String tgl = sdf.format(inTgl.getDate());
                pstmt.setDate(2, Date.valueOf(tgl));
            }else{
                pstmt.setNull(2, java.sql.Types.DATE);
            }
            pstmt.setString(3, inAkun.getText());
            pstmt.setString(4, inJenis.getSelectedItem().toString());
            pstmt.setString(5, inJum.getText());
            pstmt.executeUpdate();
            showTable();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void deleteData(){
        if(adaRecord){
            int pilih = JOptionPane.showConfirmDialog(null, "Data Transaksi " + inTrans.getText() +
                    " Akan dihapus?", "HAPUS DATA!",JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION){
                String qry = "DELETE FROM transaksi WHERE notrans=?";
                try{
                    pstmt = con.prepareStatement(qry);
                    pstmt.setString(1, inTrans.getText());
                    pstmt.executeUpdate();
                    showTable();
                    adaRecord = false;
                }catch(SQLException e){
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    public void updateData(){
        String qry;
        qry = "UPDATE transaksi SET tgltrans=?, noakun=?, jnstrans=?, jmltrans=? WHERE notrans=?";
        try{
            pstmt = con.prepareStatement(qry);   
            if(inTgl.getDate() != null){
                String tgl = sdf.format(inTgl.getDate());
                pstmt.setDate(1, Date.valueOf(tgl));
            }else{
                pstmt.setNull(1, java.sql.Types.DATE);
            }
            pstmt.setString(2, inAkun.getText());
            pstmt.setString(3, inJenis.getSelectedItem().toString());
            pstmt.setString(4, inJum.getText());
            pstmt.setString(5, inTrans.getText());
            pstmt.executeUpdate();
            showTable();
        }catch(SQLException e){
            System.err.println(e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inAkun = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inJum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inKtp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inTgl = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inJenis = new javax.swing.JComboBox();
        inTrans = new javax.swing.JTextField();
        inNama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inTlp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        TabelBank = new javax.swing.JScrollPane();
        tableBank = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        inFilter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbNama = new javax.swing.JRadioButton();
        rbAkun = new javax.swing.JRadioButton();
        rbTrans = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trajan Pro 3", 3, 36)); // NOI18N
        jLabel1.setText("DAFTAR TRANSAKSI BANKINGSOFT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("No Akun");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        inAkun.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inAkunInputMethodTextChanged(evt);
            }
        });
        inAkun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inAkunKeyReleased(evt);
            }
        });
        jPanel1.add(inAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 119, -1));

        jLabel3.setText("Tgl Transaksi");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));
        jPanel1.add(inJum, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 119, -1));

        jLabel5.setText("No KTP");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        inKtp.setEditable(false);
        inKtp.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(inKtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 120, -1));

        jLabel6.setText("Jumlah Transaksi");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        jPanel1.add(inTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel7.setText("No Transaksi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel8.setText("Jenis Transaksi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        inJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Penarikan Tunai", "Setoran Tunai", "Penarikan Online", "Setoran Online", "Transfer" }));
        jPanel1.add(inJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 120, -1));

        inTrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inTransKeyReleased(evt);
            }
        });
        jPanel1.add(inTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 119, -1));

        inNama.setEditable(false);
        inNama.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(inNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 140, -1));

        jLabel9.setText("Nama Nasabah");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        inTlp.setEditable(false);
        inTlp.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(inTlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 130, -1));

        jLabel11.setText("Telpon Nasabah");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 550, 260));

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, 40));

        TabelBank.setForeground(new java.awt.Color(102, 102, 102));

        tableBank.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaksi", "No Akun", "Nama Nasabah", "Telpon Nasabah", "Tgl Transaksi", "Jenis Transaksi", "Jumlah Transaksi"
            }
        ));
        tableBank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBankMouseClicked(evt);
            }
        });
        TabelBank.setViewportView(tableBank);

        getContentPane().add(TabelBank, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 610, 280));

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, 40));

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
        getContentPane().add(inFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 140, -1));

        jLabel4.setText("Filter");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        rbNama.setText("Nama Nasabah");
        getContentPane().add(rbNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, -1, -1));

        rbAkun.setText("No Akun");
        getContentPane().add(rbAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, -1, -1));

        rbTrans.setText("No Transaksi");
        getContentPane().add(rbTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Trajan Pro 3", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ferdiyansyah");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(jLabel10)
                .addContainerGap(586, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1220, 70));

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 90, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showTable();
    }//GEN-LAST:event_formWindowOpened

    private void inAkunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inAkunKeyReleased
        showNasabahData();
    }//GEN-LAST:event_inAkunKeyReleased

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        saveData();
        inTrans.setText("");
        inAkun.setText("");
        inTgl.setCalendar(null);
        inJenis.setSelectedIndex(0);
        inJum.setText("");
        inNama.setText("");
        inTlp.setText("");
        inKtp.setText("");
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void inTransKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inTransKeyReleased
       showField();
    }//GEN-LAST:event_inTransKeyReleased

    private void inAkunInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inAkunInputMethodTextChanged

    }//GEN-LAST:event_inAkunInputMethodTextChanged

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        deleteData();
        inTrans.setText("");
        inAkun.setText("");
        inTgl.setCalendar(null);
        inJenis.setSelectedIndex(0);
        inJum.setText("");
        inNama.setText("");
        inTlp.setText("");
        inKtp.setText("");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateData();
        inTrans.setText("");
        inAkun.setText("");
        inTgl.setCalendar(null);
        inJenis.setSelectedIndex(0);
        inJum.setText("");
        inNama.setText("");
        inTlp.setText("");
        inKtp.setText("");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBankMouseClicked
       inTrans.setText(tm.getValueAt(tableBank.getSelectedRow(), 0).toString());
       inAkun.setText(tm.getValueAt(tableBank.getSelectedRow(), 1).toString());
       inNama.setText(tm.getValueAt(tableBank.getSelectedRow(), 2).toString());
       inTlp.setText(tm.getValueAt(tableBank.getSelectedRow(), 3).toString());
       inTgl.setDate(Date.valueOf(tm.getValueAt(tableBank.getSelectedRow(), 4).toString())); 
       inJenis.setSelectedItem(tm.getValueAt(tableBank.getSelectedRow(), 5).toString());
       inJum.setText(tm.getValueAt(tableBank.getSelectedRow(), 6).toString());     
    }//GEN-LAST:event_tableBankMouseClicked

    private void inFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inFilterActionPerformed
        
    }//GEN-LAST:event_inFilterActionPerformed

    private void inFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inFilterKeyReleased
        if(rbTrans.isSelected()){
            query = " SELECT transaksi.notrans, nasabah.noakun, nasabah.nama, nasabah.telpon, "
                    + "transaksi.tgltrans, transaksi.jnstrans, transaksi.jmltrans FROM nasabah, "
                    + "transaksi WHERE nasabah.noakun = transaksi.noakun and transaksi.notrans like? ";
        }else if(rbAkun.isSelected()){
            query = " SELECT transaksi.notrans, nasabah.noakun, nasabah.nama, nasabah.telpon, "
                    + "transaksi.tgltrans, transaksi.jnstrans, transaksi.jmltrans FROM nasabah, "
                    + "transaksi WHERE nasabah.noakun = transaksi.noakun and transaksi.noakun like? ";
        }else if(rbNama.isSelected()){
            query = " SELECT transaksi.notrans, nasabah.noakun, nasabah.nama, nasabah.telpon, "
                    + "transaksi.tgltrans, transaksi.jnstrans, transaksi.jmltrans FROM nasabah, transaksi "
                    + "WHERE nasabah.noakun = transaksi.noakun and nasabah.nama like? ";
        }
        showTable();
    }//GEN-LAST:event_inFilterKeyReleased

    public void filterhuruf(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            
        }
    }
    
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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TabelBank;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inAkun;
    private javax.swing.JTextField inFilter;
    private javax.swing.JComboBox inJenis;
    private javax.swing.JTextField inJum;
    private javax.swing.JTextField inKtp;
    private javax.swing.JTextField inNama;
    private com.toedter.calendar.JDateChooser inTgl;
    private javax.swing.JTextField inTlp;
    private javax.swing.JTextField inTrans;
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
    private javax.swing.JRadioButton rbAkun;
    private javax.swing.JRadioButton rbNama;
    private javax.swing.JRadioButton rbTrans;
    private javax.swing.JTable tableBank;
    // End of variables declaration//GEN-END:variables
}

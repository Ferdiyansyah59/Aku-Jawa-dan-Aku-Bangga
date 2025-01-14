/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisinfonilai;

import javax.swing.JOptionPane;

/**
 *
 * @author ferdiyansyah
 */
public class Siswa extends javax.swing.JFrame {

    /**
     * Creates new form Siswa
     */
    public Siswa() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nisn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jenkel = new javax.swing.JComboBox();
        date = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        telpon = new javax.swing.JTextField();
        tgllahir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        nis = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tnis = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        searchB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Siswa By Ferdi");
        setLocation(new java.awt.Point(250, 250));
        setMinimumSize(new java.awt.Dimension(1260, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        title.setText("Daftar Siswa");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -10, 270, 90));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("NIS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));
        jPanel3.add(nisn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 180, -1));

        jLabel3.setText("Telepon");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 20));

        jenkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<---Pilih--->", "Laki-Laki", "Perempuan" }));
        jPanel3.add(jenkel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 20));
        jPanel3.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 180, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<---Pilih--->", "Ya", "Tidak" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 180, 20));
        jPanel3.add(telpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 180, -1));
        jPanel3.add(tgllahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, -1));

        jLabel4.setText("NISN");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, 10));

        jLabel5.setText("Nama");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, 10));

        jLabel6.setText("Tempat Lahir");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));
        jPanel3.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 180, -1));

        jLabel7.setText("Jenis Kelamin");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 10));

        jLabel8.setText("Tanggal Lahir");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 20));

        jLabel9.setText("Alamat");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 20));

        jLabel10.setText("Aktif");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 20));

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel3.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));
        jPanel3.add(nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 180, -1));

        alamat.setColumns(20);
        alamat.setRows(3);
        jScrollPane2.setViewportView(alamat);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 180, 80));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 370, 400));

        Tnis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "NISN", "Nama", "Jenis Kelamin", "Tempat Lahir", "Tgl Lahir", "Alamat", "Aktif", "Telepon"
            }
        ));
        jScrollPane1.setViewportView(Tnis);
        if (Tnis.getColumnModel().getColumnCount() > 0) {
            Tnis.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tnis.getColumnModel().getColumn(1).setPreferredWidth(70);
            Tnis.getColumnModel().getColumn(2).setPreferredWidth(70);
            Tnis.getColumnModel().getColumn(3).setPreferredWidth(70);
            Tnis.getColumnModel().getColumn(4).setPreferredWidth(70);
            Tnis.getColumnModel().getColumn(5).setPreferredWidth(50);
            Tnis.getColumnModel().getColumn(6).setPreferredWidth(150);
            Tnis.getColumnModel().getColumn(7).setPreferredWidth(20);
            Tnis.getColumnModel().getColumn(8).setPreferredWidth(70);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 770, 390));

        edit.setText("Edit");
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 80, 80, 40));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 130, 80, 40));
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 180, 30));

        searchB.setText("Search");
        getContentPane().add(searchB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 30, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if(nis.getText().equals("")){
            JOptionPane.showMessageDialog(null,"NIS Tidak Boelh Kosong");
        }else if(nisn.getText().equals("")){
            JOptionPane.showMessageDialog(null,"NISN Tidak Boleh Kosong");
        }else if(tgllahir.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama Tidak Boleh Kosong");
        }
    }//GEN-LAST:event_submitActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        JOptionPane.showConfirmDialog(null, "Apakah data Mau Dihapus?","Warning!!", JOptionPane.YES_NO_OPTION);
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tnis;
    private javax.swing.JTextArea alamat;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jenkel;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nis;
    private javax.swing.JTextField nisn;
    private javax.swing.JTextField search;
    private javax.swing.JButton searchB;
    private javax.swing.JButton submit;
    private javax.swing.JTextField telpon;
    private javax.swing.JTextField tgllahir;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

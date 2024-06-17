/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DialogGUI;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*; //Mengambil semua isi dari libarary Swing
public class DialogGUI {
    public static void main(String[] args) {
        JFrame f2; //Membuat object untuk Frame
        f2 = new JFrame("Ferdiyansyah"); //Membuat Frame Baru
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Operasi colose jika tombol X di tekan
        f2.setVisible(true); //Menampilkan frame
        
        JOptionPane.showConfirmDialog(f2, "Apakah kamu yakin ingin keluar Ferdiyansyah?",   
                "Confirm To Exit this page by Ferdiyansyah",                     //Fungsi untuk menampilkan dialog konfirmasi  
                JOptionPane.YES_NO_OPTION //Menampilkan button Option
                , JOptionPane.QUESTION_MESSAGE);
        
    }
}

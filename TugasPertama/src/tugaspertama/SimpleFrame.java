/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspertama;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.JFrame; //Mengimport library dari swing
public class SimpleFrame extends JFrame {  //Extends/Mewarisi dari class parent 
    public SimpleFrame() { //Constructor Method
        super("Frame Sederhana"); //Memberi title pada frame
        setSize(1000,300); //Untuk mengatur ukuran dari frame yang di buat (LxP)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //saat tumbol X di tekan maka frame dan aplikasi akan tertutup
        setVisible(true); //Agara framenya tampil
    }
    public static void main(String[] args) {
        SimpleFrame sf = new SimpleFrame();  //Pembuatan objek berdasarkan class
    }
}

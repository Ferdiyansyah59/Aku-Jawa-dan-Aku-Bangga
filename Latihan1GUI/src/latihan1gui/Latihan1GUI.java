/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan1gui;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.Color; //Mengambil Library Color
import java.awt.Font; //Mengambil Library Font
import javax.swing.*; //Mengambil library dari Swing
public class Latihan1GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame  j1; //Membuat object untuk JfRAME
        j1 = new JFrame("Ferdiyansyah");  //Membuat Frame baru
        j1.getContentPane().setBackground(Color.RED); //Mengubah background Color
        
        JLabel label = new JLabel("Ini adalah sebuah Frame Sederhana Java GUI"); //Membuat Label baru
        label.setFont(new Font("Times New Roman",Font.PLAIN,24)); //Seting Font
        j1.add(label); //Menampilkan Label dalam Frame
        
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Operasi close jika tombol X di klik
        j1.setSize(500, 500); //Ukuran Frame
        j1.setVisible(true); //Menampilkan Frame
        
    }
}

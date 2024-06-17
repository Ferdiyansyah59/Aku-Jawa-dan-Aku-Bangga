/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlowLayoutDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.Container; //Memanggil Library Container
import java.awt.FlowLayout; //Memanggil Library FlowLayout
import java.awt.event.WindowAdapter; //Memanggil Library WindowAdapter
import java.awt.event.WindowEvent; //Memanggil Library WindowEvent
import javax.swing.JButton; //Memanggil Library JButton
import javax.swing.JFrame; //Memanggil Library JFrame
public class FlowLayoutDemo extends JFrame {
    
    public FlowLayoutDemo() {
        super("Ferdiyansyah"); //Memanggil superClass JFrame dan membuat title frame
        FlowLayout f1 = new FlowLayout(); //Membuat properti untuk FlowLaout
        f1.setAlignment(FlowLayout.CENTER); //Mengatur posisi untuk flow
        f1.setVgap(25); //Membuat gep vertical
        f1.setHgap(25); //Membuat gep Horizontal
        Container c = getContentPane(); //Membuat Properti Container
        c.setLayout(f1); //mengeset isi dari kontainer dengan FlowLayout
        
        for(int i = 0; i<10; i++) {
            JButton j1 = new JButton("Tombol ke-" + (i+1));
            c.add(j1);
        } // Membuat Button yang jumlahnya dari perulangan tersebut dan valuenya mengikuti dari perulagnannya
        
    }
    
    public static void main(String[] args) {
        FlowLayoutDemo fw = new FlowLayoutDemo(); //Membuat Object FlowLayoutDemo
        fw.setSize(700, 200); //Mengatur ukuan dari frame
        fw.setVisible(true); //Menampilkan Konten
        fw.addWindowListener(new WindowAdapter(){
           public void windowsClosing(WindowEvent e) {
               System.exit(0);
           } 
        });
    }
    
}

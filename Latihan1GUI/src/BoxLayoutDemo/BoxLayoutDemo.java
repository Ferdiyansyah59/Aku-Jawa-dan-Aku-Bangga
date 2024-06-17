/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxLayoutDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.Container; //Memanggil Library Container
import javax.swing.*; //Memanggil semua isi dari Library swing
public class BoxLayoutDemo extends JFrame {

    public BoxLayoutDemo() {
        super("Ferdiyansyah"); //Memanggil superClass JFrame dan mengubah Title Frame
        Container c = getContentPane();  //membuat properti untuk Container
        Box box = new Box(BoxLayout.Y_AXIS); //Membuat box dan mengatur aray layoutnya
        JLabel l1 = new JLabel("React"); //Membuat Label
        JTextArea t1 = new JTextArea("Pratikum React", 10,15); //Membuat Text Area dengan value
        JLabel l2 = new JLabel("Node"); //Membuat Label
        JTextArea t2 = new JTextArea("Pratikum Node", 10,15); //Membuat Text Area dengan value
        JButton b1 = new JButton("Tombol 1"); //Membuat Button
        JButton b2 = new JButton("Tombol 2"); //Membuat Button
        box.add(l1); //mengisi box dengan label l1
        box.add(new JScrollPane(t1)); //mengisi box dengan scrolling textarea t1
        box.add(b1); //mengisi box dengan button b1
        box.add(b2); //mengisi box dengan button b2
        box.add(l2); //mengisi box dengan label l2
        box.add(new JScrollPane(t2)); //mengisi box dengan scrolling textarea t2
        c.add(box); //mengisi container dengan box
    }
    public static void main(String[] args) {
        BoxLayoutDemo dm = new BoxLayoutDemo(); //Membuat Object BoxLayoutDemo
        dm.setSize(300, 300); //Mengatur ukuran Frame
        dm.setVisible(true); //Menampilkan isi Konten
        dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Membuat fungsi Exit
    }
}

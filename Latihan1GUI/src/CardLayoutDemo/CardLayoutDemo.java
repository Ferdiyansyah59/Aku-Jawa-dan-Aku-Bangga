/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardLayoutDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.CardLayout; //Memanggil library CardLayout
import java.awt.Container; //Memanggil library Container
import java.awt.event.ActionEvent; //Memanggil library ActionEvent
import java.awt.event.ActionListener; //Memanggil library ActionListener
import javax.swing.JFrame; //Memanggil library JFrame 
import javax.swing.JButton; //Memanggil library JButton
import java.awt.Color; //Meanggil library Color
public class CardLayoutDemo extends JFrame implements ActionListener{
    CardLayout card; //Membuat properti Card Layout
    JButton b1,b2,b3; //Membuat properti button
    Container c; //Membuat Properti Container
    
    public CardLayoutDemo() {
        super("Ferdiyansyah"); //Memanggil superClass JFrame dan membuat title frame
        c = getContentPane(); //membuat Container untuk mengisi content
        card = new CardLayout(40, 30); //Membuat card dengan ukuran (P, L)
        c.setLayout(card); //Mengeset isi content dalam Container dengan card
        
        b1 = new JButton("Java"); //Membuat Button dengan value String
        b2 = new JButton("JavaScript"); //Membuat Button dengan value String
        b3 = new JButton("Python"); //Membuat Button dengan value String

        b1.addActionListener(this); //Membuat action klik pada button yang bersangkutan
        b2.addActionListener(this); //Membuat action klik pada button yang bersangkutan
        b3.addActionListener(this); //Membuat action klik pada button yang bersangkutan
        
        c.add(b1); //Mengisi Container dengan button
        c.add(b2); //Mengisi Container dengan button
        c.add(b3); //Mengisi Container dengan button
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(c); //Logic ketika di klik maka akan pindah ke card berikutnya di dalam Container ayang sama
    }

    
    public static void main(String[] args) {
        CardLayoutDemo cl = new CardLayoutDemo(); //Membuat Object CardLayoutDemo
        cl.getContentPane().setBackground(Color.RED); //Mengubah background Color
        cl.b1.setBackground(Color.YELLOW); //Mengubah warna Button
        cl.b2.setBackground(Color.GREEN); //Mengubah warna Button
        cl.b3.setBackground(Color.BLUE); //Mengubah warna Button
        cl.setSize(400, 400); //mengatur ukuran frame (L, P)
        cl.setVisible(true); //Menampilkan isi konten
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Membuat fungsi exit jika tombol close di klik
    }


}

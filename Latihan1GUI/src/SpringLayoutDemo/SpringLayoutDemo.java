/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringLayoutDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.Container; //Memanggil libarary Container
import javax.swing.*; //Memanggil semua isi dari library swing
public class SpringLayoutDemo {
    JFrame f; //membuat properti JFrame
    Container c; //Membuat properti Container
    SpringLayout sl; //Membuat properti Spring Layout
    JLabel l; //Membuat properti JLabel
    JTextField t; //Membuat properti JTextField
    
    public SpringLayoutDemo() {
        f = new JFrame("Ferdiyansyah"); //Membuat Title Frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Membuat fungsi exit jika tombol close di klik
        c = f.getContentPane(); //Membuat Container dari frame
        sl = new SpringLayout(); //Membuat SpringLayout
        c.setLayout(sl); //Mengisi Container dengan Spring Layout
        l = new JLabel("Ini Label"); //Membuat Label
        t = new JTextField("Tuliskan Text", 20); //Membuat form dengan value Tuliskan Text, dan mengatu panjang
        c.add(l);//Mengisi  Container dengan label
        c.add(t); //Mengisi Container dengan Form
        
        
        //Mengatur batasan untuk label sehingga berada di posisi (20, 10)
        //Dibaca dibaratnya label ada ujung container dengan jarak 20px 
        sl.putConstraint(SpringLayout.WEST, l, 20, SpringLayout.WEST, c);
        //Dibaca diutaranya label ada ujung container dengan jarak 10px
        sl.putConstraint(SpringLayout.NORTH, l, 10, SpringLayout.NORTH, c);
        
        //Mengatur batasan untuk textField agar posisinya berada di (sisiKananLabel  +60, 10)
        //Dibaca dibaratnya form dengan jarak 60px ada label (di hitng dari huruf terdepan labelya)
        sl.putConstraint(SpringLayout.WEST, t, 60, SpringLayout.WEST, l);
        //Dibaca di utaranya form ada ujung container dengan jarak 10px
        sl.putConstraint(SpringLayout.NORTH, t, 10, SpringLayout.NORTH, c);
        
        //Mengatur posisi content pane: sisi kanan 5px di luar sisi kanan textField dan sisi kirinya 
        //5px di bawah sisi bawah komponen terpanjang
        //Dibaca ditimurnya form ada ujung container dengan jarak 5px
        sl.putConstraint(SpringLayout.EAST, c, 5, SpringLayout.EAST, t);
        //di selatannya form ada ujung container dengan jarak 50px
        sl.putConstraint(SpringLayout.SOUTH, c, 50, SpringLayout.SOUTH, t);
        
        f.pack(); //Membuat fungsi agar ukuran frame mengikuti isi content
        f.setVisible(true); //menampilkan frame
        
    }
    
    public static void main(String[] args) {
        SpringLayoutDemo sl = new SpringLayoutDemo(); //Membut object SpringLayoutDemo
    }
}

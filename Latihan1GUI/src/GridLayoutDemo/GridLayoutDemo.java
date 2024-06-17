/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridLayoutDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.Color;  //Memanggil library Color
import java.awt.Container;  //Memanggil library Container
import java.awt.GridLayout;  //Memanggil library CardLayout
import javax.swing.JButton;  //Memanggil library JButton
import javax.swing.JFrame;  //Memanggil library JFrame
public class GridLayoutDemo extends JFrame{
    JButton tombol[]; //membuat properti JButton dengan value berupa array
    String m[] = {"Satu", "Dua","Tiga","Empat","Lima","Enam"}; //Membuat array yang valuenya string
    Container c; //Membuat properti Container
    GridLayout g; //Membuat properti GridLayout
    
    public GridLayoutDemo() {
        super("Ferdiyansyah"); //Memanggil superClass JFrame dan memberi title frame
        g = new GridLayout(3, 2, 5, 5); //membuat Grid (Row, Col, GepH, getV)
        c = getContentPane(); //Membuat container untuk mengisi content
        c.setLayout(g); //mengeset isi content dalam Container dengan GridLayout
        tombol = new JButton[m.length]; //Membuat button dengan value dari array m dan pangjangnya menyesuaikan
        for(int i = 0; i<m.length;i++){
            //Membuat tombol berdasarkan value m yang jumlahnya menyesuaikan panjang index variabel m dan 
            //mengeset value button berdasarkan isi dari index variabel m
            tombol[i] = new JButton(m[i]); 
            c.add(tombol[i]); //mengisi Container dengan button berdasarkan indexnya
        }
        setSize(300, 300); //mengatur ukuran frame
        setVisible(true); //menampilkan isi konten
    }
    
    public static void main(String[] args) {
        GridLayoutDemo gl = new GridLayoutDemo(); //Membuat object untuk GridLayoutDemo
        gl.getContentPane().setBackground(Color.GRAY); //Mengubah background Color
        gl.tombol[0].setBackground(Color.RED); //Mengubah warna tombol
        gl.tombol[1].setBackground(Color.BLUE); //Mengubah warna tombol
        gl.tombol[2].setBackground(Color.WHITE); //Mengubah warna tombol
        gl.tombol[3].setBackground(Color.GREEN); //Mengubah warna tombol
        gl.tombol[4].setBackground(Color.YELLOW); //Mengubah warna tombol
        gl.tombol[5].setBackground(Color.PINK); //Mengubah warna tombol
        gl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Membuat fungsi exit jika tombol close di klik
    }
}

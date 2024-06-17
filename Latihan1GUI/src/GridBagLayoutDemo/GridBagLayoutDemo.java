/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridBagLayoutDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.GridBagConstraints; //Memanggil library GridBagConstriants
import java.awt.GridBagLayout; //Memanggil library GridBagLayout
import javax.swing.JFrame; //Memanggil library JFrame
import javax.swing.JButton; //Memanggil library JButton
import java.awt.Color; //Memanggil library Color
public class GridBagLayoutDemo {
    JFrame f; //Membuat properti JFrame
    GridBagLayout gbl; //Membuat properti GridLayout
    GridBagConstraints c; //Membuat Properti GridBagConstraints
    public GridBagLayoutDemo() {
        f = new JFrame("Ferdiyansyah"); //Membuat Title Frame
        gbl = new GridBagLayout(); //Membuat GridBagLayout
        c = new GridBagConstraints(); //Membuat GridBagConstraints
        f.getContentPane().setLayout(gbl); //Membuat frame lalu disi dengan GridBagLayout
        c.fill = GridBagConstraints.HORIZONTAL; //Membuat pembatasan isi secara Horizontal
        
        JButton j1 = new JButton("1"); //Membuat Button
        c.weightx = 2; //Ukuran Horizontal
        c.gridx = 0; //Menempati kolom ke 0
        c.gridy = 0; //menempati baris ke 0;
        gbl.setConstraints(j1, c); //membuat pembatasan button
        f.getContentPane().add(j1); //mengisi frame dengan button
        
        JButton j2 = new JButton("2"); //Membuat Button
        c.gridx = 1; //Menempati kolom ke 1
        c.gridy = 0; //menempati baris ke 0
        gbl.setConstraints(j2, c); //membuat pembatasan button
        f.getContentPane().add(j2); //mengisi frame dengan button
        
        JButton j3 = new JButton("3");  //Membuat Button
        c.ipady = 50; //Menambah Tinggi
        c.gridwidth = 2; //Tombol menempati 2
        c.gridx = 0; //Menempati kolom ke 0
        c.gridy = 1; //menempati baris ke 1
        gbl.setConstraints(j3, c); //membuat pembatasan button
        f.getContentPane().add(j3); //mengisi frame dengan button
        
        JButton j4 = new JButton("4"); //Membuat Button
        c.ipady = 50; //Mengatur tinggi 
        c.gridwidth = 1; //Tombol menempati 1 kolom
        c.gridx = 0; //Menempati kolom ke 0
        c.gridy = 2; //menempati baris ke 2
        gbl.setConstraints(j4, c); //membuat pembatasan button
        f.getContentPane().add(j4); //mengisi frame dengan button
        
        JButton j5 = new JButton("5"); //Membuat Button
        c.ipady = 0; //Mengatur tinggi 
        c.gridwidth = 1; //Tombol menempati 1 kolom
        c.gridx = 1; //Menempati kolom ke 1
        c.gridy = 2; //menempati baris ke 2
        c.anchor = GridBagConstraints.SOUTH; //Mengatur posisi dari button
        gbl.setConstraints(j5, c); //membuat pembatasan button
        f.getContentPane().add(j5); //mengisi frame dengan button
        
        JButton j6 = new JButton("6"); //Membuat Button
        c.weightx = 2; //Ukuran Horizontal
        c.gridx = 3; //Menempati kolom ke 3 Horizontal
        c.gridy = 0; //menempati baris ke 0 Vertical
        gbl.setConstraints(j6, c); //membuat pembatasan button
        f.getContentPane().add(j6); //mengisi frame dengan button
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Membuat fungsi exit jika tombol close di klik
        f.pack(); //membuat fungsi agar ukuran frame mengikuti isi konten
        f.setVisible(true); //menampilkan konten
        
    }
    
    public static void main(String[] args) {
        GridBagLayoutDemo gb = new GridBagLayoutDemo(); //Membuat onject GridBagLayoitDemo
        gb.f.getContentPane().setBackground(Color.YELLOW); //Mengubah Background Color
    }
}

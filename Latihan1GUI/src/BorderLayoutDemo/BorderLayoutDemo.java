/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BorderLayoutDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.BorderLayout; //Memanggil Library BorderLayout
import java.awt.Container;  //Memanggil Library Container
import java.awt.event.ActionEvent;  //Memanggil Library ActionEvent
import java.awt.event.ActionListener;  //Memanggil Library ActionListener
import javax.swing.JButton; //Memanggil Library JButton
import javax.swing.JFrame; //Memanggil Library JFrame
import java.awt.Color; //Mengambil Library Color
public class BorderLayoutDemo extends JFrame implements ActionListener {
    private final JButton tombol[];  //membuat properti untuk JButton
    private final String names[]={"Hilangkan North", "Hilangkan South",
        "Hilangkan East", "Hilangkan West",  "Hilangkan Center"}; //Membuat value String untuk tiap tombol
                                                                  // dengan tipe data array
    private final BorderLayout b1; //Membuat properti BorderLayout
    
    public BorderLayoutDemo() {
        super("Ferdiyansyah"); //Memanggil superClass JFrame dan membuat Title Frame
        Container c = getContentPane(); //Membuat Properti Container
        b1 = new BorderLayout(10 ,10); //Membuat border Baru dan membuat gep antar item
        c.setLayout(b1); //mengeset BorderLayout ke dalam Container
        tombol = new JButton[names.length]; //Membuat tombol dengan Value berdasarkan array names
      
        for(int i = 0; i<names.length;i++) { 
            tombol[i] = new JButton(names[i]);
            tombol[i].addActionListener(this); 
        } //membuat perulangan untuk mengisi value dari setiap button
        
        c.add(tombol[0], BorderLayout.NORTH); //mengisi Container dengan button dan membuat BorderLayout
        c.add(tombol[1], BorderLayout.SOUTH); //mengisi Container dengan button dan membuat BorderLayout
        c.add(tombol[2], BorderLayout.EAST); //mengisi Container dengan button dan membuat BorderLayout
        c.add(tombol[3], BorderLayout.WEST); //mengisi Container dengan button dan membuat BorderLayout
        c.add(tombol[4], BorderLayout.CENTER); //mengisi Container dengan button dan membuat BorderLayout
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0;i<tombol.length;i++) {
           if(e.getSource() == tombol[i]) {
               tombol[i].setVisible(false);
           }else {
               tombol[i].setVisible(true);
               b1.layoutContainer(getContentPane());
           }
       } //Membuat fungsi kalau kita klik buttonnya akan hilang
    }
    
    
    public static void main(String[] args) {
        BorderLayoutDemo dm = new BorderLayoutDemo(); //Membuat object dari BorderLayoutDemo
        dm.getContentPane().setBackground(Color.RED); //Mengubah Background
        dm.setVisible(true); //Menampilkan Content
        dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Membuat Fungsi Exit
    }


    
}

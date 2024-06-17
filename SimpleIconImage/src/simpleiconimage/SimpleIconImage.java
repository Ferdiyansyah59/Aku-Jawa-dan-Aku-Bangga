/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleiconimage;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*;
import java.net.URL; //memanggil library untul URL 
public class SimpleIconImage extends JFrame {
    JButton[] buttons = new JButton[10];
    
    public SimpleIconImage () {
        //setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel awa = new JPanel();
        URL url = SimpleIconImage.class.getResource("./alarm.png"); //membuat properti
                                                                    //untuk menangkap gambar dari file
        ImageIcon icon = new ImageIcon(url); //Membuat properti untuk menangkap gambar dari URL
        for(int i = 0; i< 10;i++) {
            buttons[i] = new JButton(icon); //mengisi jumlah button berdasarkan i dan buttonnya jadi icon
            awa.add(buttons[i]); //menisi panel dengan properdi button
            setContentPane(awa); //menempel panel dengan object awa
            pack(); //Membuat ukurannya framnya sesuai dengan valuenya
            
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleIconImage ic = new SimpleIconImage(); //membuat object dari 
        ic.setVisible(true); //Menampilkan frame
    }
    
}

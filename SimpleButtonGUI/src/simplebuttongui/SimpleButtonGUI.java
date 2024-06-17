/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebuttongui;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*; //mengimport libarary dari swing
public class SimpleButtonGUI extends JFrame {
    JButton abort = new JButton("Abort"); //Membuat properti untuk Button dari Swing
    JButton retry = new JButton("Retry"); //Membuat properti untuk Button dari Swing
    JButton fail = new JButton("Fiele"); //Membuat properti untuk Button dari Swing
    public SimpleButtonGUI () {
        super("Buttons"); //Membari Title pada frame
        setSize(300, 140); //Mengatur ukuran frame (LxP)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Membuat fungsi jika tombol X di tekan 
                                                        //maka frame dan aplikaasi akan keluar
        JPanel pane = new JPanel(); //Membuat kontainer panel
        pane.add(abort); //Mengisi panel dengan properti abort
        pane.add(retry); //Mengisi panel dengan properti retry
        pane.add(fail); //Mengisi panel dengan properti fail
        setContentPane(pane); //Menempel panel dengan object pane
    }
 
    public static void main(String[] args) {
        SimpleButtonGUI sb = new SimpleButtonGUI();
        sb.show(); //Menampilkan frame SimpleButtonGUI 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleformgui;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*; //Mengimport library swing
public class SimpleFormGUI extends JFrame {
    JTextField username = new JTextField(15); //membuat properti untuk form input dengan parameter panjangnya
    JPasswordField password = new JPasswordField(15);//membuat properti untuk form input dengan parameter panjangnya
    JTextArea cm = new JTextArea(8 ,15); //membuat properti untuk form input dengan parameter (P, L)
    
    public SimpleFormGUI() {
        super("Simple Form"); //Memanggil SuperClass JFrame dan memberi title pada form input
        setSize(260, 300); //Mengatur ukuran Frame (L, P)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel(); //Properti membuat Kontainer Panel
        JLabel usernameLabel = new JLabel("Username: "); //Properti membuat label 
        JLabel passwordLabel = new JLabel("Password: "); //Properti membuat label
        JLabel commentsLabel = new JLabel("Comments: "); //Properti membuat label
        cm.setLineWrap(true); //Fungsi untuk melakukkan wraping
        cm.setWrapStyleWord(true); //Menentukan Wrapping perkata atau perkarakter
        password.setEchoChar('*'); //Mengcustom value password
        JScrollPane scroll = new JScrollPane(cm,              //Membuat properti untuk fungsi scrolling
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,   //Menentukan jenis scrolling
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //Menentukan jenis scrolling
        
        pane.add(usernameLabel);  //Mengisi panel dengan properti usernameLabel
        pane.add(username); //Mengisi panel dengan properti username
        pane.add(passwordLabel); //Mengisi panel dengan properti passwordLabel
        pane.add(password); //Mengisi panel dengan properti password
        pane.add(commentsLabel); //Mengisi panel dengan properti commentsLabel
        pane.add(scroll);   //Mengisi panel dengan properti scrooll yang dimana scrool include dengan textarea
        setContentPane(pane); //menempel panel dengan properti pane
        show(); //menampilkan frame
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleFormGUI form = new SimpleFormGUI(); //membuat object dari SimpleFormGUI
    }
    
}

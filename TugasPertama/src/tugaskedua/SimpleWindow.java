/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaskedua;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.JWindow;  //Mengimport library dari swing
public class SimpleWindow extends JWindow  { //Extends/Mewarisi dari class parent
    public SimpleWindow() { //Constructor Method
        super();  //mengambil data superclass
        setBounds(255, 225, 300, 150); //Mengatur tata letak dan ukuran 
                                       //(dari kiri ke kanan,dari atas ke bawah,lebar,tinggi
    }
    public static void main(String[] args) {
        SimpleWindow sw = new SimpleWindow(); //Pembuatan objek dari class Simple Window
        sw.setVisible(true); //Menampilkan isi dari objek sw
        for(int i = 0; i<100;i++)  //Melakukan perulangan sebanyak 100
        System.out.print(i+"");  //Menampilkan hasil perulangan
        sw.setVisible(false); 
        System.exit(0); // Jika proses perulangan selesai maka akan tertutup
    }
}

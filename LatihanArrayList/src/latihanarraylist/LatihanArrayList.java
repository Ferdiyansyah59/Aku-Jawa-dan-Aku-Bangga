/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanarraylist;

/**
 *
 * @author ferdiyansyah
 */
import java.util.ArrayList;
public class LatihanArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> buah = new ArrayList();
        
        buah.add("Salak");
        buah.add("mangga");
        buah.add("jeruk");
        buah.add("pisang");
        buah.add("anggur");
        buah.add("pear");
        
        //menampilkan array
        System.out.println(buah.get(0));
        System.out.println(buah);
        
        //menghapus Array
        buah.remove(3);
        System.out.println(buah);
        System.out.println(" ");
        
        //Mengganti Index
        buah.set(5 , "Delima");
        System.out.println(buah);
        System.out.println(" ");
        
        //menampilkan ukuran array
        System.out.println(buah.size());
        
        //menghapus semua data
//        buah.clear();
//        System.out.println(buah);
        
        for(int i=0;i<buah.size();i++)
        {
            System.out.println(buah.get(i));
        }
        System.out.println(" ");
        
        for(String i : buah)
        {
            System.out.println(i);
        }
        //mengecek arrays kosong
        System.out.println(buah.isEmpty());
    }
    
}

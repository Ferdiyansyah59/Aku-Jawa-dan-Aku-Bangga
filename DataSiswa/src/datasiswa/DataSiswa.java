/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasiswa;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class DataSiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner awa = new Scanner(System.in);
       data dt = new data();
       File doc = new File("data.txt");
       
       dt.create();
       System.out.println(" ");
       int i = 0;
       while(i==0){
           System.out.println(" ");
           System.out.println("==========================");
           System.out.println("1.Input");
           System.out.println("2.Output");
           System.out.println("3.Exit");
           System.out.print("Pilih : ");
           String pilih = awa.next();
           if("1".equals(pilih)){
               dt.isi();
           }
           else if("2".equals(pilih)){
               dt.baca();
           }
           else if("3".equals(pilih)){
               System.exit(i);
           }
           else{
               System.out.println("Pilihan tidak tersedia");
           }
           
       }
       
    }
    
}

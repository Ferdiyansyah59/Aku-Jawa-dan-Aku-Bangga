/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operasibilangan;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner awa = new Scanner(System.in);
        
      
        Penjumlahan pj = new Penjumlahan();
        Pengurangan pg = new Pengurangan();
        Perkalian pk = new Perkalian();
        Pembagian pm = new Pembagian();
        
        System.out.println("1.Penjumlahan");
        System.out.println("2.Pengurangan");
        System.out.println("3.Perkalian");
        System.out.println("4.Pembagian");
        System.out.print("Pilih : ");
        String pilih = awa.next();
        
        
        if("1".equals(pilih))
        {
            pj.hasilOperasi();
           
        }
        else if("2".equals(pilih))
        {
            pg.hasilOperasi();
        }
        else if("3".equals(pilih))
        {
            pk.hasilOperasi();
        }
        else if("4".equals(pilih))
        {
            pm.hasilOperasi();
        }
        else
        {
            System.out.println("Pilihan Tidak Ada");
        }
        
    }
}

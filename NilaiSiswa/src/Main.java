/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class Main {

    
    public static void main(String[] args) {
        Scanner awa = new Scanner (System.in);
        
        parent pa = new parent();
        Tugas tg = new Tugas();
        UTS ut = new UTS();
        UAS ua = new UAS();
        
        pa.NilaiSiswa();
        System.out.println(" ");
        tg.NilaiSiswa();
        ut.NilaiSiswa();
        ua.NilaiSiswa();
        
        Double total = tg.tugas() + ut.uts() + ua.uas();
        
        System.out.println("--------------------------------------------------");
        if(total > 70)
        {
            
            System.out.println("Nilai Tugas : " + tg.tugas());
            System.out.println("Nilai UTS   : " + ut.uts());
            System.out.println("Nilai UAS   : " + ua.uas());
            System.out.println("Total Nilai = " + total);
           
            if (total > 90) {
                System.out.println("\nPredikat A" );
            }
            else if(total > 80)
            {
                System.out.println("\nPredikat B");
            }
            else if(total > 80)
            {
                System.out.println("\nPredikat C");
            }
            else if(total > 70)
            {
                System.out.println("\nPredikat C");
            }
            System.out.println("Keterangan : Lulus");
                    
        }
        else if(total < 70)
        {
            System.out.println("Nilai Tugas : " + tg.tugas());
            System.out.println("Nilai UTS   : " + ut.uts());
            System.out.println("Nilai UAS   : " + ua.uas());
            System.out.println("Total Nilai = " + total);
           
            
            
            if(total > 60)
            {
                System.out.println("\nPredikat D");
            }
            else if(total < 60)
            {
                System.out.println("\nPredikat D");
            }
             System.out.println("Keterangan : Tidak Lulus");
            System.out.println("\nPerbaikan:");
            tg.perbaikan();
            ut.perbaikan();
            ua.perbaikan();
        }
        
    }
    
}

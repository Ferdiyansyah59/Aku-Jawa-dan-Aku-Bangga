/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pencarianbilangan;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class PencarianBilangan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner awa = new Scanner(System.in);
        pencarian p = new pencarian();
        
        int x = 0;
        
        while(x == 0)
        {
        
        System.out.println("================Cari===============");
        System.out.println("1.Pencarian Bilangan               ");
        System.out.println("2.Menentukan jumlah karakter String");
        System.out.println("3.Exit                             ");
        System.out.println("===================================");
        System.out.print("pilihan anda : ");
        String pilih = awa.next();
        System.out.println("=====================================");
        
        if("1".equals(pilih))
        {
            p.cari();
        }
        else if("2".equals(pilih))
        {
            p.cariString();
        }
        else if("3".equals(pilih))
        {
            System.exit(x);
        }
        else
        {
            System.out.println("Pilihan gak ada gan");
            
        }
                
        
        
       }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputmtk;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class InputMTK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        
        sisiMiring sm = new sisiMiring();
        ABC cba = new ABC();
        
        int a = 0;
        
        while(a==0)
        {
        System.out.println("=====Input MTK=====");
        System.out.println("1.Phytagoras");
        System.out.println("2.Rumus ABC");
        System.out.println("3.Exit");
            System.out.print("Pilih : ");
        String pilih = awa.next();
        
        if("1".equals(pilih))
        {
            sm.miring();
        }
        else if("2".equals(pilih))
        {
            cba.abc();
        }
        else if("3".equals(pilih))
        {
            System.exit(a);
        }
        else
        {
            System.out.println("Pilihan Tidqak Tersedia");
        }
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingkaran;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class Lingkaran {

   Scanner awa = new Scanner(System.in);
    
   public double phi = 3.14;
   public double r;
   public double luas;
   public double keliling;
   

    
   public double R()
   {
       System.out.print("Masukkan jari-jari Lingkaran = ");
       r = awa.nextDouble();
       return r;
   }
     
   public double Luas()
   {
       luas = phi*(r*r);
       return luas;
   }
   public double Keliling()
   {
       keliling = 2*phi*r;
       return keliling;
   }
}

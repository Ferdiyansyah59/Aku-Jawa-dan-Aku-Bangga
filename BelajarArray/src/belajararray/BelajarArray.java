/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajararray;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class BelajarArray {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       Scanner awa = new Scanner(System.in);
       
       
      
       
        System.out.print("Masukkan Banyak buah : ");
        int a = awa.nextInt();
        
        
      
       for(int i = 0 ; i < a ; i++)
       {
         
           System.out.print("Buah ke-" + (i+1) + " : ");
           buah[i] = awa.next();
       }
       
       for(String b : buah)
       {
           System.out.println(b);
       }
    }
    
}

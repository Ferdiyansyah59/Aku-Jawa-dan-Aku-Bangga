/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bujursangkar;

/**
 *
 * @author ferdiyansyah
 */  
import java.util.Scanner;
public class BujurSangkar2 {
    public static void main(String[] args) {
        
        
        Scanner apa = new Scanner(System.in);
        System.out.println("\tBUJURSANGKAR");
        System.out.println("==========================");
        
        BujurSangkar awa = new BujurSangkar();
        int a = awa.Sisi();
        
        
        if(a <= 0)
        {  
            
             System.out.println("Sisi tidak boleh negatif");
//            System.out.println("Sisi = " + a);
//             System.out.println("Luas Bujursangkar = " + awa.Luas());
//             System.out.println("Keliling Bujursangkar = " + awa.Keliling());
           
        }
        else{
            System.out.println("Sisi = " + a );
            System.out.println("Luas Bujursangkar = " + awa.Luas());
        System.out.println("Keliling Bujursangkar = " + awa.Keliling());
        
        }
       
        
        
        
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terneryoperator;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class TerneryOperator {

    /**
     * @param args the command line arguments
     */
     public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
     }
   
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
//        
//        int input ;
//        String x;
//        
//        System.out.println("Masukkan Nilai : ");
//        input = awa.nextInt();
//        
//        x = (input >= 80) ? ("Sukses") : ("Redmed");
//        
//        System.out.println(x);
//        
//        boolean ap = true;
//        do{
//        System.out.print("Masuk : ");
//        String a = awa.next();
//        
//        if("1".equals(a) || "2".equals(a) || "3".equals(a))
//        {
//            ap = true;
//            System.out.println(ap);
//        }
//        else if("4".equals(a) || "5".equals(a))
//        {
//            ap = false;
//            System.out.println(ap);
//        }
//        }while(ap);
//        
//        clearScreen();
        
        
        for(int a = 0 ; a<=10; a++)
        {
            System.out.println("Nilai " + (a));
        }
        
        
        
}
        
    }

    
    


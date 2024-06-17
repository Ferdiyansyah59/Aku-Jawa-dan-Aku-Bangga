/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabung;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class Utama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
         
        int hitung ;
        Scanner key = new Scanner(System.in);
        
         Scanner apa = new Scanner(System.in);
       Input1 angka1 = new Input1();
       angka1.angka();
       Input2 angka2 = new Input2();
       angka2.angka();
       
        
         System.out.println("-----KALKULATOR-----\n");
        
        System.out.println("KALKULATOR");
        System.out.println("1.+");
        System.out.println("2.-");
        System.out.println("3.*");
        System.out.println("4./");
        System.out.println("5.%");
        System.out.print("Pilih : ");
        hitung = key.nextInt();
        
        if(hitung == 1)
        {
            Output java = new Output();
            java.hasil();
        }
     
        else
        {
            System.out.println("\nOperator tidak tersedia!");
        }
         }
    
}

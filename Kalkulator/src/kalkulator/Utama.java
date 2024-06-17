/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class Utama {
    
    
     public static void main(String[] args) {
        
         
         
        int hitung ;
        Scanner key = new Scanner(System.in);
       
        Penjumlahan jumlah = new Penjumlahan();
        Pengurangan kurang = new Pengurangan();
        Perkalian kali = new Perkalian();
        Pembagian bagi = new Pembagian();
        Modulus modul = new Modulus();
        
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
            jumlah.tambah();
        }
        else if(hitung == 2)
        {
            kurang.kurang();
        }
        else if(hitung == 3)
        {
            kali.kali();
        }
        else if(hitung == 4)
        {
            bagi.bagi();
        }
        else if(hitung == 5)
        {
            modul.modulus();
        }
        else
        {
            System.out.println("\nOperator tidak tersedia!");
        }
        
        
        
        
    }
 
}


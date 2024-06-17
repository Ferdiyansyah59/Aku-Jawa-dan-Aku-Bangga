/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.smk.pkg24;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        Transaksi tr = new Transaksi();
        
        System.out.println("=====BANK 24=====");
        System.out.print("Masukkan PIN : ");
        int pin = awa.nextInt();
        
        if(pin == 551199)
        {
        
        int a = 0;
        while(a ==0)
        {
        System.out.println("\n===Layanan Bank===");
        System.out.println("1.Menabung");
        System.out.println("2.Cek Saldo");
        System.out.println("3.Transfer");
        System.out.println("4.Menarik");
        System.out.println("5.Exit");
        System.out.print("pilih : ");
        String pilih = awa.next();
        
        switch(pilih)
        {
        case "1" : 
            tr.menabung();
        break;
        case "2" :
            tr.saldo();
            break;
        case "3" :
            tr.transfer();
            break;
        case "4" :
            tr.menarik();
            break;
        case "5" :
            System.exit(a);
            break;
        default :
            System.out.println("Pilihan Tidak Tersedia");
            break;
        }
        
        }
        }
        else 
        {
            System.out.println("Pin Tidak Tersedia");
            
        }
    }           
}

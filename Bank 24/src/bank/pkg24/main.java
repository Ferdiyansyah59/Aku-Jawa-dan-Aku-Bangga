/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.pkg24;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class main {
    
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        
        
        transaksi trans = new transaksi(50000);
        
       
        
        System.out.print("Masukkan Pin : ");
        int pin = awa.nextInt();
        
        if(pin == 551199)
        {
        int a = 0;
        while(a == 0)
        {
        System.out.println("\n===Bank SMK 24===");
        System.out.println("1.Cek Saldo");
        System.out.println("2.Menabung");
        System.out.println("3.Transfer");
        System.out.println("4.Menarik");
        System.out.println("5.Exit");
        System.out.print("Pilihan Anda : ");
        String pilih = awa.next();
        
        switch(pilih)
        {
            case "1" :
                trans.cekSaldo();
                break;
            case "2" :
                System.out.print("Nominal Uang : Rp.");
                double tb = awa.nextDouble();
                trans.menabung(tb);
                break;
            case "3" :
                trans.transfer();
                break;
            case "4" :
                trans.menarik();
                break;
            case "5" :
                System.exit(a);
                 break;
        }
        
        }
    }
        else{
            System.out.println("Pin Salah");
        }
    }
    
    
}

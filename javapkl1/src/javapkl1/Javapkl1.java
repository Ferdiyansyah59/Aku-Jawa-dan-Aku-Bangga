/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapkl1;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class Javapkl1 {

    /**
     * @param args the command line arguments
     */
        Scanner awa = new Scanner(System.in);
        public void nama(){
            
        int a = 1;
        while(a == 1){  
            
        System.out.print("Masukkan Nama Barang : ");
        String nama = awa.next();
        System.out.print("Jumlah Barang : ");
        int jumlah = awa.nextInt();
        System.out.print("Masukkan Harga : ");
        int harga = awa.nextInt();

        
        System.out.println("-----------------------------------------");
     
        if(harga >= 100000){
            int diskon = harga / 100 * 10;
            int total = harga - diskon;
            int bayar1 = total * jumlah;
            if(jumlah >= 10){
                int diskon2 = bayar1 / 100 * 5;
                int bayar2 = bayar1 - diskon2;
                
                System.out.println(nama + " " + jumlah + "\t\t Rp." + harga*jumlah);
                System.out.println("Selamat anda Mendapatkan diskon 10% dan 5%");
                System.out.println("Total Belanja   :Rp. " + bayar2);
            }
            else{
                System.out.println(nama + " " + jumlah + "\t\t Rp." + harga*jumlah);
                System.out.println("Selamat anda Mendapatkan diskon 10%");
                System.out.println("Total Belanja   :Rp. " + bayar1 + ",-");
            }

        }
        else if(harga >= 50000){
            int diskon = harga / 100 * 5;
            int total =  harga - diskon;
            int bayar = total * jumlah;
            if(jumlah >= 10){
                int diskon2 = bayar / 100 *5;
                int bayar2 = bayar - diskon2;
                
                System.out.println(nama + " " + jumlah + "\t\t Rp." + harga*jumlah);
                System.out.println("Selamat anda mendapatkan diskon 5% dan 5%");
                System.out.println("Total Belanja   :Rp. " + bayar2 + ",-");
            }
            else{
                System.out.println(nama + " " + jumlah + "\t\t Rp." + harga*jumlah);
                System.out.println("Selamat anda mendapatkan diskon 5%");
                System.out.println("Total Belanja   :Rp. " + bayar + ",-");
            }
            
        }
        else if(harga < 50000){
            int bayar = jumlah * harga;
            if(jumlah >= 10){
                int diskon2 = bayar / 100 * 5;
                int bayar2 = bayar - diskon2;
                
                System.out.println("Selamat anda mendaptkan diskon 5%");
                System.out.println(nama + " " + jumlah + "\t\t Rp." + harga*jumlah);
                System.out.println("Total Belanja   :Rp. " + bayar2 + ",-");
            }
            else{
                System.out.println(nama + " " + jumlah + "\t\t Rp." + harga*jumlah);
                System.out.println("Total Belanja   :Rp. " + bayar + ",-");
                
            }
            

        }
            System.out.println("\n==================================");

    }
        }
    
    
    
    
    public static void main(String[] args) {
        
     try{
        Javapkl1 jp = new Javapkl1();
        jp.nama();
       }  
       catch(Exception en){
           System.out.println(en);
       }
        
        

    }
    
}

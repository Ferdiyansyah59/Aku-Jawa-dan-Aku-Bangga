/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspbom2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ferdi
 */
public class Ferdiyansyah_10121480 {
    
    static ArrayList<Character> paket = new ArrayList<Character>();
    static int[][] pesanan = new int[10][10];
    static Scanner awa = new Scanner(System.in);
    
    static void output(){
        System.out.println("\n\n==============================================");
        System.out.println("===             Struk Belanja             ===");
        System.out.println("==============================================");
        int total = 0, ppn = 0, bayar = 0, k = 0;
        for(int j = 0; j < paket.size(); j++){
            System.out.println("Paket-" + paket.get(j));
            System.out.println("Harga Satuan: Rp." + pesanan[j][0]);
            System.out.println("Quantity: " + pesanan[j][1]);
            System.out.println("Harga Total Paket Rp." + pesanan[j][2]);
            System.out.println("----------------------------------------------");
            total += pesanan[j][2];
            
            ppn = (int)(pesanan[j][0] * 0.11);
        }
         
        System.out.println("\nTotal Belanja: "+ total);
        if (total > 150000){
            System.out.println("Anda mendapatkan Diskon 10%");
            System.out.println("Diskon: " + (int)(total * 0.1));
            total = (int) (total * 0.9);
            System.out.println("Total Belanja setelah diskon: " + total);
        }
  
        int totalBayar = total + ppn;
        boolean kurang = true;
        
        System.out.println("PPN (11%): " + ppn);
        System.out.println("Total Bayar: " + totalBayar);
        while(kurang){
            System.out.print("Jumlah uang customer: ");
            bayar = awa.nextInt();
            
            bayar += k;
            if (bayar >= totalBayar){
                kurang = false;
            }else {
                System.out.println("Uang customer kurang Rp." + (totalBayar - bayar));
                k += bayar;
            }
        }
        System.out.println("Tunai Rp."+bayar);
        System.out.println("Kembalian Rp."+ (bayar - totalBayar));
    }
    
    static int quantity (){
        System.out.print("Masukkan jumlah qty: ");
        int qty = awa.nextInt();
        return qty;
    }
    
    static void ar(int i, int harga, char p){
        paket.add(p);
        pesanan[i][0] = harga;
        pesanan[i][1] = quantity();
        pesanan[i][2] = pesanan[i][0] * pesanan[i][1];  
    }
    
    
    public static void main(String[] args) {
        char ulang;
        int pil, i = 0;
        do{
            System.out.println("Daftar Menu Makanan");
            System.out.println("---------------------");
            System.out.println("1. Paket A (Ayam Rebus + Jus Mengkudu) Rp. 20.000");
            System.out.println("2. Paket B (Ayam Bakar + Es Teh Manis) Rp. 25.000");
            System.out.println("3. Paket C (Soto Daging + Jus Nanas) Rp. 30.000");
            System.out.println("4. Paket D (Pecel Lele + Teh Tawar) Rp. 15.000");
            System.out.println("");
            System.out.print("Pilihan Anda: ");
            pil = awa.nextInt();
            switch(pil){
                case 1:
                    ar(i, 20000, 'A');
                    i++;
                break;
                case 2:
                    ar(i, 25000, 'B');
                    i++;
                break;
                case 3:
                    ar(i, 30000, 'C');
                    i++;
                break;
                case 4: 
                    ar(i, 15000, 'D');
                    i++;
                break;
                default:
                    System.out.println("Pilihan Anda Tidak ditemukan");
            }
            System.out.println("----------------------------------------------");
            System.out.print("Ingin memilih (y/t)");
            ulang = awa.next().charAt(0);
        }while(ulang!='t');      
        output();
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan3;

import java.util.Scanner;

/**
 *
 * @author ferdi
 */
public class pertemuan3d {
    public static void main(String[] args) {
        
        
//        Tugas tambahin harga, jumlah yang dibeli, diskon, ada struk, ppn;
        Scanner awa = new Scanner(System.in);
        int pil, qty, total, diskon, totalBelanja = 0; char ulang;
        
        
        do{
            System.out.println("Daftar Menu Makanan");
            System.out.println("-------------------");
            System.out.println("1. Paket A (Ayam Rebus + Jus Mengkudu) Rp. 20.000");
            System.out.println("2. Paket B (Ayam Bakar + Es Teh Manis) Rp. 50.000");
            System.out.println("3. Paket C (Soto Daging + Jus Nanas) Rp. 100.000");
            System.out.println("4. Paket D (Pecel Lele + Teh Tawar) Rp. 25.000");
            System.out.println("");
            System.out.print("Pilihan Anda: ");
            pil = awa.nextInt();
            
            switch(pil){
                case 1:
                    System.out.println("Memilih Paket A");
                    System.out.print("Mau beli berapa biji? ");
                    qty = awa.nextInt();
                    total = qty * 20000;
                    if (total > 100000){
                        System.out.println("Kamu dapat diskon 20%");
                      
                    }
                break;
                case 2:
                    System.out.println("Meilih Paket B");
                break;
                case 3:
                    System.out.println("Memilih Paket C");
                break;
                case 4:
                    System.out.println("Memilih Paket D");
                break;
                default:
                    System.out.println("Pilihan yang anda cari tidak ditemukan!");
            }
            
            System.out.println("");
            System.out.print("Ingin memilih (y/t)");
            ulang = awa.next().charAt(0);
        }while(ulang!='t');
        
        System.out.println("Yang dibeli: " + pil);
        System.out.println("Total: " + total);
        System.out.println("");
        System.out.println("PPN : " + total * 0.02);
    }
}

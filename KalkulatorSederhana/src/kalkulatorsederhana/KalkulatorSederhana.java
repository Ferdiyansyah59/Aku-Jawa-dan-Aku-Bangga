/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatorsederhana;

/**
 *
 * @author ferdi
 */
import java.util.Scanner;


public class KalkulatorSederhana {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        Double angka1, angka2, jumlah;
        boolean an = true;
        char ab = 'C';
        
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.print("Pilih: ");
        String pilih = awa.next();
        
        System.out.print("Angka 1: ");
        angka1 = awa.nextDouble();
        System.out.print("Angka 2: ");
        angka2 = awa.nextDouble();
        
        if(pilih.equals("1")){
            jumlah = angka1 + angka2;
            System.out.println("Hasil: "+jumlah);
        }else if(pilih.equals("2")){
            jumlah = angka1 - angka2;
            System.out.println("Hasil: "+jumlah);
        }else if(pilih.equals("3")){
            jumlah = angka1 * angka2;
            System.out.println("Hasil: "+jumlah);
        }else if(pilih.equals("4")){
            jumlah = angka1 / angka2;
            System.out.println("Hasil: "+jumlah);
        }else{
            System.out.println("Pilihan Tidak Ditemukan");
        }
    }
    
}

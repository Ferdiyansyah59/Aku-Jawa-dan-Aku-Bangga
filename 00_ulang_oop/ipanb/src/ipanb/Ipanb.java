/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipanb;

/**
 *
 * @author ferdi
 */
import java.util.Scanner;

public class Ipanb{

    /**
     * @param args the command line arguments
     */
//    static boolean ul = true;
    static Scanner awa = new Scanner(System.in);
    
    private static void ulang(){
        System.out.print("Pilihan anda 0/1 ");
        int u = awa.nextInt();
        if (u == 0){
            System.exit(0);
        }
    }
    
    
    public static void main(String[] args) {
        menu mm = new menu();
        String pilihan;    
        
        while(true){
            System.out.println("MENU");
            System.out.println("1. Biodata");
            System.out.println("2. Lingkaran");
            System.out.println("3. Ganjil Genap");
            System.out.println("4. Exit");

            System.out.print("masukkan pilihan anda: " );
            pilihan = awa.next();
            
            if (pilihan.equals("1")){
                mm.bio();
                ulang();
            }else if(pilihan.equals("2")){
                System.out.println("===Lingkaran====");
                System.out.print("Masukkan jari: ");
                int jari = awa.nextInt();
                
                mm.lingkaran(jari);
                ulang();
            }else if(pilihan.equals("3")){
                System.out.println("=== Ganjil Genap ===");
                System.out.print("masukkan jumlah angka: ");
                int j = awa.nextInt();
                mm.gg(j);
                ulang();
            }else if(pilihan.equals("4")){
                System.exit(0);
            }else if(pilihan.equals("5")){
//                int a = mm.angka(5);
//                System.out.println(a);
            }
        }
    }
    
}

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
public class PboPertemuan3 {

    /**
     * @param args the command line arguments
     */
    static Scanner awa = new Scanner(System.in);
    public static void main(String[] args) {
        int nilai;
        System.out.print("Masukkan Nilai: ");
        nilai = awa.nextInt();
        
        switch(nilai){
            case 60:
                System.out.println("Nilai yang dicari: " + nilai);
            break;
            case 70:
                System.out.println("Nilai yang dicari: "+ nilai);
            break;
            default:
                System.out.println("Nilai yang anda cari tidak ada!");
        }
       
    }
    
}

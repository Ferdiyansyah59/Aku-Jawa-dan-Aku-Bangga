/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan4;

import java.util.Scanner;

/**
 *
 * @author ferdi
 */
public class PboPetemuan4e {
    
    static int move = 1;
    static Scanner awa = new Scanner(System.in);
    static void hanoi(int donat, char awal, char bantuan, char tujuan){
        if(donat >= 1){
            hanoi(donat-1, awal, tujuan, bantuan);
            move(donat, awal, tujuan);
            hanoi(donat-1, bantuan, awal, tujuan);
            
        }
    }
    
//    kalo a lebih kecil dari b nanti narik akar kuuadrat dari b
    
    static void move(int step, char awal, char tujuan){
        System.out.println("Langkah " + move);
        move++;
        System.out.println("Pindahkan Donat " + step);
        System.out.println(" dari " + awal);
        System.out.println(" Ke " + tujuan);
    }
    
    public static void main(String[] args) {
        System.out.print("Masukkan donat: ");
        int donat = awa.nextInt();
        
        hanoi(donat, 'A', 'B', 'C');
    }
}

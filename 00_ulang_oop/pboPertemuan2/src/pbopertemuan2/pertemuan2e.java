/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan2;

import java.util.Scanner;

/**
 *
 * @author ferdi
 */
public class pertemuan2e {
    public static void main(String[] args) {
        int nilai;
        Scanner awa = new Scanner(System.in);
        System.out.print("Masukkan Nilai ");
        nilai = awa.nextInt();  
        if(nilai % 2 == 0){
            System.out.println("Genap");
        }else{
            System.out.println("Ganjil");
        }
    }
}

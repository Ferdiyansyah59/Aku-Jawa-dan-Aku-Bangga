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
public class peretemuan2f {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        String nama;
        int nilai;
        char grade;
        
        while(true){
            System.out.print("Masukkan Nama: ");
            nama = awa.next();
            System.out.print("Masukkan Nilai: ");
            nilai = awa.nextInt();

            if (nilai >= 80 && nilai <= 100){
                grade = 'A';
            }else if(nilai >= 70 && nilai < 80){
                grade = 'B';
            }else if(nilai >= 55 && nilai < 70){
                grade = 'C';
            }else if(nilai >= 45 && nilai < 55){
                grade = 'D';
            }else{
                grade = 'E';
            }

            System.out.println("Nama: " + nama);
            System.out.println("Nilai : " + nilai);
            System.out.println("Grade: " + grade);
        }
                
    }
}

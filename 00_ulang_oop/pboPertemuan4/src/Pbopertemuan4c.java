
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferdi
 */
public class Pbopertemuan4c {
    static Scanner awa = new Scanner(System.in);
    static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.print("Masukkan nilai: ");
        int nilai = awa.nextInt();
        
        System.out.println("\nHasil " + nilai + "! adalah " + factorial(nilai));
    }
}

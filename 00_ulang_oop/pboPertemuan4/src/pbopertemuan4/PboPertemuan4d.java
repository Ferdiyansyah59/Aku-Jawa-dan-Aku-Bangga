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
public class PboPertemuan4d {
    static Scanner awa = new Scanner(System.in);
    static int fibonacci(int n){
        if (n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.print("Masukkan jumlah deret fibonacci: ");
        int n = awa.nextInt();
        
        for (int i = 0; i<=n; i++){
            System.out.println(fibonacci(i) + "");
        }
    }
}

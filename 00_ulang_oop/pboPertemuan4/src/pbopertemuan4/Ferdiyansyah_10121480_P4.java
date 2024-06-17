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
public class Ferdiyansyah_10121480_P4 {
    
    static int MM(int a, int b){
        
        int x, z;
         
        if (a % b == 0){
            return b;
        }else{
            x = a / b;  // 10
            z = a - (b * x); 
            a = b;
            b = z;
            return MM(a, b);
        }
    }
    
    public static void main(String[] args) {
        int aa, bb;
        Scanner awa = new Scanner(System.in);
        System.out.print("Masukkan nilai a: ");
        aa = awa.nextInt();
        System.out.print("Masukkan nilai b: ");
        bb = awa.nextInt();
        System.out.println("M("+aa+","+bb+") = " + MM(aa, bb));
        if(aa % bb == 0){
            System.out.println(bb + " Tidak bisa menjadi kunci!");
        }
    }
}

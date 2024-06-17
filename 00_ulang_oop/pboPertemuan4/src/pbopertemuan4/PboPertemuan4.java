/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan4;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ferdi
 */
public class PboPertemuan4 {
//        Rekursif meminimalisir looping, jadi method manggil method

    /**
     * @param args the command line arguments
     */
    
    static Scanner awa = new Scanner(System.in);
    
    static int perkalian(int a, int b){
        if (b == 0){
            return 0;
        }else{
            return a + perkalian(a, b-1);
        }
    }
    
    public static void main(String[] args) {
        int a,b;
        System.out.print("Masukkan nilai a: ");
        a = awa.nextInt();
        System.out.print("Masukkan nilai b: ");
        b = awa.nextInt();
        
        System.out.println(a + " x " + b + " = " + perkalian(a, b));
    }
    
}

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
public class peretemuan2c extends pertemuan2b{
    static Scanner awa = new Scanner(System.in);
    public static void main(String[] wkwkwk) {
        int p, l, luas;
        System.out.print("Panjang ");
        p = awa.nextInt();
        System.out.print("Lebar ");
        l = awa.nextInt();
        
        luas = p * l;
        System.out.println("\nLuas " + luas);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inherit;

/**
 *
 * @author ferdi
 */
import java.util.Scanner;
public class Turunan {
//    psvm ---> TAB
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        
        System.out.println("==== JENIS MAMALIA ====");
        System.out.println("1. Ikan Paus");
        System.out.println("2. Cheetah");
        System.out.println("3. Sapi");
        System.out.print("Masukkan pilihan [1..3] : ");
        int inp = awa.nextInt();
        
        Mamalia parent = new Mamalia();
        Paus child1 = new Paus();
        Cheetah child2 = new Cheetah();
        Sapi child3 = new Sapi();
        
        switch(inp){
            case 1:
                parent.KelasMamalia();
                child1.TampilkanPaus();
            break;
            case 2:
                child2.KelasMamalia();
                child2.TampilkanCheetah();
            break;
            case 3:
                child3.KelasMamalia();
                child3.TampilkanSapi();
            break;
            default:
                System.out.println("Pilihan yang anda masukkan tidak ada!!");
            break;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_begin_pert2_inherit;

/**
 *
 * @author ferdi
 */
import java.util.Scanner;
public class Turunan {
    static Scanner awa = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mamalia generalx = new Mamalia();
        Paus turunan1 = new Paus();
        Cheetah turunan2 = new Cheetah();
        Sapi turunan3 = new Sapi();
        char ulang;
        do{
            System.out.println("==== JENIS MAMALIA ===");
            System.out.println("1. Ikan Paus");
            System.out.println("2. Cheetah");
            System.out.println("3. Sapi");
            System.out.print("Masukkan pilihan [1..3] : ");
            int inp = awa.nextInt();

            switch(inp){
                case 1:
                    generalx.KelasMamalia();
                    turunan1.TampilkanPaus();
                break;
                case 2:
                    turunan2.KelasMamalia();
                    turunan2.TampilkanCheetah();
                break;
                case 3:
                    turunan3.KelasMamalia();
                    turunan3.TampilkanSapi();
                break;
                default:
                    System.out.println("Pilihan yang ada masukkan salah");
                    ulang = 'y';
                break;
            }
            System.out.print("Ingin memilih (y/t)");
            ulang = awa.next().charAt(0);
        }while(ulang != 't');
        
        
    }
    
}

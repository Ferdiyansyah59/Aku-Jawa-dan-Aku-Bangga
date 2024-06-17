/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bujursangkar;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class BujurSangkar {
Scanner awa = new Scanner(System.in);
    public int sisi;
    public int luas ;
    public int keliling;

    
    
    public int setSisi()
    {
        return sisi;
    }
    public int Sisi() {
        
        System.out.print("Masukkan Sisi : ");
        sisi = awa.nextInt();
        return sisi;
        
    }


    public int Luas() {
        luas = sisi*sisi;
        return luas;
    }

   
    public int Keliling() {
        keliling = 4*sisi;
        return keliling;
    }

   
    
}

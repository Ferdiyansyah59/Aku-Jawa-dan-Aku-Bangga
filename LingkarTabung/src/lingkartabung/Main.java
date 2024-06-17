/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingkartabung;

import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
  
    public static void main(String[] args) {
    Scanner awa = new Scanner(System.in);
    DecimalFormat dc = new DecimalFormat("#.##");
    
   
    TabungLingkar tl = new TabungLingkar();
    
        System.out.println("==========Tabung Lingkaran==========\n");
    
        System.out.print("Masukkan jari-jari : ");
        double y = awa.nextDouble();
        tl.setjari(y);
        System.out.print("Masukkan Tinggi     : ");
        double z = awa.nextDouble();
        tl.setTinggi(z);
        System.out.println("----------------------------------------------");
        System.out.println("Jari-Jari : " + y);
        System.out.println("Tinggi    : " + z);
        System.out.println(" ");
        System.out.println("Luas Lingkaran : " + Double.valueOf(dc.format(tl.luasLingkaran())));
        System.out.println("Keliling Lingkaran : " + Double.valueOf(dc.format(tl.KelLingkaran())));
        System.out.println("Luas Permukaan Tabung : " + Double.valueOf(dc.format(tl.luasPermtabung())));
        System.out.println("Volume Tabung : " + Double.valueOf(dc.format(tl.volTabung())));
        
        
        
    
    }
        
    
}

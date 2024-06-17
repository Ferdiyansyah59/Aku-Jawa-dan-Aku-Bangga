/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabung13819;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class MinTabung {
    public static void main(String[] args) {
        
        Scanner x = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("#.##");
        Tabung13819 awa = new Tabung13819();
               
        
        System.out.println("===Tgs.Enkapsulasi dengan Constructor===");
        System.out.println("=================TABUNG=================");
        
        System.out.print("Jari-Jari = " );
         double s = x.nextDouble();
        awa.setJari(s);
        System.out.println("Luas Alas = " + "3.14 * " + awa.getJari() + "*" + awa.getJari() + " = " + Double.valueOf(dc.format(awa.luasAlas())));
        System.out.println("Kel Lingkaran = " + " 2 * " + " 3.14 * " + awa.getJari() + " = " + Double.valueOf(dc.format(awa.kelLingkaran())));
        System.out.print("Tinggi = " );
        double c = x.nextDouble();
        awa.setTinggi(c);
        System.out.println("Luas Tabung = " + " 2 * " + Double.valueOf(dc.format(awa.luasAlas())) + "+ (" + Double.valueOf(dc.format(awa.kelLingkaran()))+ " * " + awa.getTinggi() + ") = " +Double.valueOf(dc.format(awa.LuasTabung())));
        System.out.println("Volume Tabung = " + Double.valueOf(dc.format(awa.luasAlas())) + " * " + Double.valueOf(dc.format(awa.getTinggi() ))+ " = " + Double.valueOf(dc.format(awa.volTabung())));
}
}

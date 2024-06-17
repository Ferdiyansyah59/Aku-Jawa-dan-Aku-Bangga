/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usaha;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class MainUsaha {
    public static void main(String[] args) {
        Usaha awa = new Usaha();
        Scanner x = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("#.##");
        
        System.out.println("=====USAHA=====");
        System.out.print("Masukkan massa : " );
        double y = x.nextDouble();
        awa.setMassa(y);
        System.out.print("Masukkan Jarak : ");
        double z = x.nextDouble();
        awa.setJarak(z);
        System.out.print("Masukkan Percepatan : " );
        double a = x.nextDouble();
        awa.setPercepatan(a);
        System.out.println("Usaha : " + Double.valueOf(dc.format(awa.Usahaa())));
    }
}

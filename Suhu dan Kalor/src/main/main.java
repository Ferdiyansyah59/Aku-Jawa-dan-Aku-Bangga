/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
import java.text.DecimalFormat;
public class main {
    public static void main(String[] args) {
        
        int a = 0;
        
        Scanner awa = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("#.##");
        
        termometer.celcius c = new termometer.celcius();
        termometer.reamur r = new termometer.reamur();
        termometer.fahrenheit f = new termometer.fahrenheit();
        termometer.kelvin kel= new termometer.kelvin();
        
        kalor.kalor k = new kalor.kalor();
        kalor.kapasitaskalor kk = new kalor.kapasitaskalor();
        
        pemuaian.Muaipanjang mp = new pemuaian.Muaipanjang();
        pemuaian.Muailuas ml = new pemuaian.Muailuas();
        pemuaian.Muaivolume mv = new pemuaian.Muaivolume();
        
        int x= 0;
        while(x == 0)
        {
        
        System.out.println("----- SUHU & KALOR -----");
        System.out.println("1.Suhu");
        System.out.println("2.Kalor");
        System.out.println("3.Pemuaian");
        System.out.println("4.Exit");
        System.out.print("Pilih : ");
        String pilih1 = awa.next();
        
        switch(pilih1) 
        {
            case "1":
                System.out.println("---------------------------------------");
                System.out.println("1.Celcius");
                System.out.println("2.Reamur");
                System.out.println("3.Fahrenheit");
                System.out.println("4.Kelvin");
                System.out.print("Pilih : ");
                String pilih2 = awa.next();
                
                switch(pilih2)
                {
                    case "1" :
                        System.out.println("\n");
                        System.out.println("Konversikan ke: ");
                        System.out.println("1.Reamur");
                        System.out.println("2.Fahrenheit");
                        System.out.println("3.Kelvin");
                        System.out.print("Pilih : ");
                        String pilih4 = awa.next();
                        
                        switch(pilih4)
                        {
                            case "1" :
                                System.out.println("Suhu Reamur : " + Double.valueOf(dc.format(c.reamur())) +"°R" );
                                break;
                            case "2" :
                                System.out.println("Suhu Fahrenheit : " + Double.valueOf(dc.format(c.fahreinheit())) + "°F");
                                break;
                            case "3" :
                                System.out.println("Suhu Kelvin : " + Double.valueOf(dc.format(c.kelvin())) + "°K");
                                break;
                            default : 
                                System.out.println("Pilihan Tidak Ditemukan");
                                System.exit(a);
                                break;
                        }
                        
                        break;
                    case "2" :
                        System.out.println("\n");
                        System.out.println("Konversikan ke: ");
                        System.out.println("1.Celcius");
                        System.out.println("2.Fahrenheit");
                        System.out.println("3.Kelvin");
                        System.out.print("Pilih : ");
                        String pilih5 = awa.next();
                        switch(pilih5)
                        {
                            case "1" :
                                System.out.println("Suhu Celcius : " + Double.valueOf(dc.format(r.celcius())) + "°C" );
                                break;
                            case "2" :
                                System.out.println("Suhu Fahrenheit : " + Double.valueOf(dc.format(r.fahreinheit())) + "°F");
                                break;
                            case "3" :
                                System.out.println("Suhu Kelvin : " + Double.valueOf(dc.format(r.kelvin())) + "°K");
                                break;
                            default :
                                System.out.println("Pilihan Tidak Ditemukan");
                                System.exit(a);
                                break;
                        }
                        break;
                    case "3" :
                        System.out.println("\n");
                         System.out.println("Konversikan ke: ");
                        System.out.println("1.Celcius");
                        System.out.println("2.Reamur");
                        System.out.println("3.Kelvin");
                        System.out.print("Pilih : ");
                        String pilih6 = awa.next();
                        switch (pilih6) 
                        {
                            case "1" :
                                System.out.println("Suhu Celcius : " + Double.valueOf(dc.format(f.celcius())) + "°C");
                                break;
                            case "2" :
                                System.out.println("Suhu Reamur : " + Double.valueOf(dc.format(f.reamur())) + "°R");
                                break;
                            case "3" :
                                System.out.println("Suhu Kelvin : " + Double.valueOf(dc.format(f.kelvin())) + "°K");
                                break;
                            default : 
                                System.out.println("Pilihan Tidak Ditemukan");
                                System.exit(a);
                                break;
                        }
                    break;
                    case "4" :
                        System.out.println("\n");
                         System.out.println("Konversikan ke: ");
                        System.out.println("1.Celcius");
                        System.out.println("2.Reamur");
                        System.out.println("3.Fahrenheit");
                        System.out.print("Pilih : ");
                        String pilih7 = awa.next();
                        switch(pilih7)
                        {
                            case "1" :
                                System.out.println("Suhu Celcius : " + Double.valueOf(dc.format(kel.celcius())) + "°C");
                                break;
                            case "2" :
                                System.out.println("Suhu Reamur : " + Double.valueOf(dc.format(kel.reamur())) + "°R");
                                break;
                            case "3" :
                                System.out.println("Suhu Fahrenheit : " + Double.valueOf(dc.format(kel.fahreinheit())) + "°F");
                                break;
                            default :
                                System.out.println("Pilihan Tidak Ditemukan");
                                System.exit(a);
                                break;
                        }
                        

                        break;
                    default :
                        System.out.println("Pilihan Tidak Ditemukan");
                        System.exit(a);
                        break;
                }          
                break;
            case "2" :
                System.out.println("---------------------------------------");
                System.out.println("1.Kalor");
                System.out.println("2.Kapasitas Kalor");
                String pilih = awa.next();
                switch(pilih)
                {
                    case "1" :
                        System.out.println("Kalor : " + Double.valueOf(dc.format(k.kaalor())) + "Joule");
                        break;
                    case "2" : 
                         System.out.println("Kapasitas Kalor : " + Double.valueOf(dc.format(kk.kaalor())) + "J");
                        break;
                }
                
               
                break;
            case "3" :
                System.out.println("---------------------------------------");
                System.out.println("1.Muai Panjang");
                System.out.println("2.Muai Luas");
                System.out.println("3.Muai Volume");
                System.out.print("Pilih : ");
                String pilih3 = awa.next();
                
                switch(pilih3)
                {
                    case "1" :
                        System.out.println("Muai Panjang : " + Double.valueOf(dc.format(mp.muai())) + "cm");
                        break;
                    case "2" :
                        System.out.println("Muai Luas : " + Double.valueOf(dc.format(ml.muai())) + "cm²");
                        break;
                    case "3" : 
                        System.out.println("Muai Volume : " + Double.valueOf(dc.format(mv.muai())) + "cm³");
                        break;
                    default :
                        System.out.println("Pilihan Tidak Ditemukan");
                        break;
                }
            break;
            case "4" :
                System.exit(a); 
                break;
            default :
                System.out.println("Pilihan Tidak Ditemukan");
                System.exit(a);
                break;
        }
            
        }
        
    }
}

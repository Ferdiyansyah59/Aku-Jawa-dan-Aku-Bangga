/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

/**
 *
 * @author ferdiyansyah
 */

import java.util.Scanner; //Scanner

public class Java2 {

//    String nama , habitat ;
//    int umur;
//    
//    
//    public void setNama(String nama)
//    {
//        this.nama = nama;
//    }
//    
//   
//    public void setUmur(int umur)
//    {
//        this.umur = umur;
//    }
//    public void setHabitat(String habitat)
//    {
//        this.habitat = habitat;
//    }
//    public void tampildata()
//    {
//        System.out.println("Nama    :" +nama);
//        System.out.println("Umur    :" +umur);
//        System.out.println("Habitat :" +habitat);
//        
//    }
            
    public static void main(String[] args) {
        
//        String name;
        
        Scanner keyboard = new Scanner(System.in);
        //membuat Scanner
        
//        System.out.println("KUCING : ");
//        Java2 kucing = new Java2();
//        kucing.setNama("Bambang");
//        kucing.setUmur(100);
//        kucing.setHabitat("Kandang");
//        kucing.tampildata();
//        
//        System.out.print("Nama    : ");
//        name = keyboard.nextLine(); //ngescann
//        
//        System.out.println("Namanya : " + name);
       
        String nama,habitat;
        int umur;
        
        System.out.print("NAMA    : ");
        nama = keyboard.nextLine();
        System.out.print("HABITAT : ");
        habitat = keyboard.nextLine();
        System.out.print("UMUR    : ");
        umur = keyboard.nextInt();
        
        
        
        
        System.out.println("--------------------");
        
        System.out.println("Nama : \t" + nama);
        System.out.println("Habitat : " + habitat);
        System.out.println("Umur : \t" + umur + " Tahun");
        
       
    }
    
}

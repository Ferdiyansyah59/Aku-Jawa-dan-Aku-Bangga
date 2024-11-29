/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert1;

/**
 *
 * @author ferdi
 */
public class no10 {
    double alas, tinggi;
    
    void isiData(double alas, double tinggi){
       this.alas = alas; 
       this.tinggi = tinggi;
    }
//    psvm
    public static void main(String[] args) {
        no10 n = new no10();
        
        n.isiData(25, 10);
        System.out.println("Alas : " + n.alas + " cm");
        System.out.println("Tinggi : " + n.tinggi + " cm");
        System.out.println("Luas Segitiga : " + (n.alas * n.tinggi)/ 2 + " cm2");
    }
}

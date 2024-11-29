/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert2;

class perkalian {
    int perk(int a, int b){
        return a * b;
    }
    
    double perk(double a, double b){
        return a * b;
    }
}

public class No8 {
    public static void main(String[] args) {
        perkalian p = new perkalian();
        
        int a = p.perk(5, 4);
        double b = p.perk(6.8, 9.2);
        
        System.out.println("Hasil Perkalian Integer = " + a);
        System.out.println("Hasil Perkalian Double = " + b);
    }
    
}
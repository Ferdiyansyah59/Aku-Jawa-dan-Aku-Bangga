/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert1;

class Nilai{
    double kuis, tugas;
    
    double HitungNilai(){
        double jumlah = ( kuis+tugas ) / 2;
        return jumlah;
    }
}


public class susanto {
    
//    psvm ---> klik tab
    
    public static void main(String[] args) {
        Nilai n = new Nilai();
        
        n.kuis = 95.5;
        n.tugas = 100;
        
        System.out.println("Nilai kuis = " + n.kuis);
        System.out.println("Nilai Tugas = " + n.tugas);
        System.out.println("Rata-Rata Nilai = " + n.HitungNilai());
    }
}

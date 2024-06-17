/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfisme;

/**
 *
 * @author ferdiyansyah
 */
public class Main {
    
    public static void main(String[] args) {
        MencetakData data = new MencetakData();
        
        System.out.print("Cetak Data Tipe String : ");
        data.CobaCetak("DKI Jakarta");
        
        System.out.print("Cetak Data Tipe Integer :");
        data.CobaCetak(1992);
        
        System.out.print("Cetak Data Tipe Double : ");
        data.CobaCetak(16.5/2);
        
        System.out.print("Cetak Data Tipe Char : ");
        data.CobaCetak('N');
        
        
    }
    
}

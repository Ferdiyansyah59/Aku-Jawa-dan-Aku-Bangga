/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan2;

import javax.swing.JOptionPane;

/**
 *
 * @author ferdi
 */
public class pertemuan2d {
    public static void main(String[] args) {
        final double bonusPersen = 0.15;
        double bonus, hargaJual, hargaToko;
        
        peretemuan2c a = new peretemuan2c();
        
 
       
        
        hargaJual = Double.valueOf(JOptionPane.showInputDialog("Masukkan harga jual"));
        hargaToko = Double.valueOf(JOptionPane.showInputDialog("Masukkan harga Toko"));
        
        if(hargaJual > hargaToko){
            bonus = bonusPersen * hargaJual;
            JOptionPane.showMessageDialog(null, "Selamat bonus anda Rp. "+bonus);
        }else{
            JOptionPane.showMessageDialog(null, "Mohon bersabar!");
        }
    }
}

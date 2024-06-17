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
public class pertemuan2b {
    static int asu = 18;
    static void aa(){
        System.out.println("BBBBBBBB");
    }
    public static void main(String[] args) {
        
        
        int p,l, luas;
        p = Integer.valueOf(JOptionPane.showInputDialog("Masukkan Panjang"));
        l = Integer.valueOf(JOptionPane.showInputDialog("Masukkan Lebar"));
        
        luas = p * l;
        String pesan = "Luas Persegi = " + luas;
        JOptionPane.showMessageDialog(null,pesan);
        
    }
}

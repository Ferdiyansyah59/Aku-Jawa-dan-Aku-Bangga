/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan6;

import javax.swing.JOptionPane;

/**
 *
 * @author ferdi
 */
public class panggil extends mobil {
    public static void main(String[] args) {
        panggil p = new panggil();
        String merk, warna, harga;
        merk = JOptionPane.showInputDialog("Masukkan merk mobil ");
        p.setMerk(merk);
//        JOptionPane.showMessageDialog(null, p.Tampil("Merk Mobil " + p.getMerk()));
        p.tampil("Merk Mobil " + p.getMerk());
        
        
        warna = JOptionPane.showInputDialog("Masukkan merk warna ");
        p.setMerk(warna);
//        JOptionPane.showMessageDialog(null, p.Tampil("Merk Mobil " + p.getMerk()));
        p.tampil("Merk Mobil " + p.getWarna());
        
        harga = JOptionPane.showInputDialog("Masukkan merk harga ");
        p.setMerk(harga);
//        JOptionPane.showMessageDialog(null, p.Tampil("Merk Mobil " + p.getMerk()));
        p.tampil("Merk Mobil " + p.getHarga());
        
        
        p.hapus();
        merk = null;
        warna = null;
        harga = null;
        p = null;
        System.exit(0);
    }
}

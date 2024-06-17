/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan7;

/**
 *
 * @author ferdi
 */
public class panggil {
    public static void main(String[] args) {
        String pemilik = "Fermor";
        String merk = "Kawamaha";
        String warna = "Magenta";
        
        
        ConstructorKendaraan.setPemilik(pemilik);
        System.out.println("Pemilik kendaraan : " + ConstructorKendaraan.getPemilik());
        System.out.println("-------------------------");
        
        ConstructorKendaraan m = new ConstructorKendaraan();
        m.tampil("Merk Kendaraan : " + m.getMerk());
        System.out.println("--------------------------------------");
        
        ConstructorMotor n = new ConstructorMotor(merk, warna);
        m.tampil("Warna Kendaraan : " + n.getWarna());
        m.tampil("Merk Kendaraan : " + n.getMerk());
        System.out.println("--------------------------");
        
        pemilik = null;
        merk = null;
        warna = null;
        m.hapus();
        n = null;
        m = null;
        
    }
}

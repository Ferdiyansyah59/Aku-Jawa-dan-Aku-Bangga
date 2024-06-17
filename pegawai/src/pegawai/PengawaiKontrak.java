/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pegawai;

/**
 *
 * @author ferdiyansyah
 */
public class PengawaiKontrak {
    String Nama;
    int NoPeg, MasaKontrak , Kehadiran , UangMakan , Gaji , lihat;
    
    
    public void setNoPeg(int pegawai)
    {
        NoPeg = pegawai;
    }
    public int getNoPeg()
    {
        return NoPeg;
    }
    public void setNama(String nama)
    {
        Nama = nama;
    }
    public String getNama()
    {
        return Nama;
    }
    public void setMasaKontrak(int kontrak)
    {
        MasaKontrak = kontrak;
    }
    public int getMasaKontrak()
    {
        return MasaKontrak;
    }
    public void setKehadiran(int kehadiran)
    {
       Kehadiran = kehadiran; 
    }
    public int getKehadiran()
    {
        return Kehadiran;
    }
//    public void setUangMakan(int makan)
//    {
//        UangMakan = makan;
//    }
//    public int getUangMakan()
//    {
//        return UangMakan;
//    }
    
    public void setGaji(int gaji)
    {
        Gaji = gaji;
    }
    public int getGaji()
    {
        return Gaji;
    }
    public int UangMakan()
    {
        return 6000 * Kehadiran;
    }
    public double hitungGaji()
    {
        return UangMakan() + Gaji;
    }
    
       public int lihatData()
    {
       
        System.out.println("\tNoPeg\tNama\tKehadiran\tUangMakan\tGaji\tGajiBersih");
        System.out.println("\t"+getNoPeg() + "\t" + getNama() + "\t" + getKehadiran() +"\t" + "\t" + UangMakan() + "\t\t" + getGaji() + "\t" +hitungGaji());
        return lihat;
    }
}

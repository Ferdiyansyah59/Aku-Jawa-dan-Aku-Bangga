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
public class PegawaiTetap {
    String Nama;
    int NoPeg  , Kehadiran , Tunjangan , UangMakan , Gaji , lihat;
    
    
     public void setNoPeg(int np)
    {
        NoPeg = np;
    }
    public int getNoPeg()
    {
        return NoPeg;
    }
    public void setNama(String n)
    {
        Nama = n;
    }
    public String getNama()
    {
        return Nama;
    }
    public void setKehadiran(int k)
    {
        Kehadiran = k;
    }
    public int getKehadiran()
    {
        return Kehadiran;
    }
    public void setTunjangan(int t)
    {
        Tunjangan = 200000;
       
    }
    public int getTunjangan()
    {
        return Tunjangan;
    }
    public void setGaji(int g)
    {
       Gaji = g; 
    }
    public int getGaji()
    {
        return Gaji;
    }
    
    public int UangMakan()
    {
        return 6000 * Kehadiran;
    }
    
    public int hitungGaji()
    {
      
        return getTunjangan() + UangMakan() + Gaji;
    }
    
    
    public int lihatData()
    {
        Tunjangan = 200000;
        System.out.println("\tNoPeg\tNama\tKehadiran\tTunjangan\tUangMakan\tGaji\tGajiBersih");
        System.out.println("\t"+getNoPeg()+"\t"+getNama()+"\t"+getKehadiran()+"\t\t"+Tunjangan+"\t\t"+UangMakan()+"\t\t" + getGaji() + "\t" +hitungGaji());
        return lihat;
    }
    
   
    
}

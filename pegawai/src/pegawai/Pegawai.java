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
 import java.util.*;
public class Pegawai {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        
        Scanner awa = new Scanner(System.in);
        
       PengawaiKontrak pk = new PengawaiKontrak();
       PegawaiTetap pt = new PegawaiTetap();
       
       int ulang = 0;
       
       while(ulang == 0)
       {
        System.out.println("----- PEGAWAI ----\t");
        System.out.println("1.Input Data Pegawai");
        System.out.println("2.Lihat Data Pegawai");
        System.out.println("3.Keluar");
        System.out.print("Pilihan Anda : ");
        String pilih1 = awa.next();
        
        int a = 0;
        
        switch (pilih1)
        {
            case "1" :
                System.out.println("1.Pegawai Kontrak");
                System.out.println("2.Pegawai tetap");
                System.out.print("Pilihan Anda : ");
                String pilih2 = awa.next();
                
                switch(pilih2)
                {
                    case "1" :
                        System.out.print("Masukkan No Pegawai : ");
                        int nopeg = awa.nextInt();
                        pk.setNoPeg(nopeg);
                        System.out.print("Masukkan Nama Pegawai : ");
                        String nama = awa.next();
                        pk.setNama(nama);
                        System.out.print("Masukkan Massa Kontrak : ");
                        int kon = awa.nextInt();
                        pk.setMasaKontrak(kon);
                        System.out.print("Masukkan Kehadiran : ");
                        int keh = awa.nextInt();
                        pk.setKehadiran(keh);
                        System.out.print("Masukkan Gaji : ");
                        int ga = awa.nextInt();
                        pk.setGaji(ga);
                        break;
                    case "2" :
                        System.out.print("Masukkan No Pegawai : ");
                        int nope = awa.nextInt();
                        pt.setNoPeg(nope);
                        System.out.print("Masukkan Nama Pegawai : ");
                        String nm = awa.next();
                        pt.setNama(nm);
                        System.out.print("Masukkan Kehadiran : ");
                        int k = awa.nextInt();
                        pt.setKehadiran(k);
                        System.out.print("Masukkan Gaji : ");
                        int g = awa.nextInt();
                        pt.setGaji(g);
                        break;
                }
                
                break;
            case "2" :
                System.out.println("        ----------------------------------------------------------------------------------");
                pk.lihatData();
                System.out.println("        ----------------------------------------------------------------------------------");
                pt.lihatData();
               System.out.println("        ----------------------------------------------------------------------------------");
                
                break;
            case "3" :
               System.exit(a);
                break;
            
        }
           System.out.println("\n");
    }
    }
    
}

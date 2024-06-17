/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barangascd;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Collection;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class inputbarang {
    
    int total;
    Scanner awa = new Scanner(System.in);
    ArrayList <Integer> angka = new ArrayList();
    
    
    
    public void masuk()
    {
        
        
        int z =0;
        
        atas:
        System.out.print("Masukkan banyak angka : ");
        int a = awa.nextInt();
      
      

        for(int i = 0;i<a;i++)
        {
            System.out.print("Angka ke -"+(i+1) + ":");
            int isi = awa.nextInt();
            angka.add(isi);
            
            
        }
        System.out.println(angka);
        while(z==0)
        {
        System.out.println("\n1.Search Data");
        System.out.println("2.Tampilkan Data");
        System.out.println("3.Ascending");
        System.out.println("4.Descending");
        System.out.println("5.Hapus Data");
        System.out.println("6.Edit Data");
        System.out.println("7.Buat Data Baru");
        System.out.println("8.Tambah Data");
        System.out.println("9.Nilai Max/Min");
        System.out.println("10.Banyak Data/Jumlah Data/Rata-Rata");
        System.out.println("11.Exit");
        System.out.print("Pilihan Anda : ");
        String pilih = awa.next();
        if("1".equals(pilih))
        { 
            System.out.print("Masukkan Angka yang ingin dicari : ");
            int cari = awa.nextInt();
            
            try{
                if(angka.indexOf(cari) == -1)
                {
                    System.out.println(3/0);
                }
                else
                { 
                    System.out.println("Angka Ditemukan!");
                    int d = angka.indexOf(cari);
                    System.out.println("Posisi ke : " + (d+1));
                }
            }
            catch(Exception ex)
            {
                System.out.println("Angka tidak ditemukan!");
            }
           
//            System.out.print("Data Yang akan dicari : ");
//            int cari = awa.nextInt();
//            boolean temu = false;
//            int urut = 0;
//            
//            for(int k =0;k<angka.size();k++)
//            {
//                if(angka.get(k) == cari)
//                {
//                    urut = (k+1);
//                    temu = true;
//                    System.out.println("Data Ketemu di urutan ke -" + urut);
//                    break;
//                }
//                else
//                {
//                    try
//                    {
//                        System.out.println(angka.get());
//                    }
//                    catch(ArrayIndexOutOfBoundsException e)
//                    {
//                        System.out.println(e);
//                        System.out.println("Angka tidak di Temukan");
//                    }
//                }
//            }
        }
        else if("2".equals(pilih))
        {
            System.out.println("Angka"); 
        }
        else if("3".equals(pilih))
        {  
            Collections.sort(angka);
            System.out.println(angka);
        }
        else if("4".equals(pilih))
        {
            Collections.sort(angka, Collections.reverseOrder());
            System.out.println(angka);
             
        }
        else if("5".equals(pilih))
        {
            try{
            System.out.print("Hapus Index ke-");
            int hapus = awa.nextInt();
            
            angka.remove(hapus);
            }
            catch(Exception e){
                System.out.println("Index tidak ditemukan");
            }
        }
        else if("6".equals(pilih))
        {
            System.out.print("Edit index ke-");
            int edit = awa.nextInt();
            try{
            System.out.print("Ubah Menjadi : ");
            int ubah = awa.nextInt();
            angka.set(edit , ubah);
            }
            catch(Exception e)
            {
                System.out.println("Index tidak ditemukan");
            }
        }
        else if("7".equals(pilih))
        {
             angka.clear();
            
            System.out.print("Masukkan banyak angka : ");
            int b = awa.nextInt();


        for(int i = 0;i<b;i++)
        {
            System.out.print("Angka ke -"+(i+1) + ":");
            int isi = awa.nextInt();
            angka.add(isi);
            
        }
        }
        
        else if("8".equals(pilih))
        {
            
            System.out.print("Masukkan banyak angka : ");
            int b = awa.nextInt();


        for(int i = 0;i<b;i++)
        {
            System.out.print("Angka ke -"+(i+1) + ":");
            int isi = awa.nextInt();
            angka.add(isi);
            
        }
        
        }
        else if("9".equals(pilih))
        {
            System.out.println("1.Nilai Maximum");
            System.out.println("2.Nilai Minimum");
            System.out.print("Pilih : ");
            String pilih2 = awa.next();
           
            if("1".equals(pilih2))
            {
                Collections.sort(angka, Collections.reverseOrder());
                System.out.println("Nilai Max : " + angka.get(0));
            }
            else if("2".equals(pilih2))
            {
                Collections.sort(angka);
                System.out.println("Nilai Minimum : " + angka.get(0));
            }
            else
            {
                
            }
            
        }
                   
                  
        else if("10".equals(pilih))
        {
            System.out.println("1.Banyak Data");
            System.out.println("2.Jumlah Data");
            System.out.println("3.Rata rata");
            System.out.print("Pilihan Anda : ");
            int pilih3 = awa.nextInt();
            
            if(pilih3 == 1)
            {
                System.out.println("Banyak Data : " + angka.size());
            }
            else if(pilih3 == 2)
            {
                int v =0;
                int h = angka.size();
                for(int i = 0;i<h;i++)
                {
                     v = v + angka.get(i);
                }
                System.out.println("Jumlah Data : " + v);
            }
            else if(pilih3 == 3)
            {
               int p =0;
               int h = angka.size();
               for(int i =0;i<h;i++)
               {
                   p = p + angka.get(i);
               }
               int u = p/angka.size();
                System.out.println(u);
            }
            else
            {
                System.out.println("Gak ada");
            }
        }
        else if("11".equals(pilih))
        {
            System.exit(z);
        }
        
 
        else
        { 
            try{
                System.out.println("Pilihan anda tidak ditemukan");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
            System.out.println("-----------------");
            System.out.println(angka);
        } 
        
    }
 
        
}

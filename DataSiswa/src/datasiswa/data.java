/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasiswa;

/**
 *
 * @author ferdiyansyah
 */

import java.io.BufferedWriter;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;  
import java.io.IOException;
public class data {
    File doc = new File("data.txt");
    Scanner awa = new Scanner(System.in);
    public void create()
    {
        try{
            if(doc.createNewFile()){
                System.out.println("File Created "+doc.getName());
            }
         
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
    public void isi(){
        try(BufferedWriter tulis = new BufferedWriter(new FileWriter(doc))){
            String nama,alamat,jenkel ,jur,kelas ,nis;
            System.out.print("Nis : ");
            nis = awa.next();
            System.out.print("Nama : ");
            nama = awa.next();
            System.out.print("Alamat : ");
            alamat = awa.next();
            System.out.print("Jenis Kelamin : ");
            jenkel = awa.next();
            System.out.print("Jurusan : ");
            jur = awa.next();
            System.out.print("Kelas : ");
            kelas = awa.next();
            
            tulis.write(nis);
            tulis.newLine();
            tulis.write(nama);
            tulis.newLine();
            tulis.write(alamat);
            tulis.newLine();
            tulis.write(jenkel);
            tulis.newLine();
            tulis.write(jur);
            tulis.newLine();
            tulis.write(kelas);
            tulis.newLine();
            tulis.close();
            System.out.println(" ");
            System.out.println("Sukses");
            System.out.println(" ");
                    
        }
        catch(IOException e){
        System.out.println("Error");
    }
    }
    
    public void baca(){
        try{
            Scanner scan = new Scanner(doc);
            System.out.println("=================================================================");
            System.out.println("\tNIS\tNama\tJenis Kelamin\tAlamat\tJurusan\tKelas");
            System.out.println("==================================================================");
            System.out.print("\t");
            while(scan.hasNextLine()){
                String data = scan.nextLine();
                System.out.print(data + "\t");
            }
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
    }
}

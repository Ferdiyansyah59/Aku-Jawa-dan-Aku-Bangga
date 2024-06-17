/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pencarianbilangan;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Arrays;
import java.util.Scanner;
public class pencarian {
    Scanner awa = new Scanner(System.in);
    public void cari()
    {
        System.out.print("Input banyak angka ( Max 5) : ");
        int a = awa.nextInt();
        int []angka = new int[a];
        
        
        if(a > 5)
        {
            try
            {
                System.out.println(angka[a]);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e);
                System.out.println("Array kelebihan");
            }
        }
        else if(a <= 5)
        {

            for(int i = 0;i<angka.length;i++)
            {
                System.out.print("Input angka ke-" + (i+1)+ " :");
                angka[i] = awa.nextInt();
            }
           
                
                System.out.println(Arrays.toString(angka));
            
            
            System.out.print("Masukkan angka yang akan dicari : ");
            int cari = awa.nextInt();
            boolean nemu = false;   
            int urutan = 0;
            for(int k = 0;k<a;k++)
            {
               
                if(angka[k] == cari)
                {
                    System.out.println("Data Ketemu");
                    urutan = k+1;
                    nemu = true;
                    break;
                }
            }
            if(nemu == true)
            {
                System.out.println("Angka ditemukan pada urutan ke-" + (urutan));
            }
            else{
                                            
                try
                {
                    System.out.println(angka[6]);
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(e);
                    System.out.println("Angka tidak ditemukan");
                }
            }
                              
            
        }
    }
    
    public void cariString()
    {
        System.out.print("Masukkan Kata apa saja : ");
        String masuk = awa.next();
        int total = masuk.length();
        int kapital = 0;
        System.out.println("Jumlah karakter : " + total);
        for(int i = 0;i<total;i++)
        {
            if(Character.isUpperCase(masuk.charAt(i))){
                kapital++;
               }
        }
        System.out.println("Jumlah huruf kapital : " + kapital);
        try
        {
            int has = total/kapital;
            System.out.println("Hasil " + total + " bagi " + kapital + ":" + has);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Error");  
        }
    }
    
}

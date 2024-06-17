/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.smk.pkg24;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class Transaksi implements Bank{
    
    Scanner awa = new Scanner(System.in);
    int saldoawal ;
    int saldoakhir , total , tarik,rek,tf,mn;
    
//    public Transaksi(int saldoakhir , int total , int tarik )
//    {
//        this.saldoakhir = saldoakhir;
//        this.total = total ;
//        this.tarik = tarik;
//         
//    }

  
    
    
    @Override
    public void menabung(int tb)
    {   
        System.out.print("Saldo : ");
        tb = awa.nextInt();
        
        this.saldoawal+=tb;
                
        System.out.println("Saldo Anda : "  + tb);
    }
   
    @Override
    public void transfer()
    {
        System.out.print("Rekening Tujuan : ");
        rek = awa.nextInt();
        System.out.print("Total Transfer : ");
        tf = awa.nextInt();
         total = saldoakhir-tf;
        if(saldoakhir < tf)
        {
            System.out.println("Saldo Tidak Mencukupi");
        }
        else
        {
        
         System.out.println("Saldo Anda : " + total);
        }
    }
 
    @Override
    public void menarik()
    {
        System.out.print("Uang yang di tarik : ");
        mn = awa.nextInt();
        tarik = saldoakhir - mn;
        if(saldoakhir < mn)
        {
            System.out.println("Penarikan gagal Saldo Anda Tidak Cukup");
        }
        else
        {
        System.out.println("Berhasil Ditarik");
        
        System.out.println("Saldo Anda : " + tarik);
        }
    }
    
    public void saldo()
    {
        System.out.println("Saldo Anda : " + saldoawal);
   }
    
}

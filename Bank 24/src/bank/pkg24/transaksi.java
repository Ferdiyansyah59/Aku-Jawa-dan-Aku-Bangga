/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.pkg24;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class transaksi implements bank{
    Scanner awa = new Scanner(System.in);
    double saldo;
    
    
    public transaksi(double saldo)
    {
        this.saldo=saldo;
    }
    void cekSaldo()
    {
        System.out.println("Saldo Anda : Rp." + saldo + ",-");
    }
    @Override
    public void menabung(double tb)
    {
        
        this.saldo+=tb;
        
    }
    @Override
    public void transfer()
    {
        System.out.print("Rekening Tujuan : ");
        int rk = awa.nextInt();
        System.out.print("Nominal Transfer : Rp.");
        double tf = awa.nextDouble();
        System.out.println("Anda Akan transfer uang sebesar Rp."+tf+",- ke " +rk);
        System.out.print("Lanjut?(y/t)");
        String lanjut = awa.next();
        if("y".equals(lanjut))
        {
        if(tf<saldo)
        {
            System.out.println("Berhasil!");
            this.saldo-=tf;
            System.out.println("Saldo Anda : Rp." + saldo+ ",-");
        }
        else
        {
            System.out.println("Transfer Gagal"); 
        }
        }
        else if("t".equals(lanjut))
        {
            System.out.println("Transfer dibatalkan!");
        }
                
    }
    @Override
    public void menarik()
    {
        System.out.print("Jumlah Uang yang di tarik : Rp.");
        double tr = awa.nextDouble();
        if(tr < saldo)
        {
            this.saldo-=tr;
            System.out.println("Saldo Anda : Rp." + saldo + ",-");
                    }
        else
        {
            System.out.println("Penarikan gagal saldo anda tidak cukup");
        }  
    }
   
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class UAS extends parent{
    Double a;
    @Override
    public void NilaiSiswa()
    {
        Scanner awa = new Scanner(System.in);
        
        System.out.print("Masukkan Nilai UAS : ");
        a = awa.nextDouble();
    }
    
    public double uas ()
    {
        return uas = a * 0.2;
    }
    public void perbaikan()
    {
        if(a < 70)
        {
            System.out.println("Nilai UAS harus Diperbaiki!");
        }
       
    }
    
}

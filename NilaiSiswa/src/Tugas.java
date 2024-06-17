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
public class Tugas extends parent {
    Double a , b ,c;
    @Override
    public void NilaiSiswa()
    {
        Scanner awa = new Scanner(System.in);
        parent pa = new parent();
        System.out.print("Masukkan Nilai Tugas 1 : ");
        a = awa.nextDouble();
        System.out.print("Masukkan Nilai Tugas 2 : ");
        b= awa.nextDouble();
        System.out.print("Masukkan Nilai Tugas 3 : ");
        c = awa.nextDouble();      
        
    }
    
    public double tugas()
    {
        return tugas = (a+b+c) * 0.2;
        
    }
    
    public void perbaikan ()
    {
        
            if(a < 70)
            {
                System.out.println("Nilai Tugas 1 harus di perbaiki!");
            }
            if(b < 70)
            {
                System.out.println("Nilai Tugas 2 harus Diperbaiki! ");
            }
            if(c < 70) 
            {
                System.out.println("Nilai Tugas 3 harus di perbaiki!");
            }
            
        }
        
    
    
}

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
public class UTS extends parent{
    Double a;
    @Override
    public void NilaiSiswa()
    {
        Scanner awa = new Scanner(System.in);
        parent pa = new parent();
        
        System.out.print("Masukkan Nilai UTS : ");
        a = awa.nextDouble();
    }
    public Double uts ()
    {
        return uts = a * 0.2;
    }
    public void perbaikan()
    {
        if (a < 70)
        {
            System.out.println("Nilai UTS harus di perbaiki!");
        }
        
    }
}

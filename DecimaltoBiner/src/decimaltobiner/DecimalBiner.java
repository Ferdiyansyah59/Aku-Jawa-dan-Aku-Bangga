/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimaltobiner;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class DecimalBiner {
    Scanner awa = new Scanner(System.in);
    public void KonversiBiner()
    {
        System.out.print("Bilangan Desimal : ");
        int a = awa.nextInt();
        
        String Binary = Integer.toBinaryString(a);
        
        System.out.println("Biner : " + Binary);      
    }
    public void KonvensiOktal()
    {
        System.out.print("Bilangan Desimal : ");
        int a = awa.nextInt();
        
        String Oktal = Integer.toOctalString(a);
        
        System.out.println("Oktal : " + Oktal); 
    }
    public void KonvensiHexa()
    {
        System.out.print("Bilangan Desimal : ");
        int a = awa.nextInt();
        
        String Binary = Integer.toHexString(a);
        
        System.out.println("Hexadesimal : " + Binary);
    }
}

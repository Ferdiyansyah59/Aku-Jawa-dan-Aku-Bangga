/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemuaian;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class Muaipanjang {
    protected double panakhir , panawal , perpanjang;
   
    public Double muai()
    {
        Scanner awa = new Scanner(System.in);
        System.out.print("Panjang awal : ");
        panawal = awa.nextDouble();
        System.out.print("Pertambahan Panjang : ");
        perpanjang = awa.nextDouble();
        return panakhir = panawal + perpanjang;
    }
    
}

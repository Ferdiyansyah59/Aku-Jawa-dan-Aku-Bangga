/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputmtk;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class sisiMiring {
    
    public void miring()
    {
        Scanner awa = new Scanner(System.in);
        System.out.print("Masukkan x : ");
        double x = awa.nextDouble();
        System.out.print("Masukkan Y : ");
        double y = awa.nextDouble();
        
        double sm = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        
        System.out.println("Sisi Miring : " + sm);
        
    }
    

}

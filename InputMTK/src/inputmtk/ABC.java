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
public class ABC {
    
    public void abc ()
    {
        Scanner awa = new Scanner(System.in);
        
        System.out.print("Input Kofisien X2 : ");
        double a = awa.nextDouble();
        System.out.print("Input Koefisien X : ");
        double b = awa.nextDouble();
        System.out.print("Input Konstanta   : ");
        double c = awa.nextDouble();

        
        double z = (-b+Math.sqrt(Math.pow(b, 2)-(4*a*c))) /(2*a);  
        double q = (-b-Math.sqrt(Math.pow(b, 2)-(4*a*c))) /(2*a);   
        System.out.println("X1 : " + z);
        System.out.println("X2 : " + q);
        
    }
    
}

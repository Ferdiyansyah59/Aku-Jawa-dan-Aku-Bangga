/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termometer;

import java.util.Scanner;

/**
 *
 * @author ferdiyansyah
 */
public class kelvin {
    protected double tc , tr , tf , tk;
     Scanner awa = new Scanner(System.in);
     
     public Double celcius()
     {
         System.out.print("Kelvin : ");
         tk = awa.nextDouble();
         return tc = tk - 273;
     }
     public Double reamur()
     {
        System.out.print("Kelvin : ");
         tk = awa.nextDouble();
        return tr = (tk - 273) / 5 *4;
     }
     public Double fahreinheit()
     {
        System.out.print("Kelvin : ");
         tk = awa.nextDouble();
         return tf = (tk-273) / 5 *9 + 32;
     }
    
}

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
public class fahrenheit {
     protected double tc , tr , tf , tk;
     Scanner awa = new Scanner(System.in);
     
     public Double celcius()
    {  
        System.out.print("Fahrenheit : ");
        tf = awa.nextDouble();
        return tc = (tf-32) / 9 *5;
    }
     public Double reamur()
     {
         System.out.print("Fahrenheit : ");
        tf = awa.nextDouble();
        return tr = (tf-32) / 9 * 4;
     }
     public Double kelvin()
     {
         System.out.print("Fahrenheit : ");
        tf = awa.nextDouble();
        return tk = (tf-32) / 9 *5+273;
     }
}

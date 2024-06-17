/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termometer;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class reamur  {
     protected double tc , tr , tf , tk ;
   Scanner awa = new Scanner(System.in);
    public Double celcius()
    {  
        System.out.print("Reamur : ");
        tr = awa.nextDouble();
        return tc =tr / 4 * 5;
    }
    public Double fahreinheit()
    {
        System.out.print("Reamur : ");
        tr = awa.nextDouble();
        return tf = (tr / 4 *9) +32;
    }
    public Double kelvin()
    {
        System.out.print("Reamur : ");
        tr = awa.nextDouble();
        return tk = (tr / 4 * 5) +273;
    }
}

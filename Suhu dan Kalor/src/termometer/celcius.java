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
public class celcius  {
     protected double tc , tr , tf , tk;
     Scanner awa = new Scanner(System.in);
     
   public Double reamur()
   {    
       System.out.print("Celcius : ");
       tc = awa.nextDouble();
       return tr = tc / 5 * 4;
   }
   public Double fahreinheit()
   {
       System.out.print("Celcius : ");
       tc = awa.nextDouble();
       return tf = (tc / 5 *9) +32;
   }
   public Double kelvin ()
   {
       System.out.print("Celcius : ");
       tc = awa.nextDouble();
       return tk = tc + 273;
   }
    
}
   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usaha;

/**
 *
 * @author ferdiyansyah
 */
public class Usaha {
    
    private double massa , jarak , percepatan;

   public Usaha()
   {
       
   }
   
   public Usaha(double m , double s , double a)
   {
       massa = m;
       jarak = s;
       percepatan = a;    
   }
   public void setMassa(double m)
   {
       if(m <= 0)
       {
           massa = 1;
       }
       else
       {
           massa = m;
       }
   }
   public double getMassa()
   {
       return massa;
   }
   public void setJarak(double s)
   {
       if(s <= 0)
       {
           jarak = 1;
       }
       else
       {
           jarak = s;
       }
           
   }
   public double getJarak()
   {
       return jarak;
   }
   public void setPercepatan(double a)
   {
       if(a <= 0)
       {
           percepatan = 1;
       }
       else
       {
           percepatan = a;
       }
   }
   public double getPercepatan()
   {
       return percepatan;
   }
   
   public double Usahaa()
   {
       return massa*jarak*percepatan;
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabung13819;

/**
 *
 * @author ferdiyansyah
 */
public class Tabung13819 {

   private double jari , tinggi;

   
   public Tabung13819()
   {
       
   }
   
   public Tabung13819(double r , double t)
   {
       jari = r;
       tinggi = t;
   }
   

    
   
   public void setJari(double r)
   {
       if(r <= 0)
       {
           jari =1;
       }
       else
       {
           jari = r;
       }
       
   
   }
   public double getJari()
   {
       return jari;
   }
    
  
   
   public void setTinggi(double t)
   {
       if(t <= 0)
       {
           tinggi =1;
       }
       else
       {
           tinggi = t;
       }
       
      
   }
   public double getTinggi()
   {
       return tinggi;
   }
   public double luasAlas()
   {
       
       return Math.PI*(jari * jari);
   }
   public double kelLingkaran()
   {
       
       return 2*Math.PI*jari;
   }
   public double LuasTabung()
   {
      
     return 2*luasAlas() + (kelLingkaran() * tinggi); 
   }
   public double volTabung()
   {
  
       return luasAlas()*tinggi;
   }
}

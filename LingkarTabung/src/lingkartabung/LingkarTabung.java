/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingkartabung;

/**
 *
 * @author ferdiyansyah
 */
public class LingkarTabung {
    
       public double jari ;
    
    public LingkarTabung()
    {
    
    }
    public LingkarTabung(double r)
    {
        jari = r;
    }


   
   public void setjari(double r)
   {
       if(r <= 0)
       {
           jari = 1;
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
   public double luasLingkaran()
   {
       return Math.PI*(jari*jari);
   }
   public double KelLingkaran()
   {
       return 2*Math.PI*jari;
   }
    
}

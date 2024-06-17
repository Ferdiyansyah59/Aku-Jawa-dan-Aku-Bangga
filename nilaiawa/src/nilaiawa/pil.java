/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilaiawa;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author ferdiyansyah
 */
public class pil extends parent{
    
    @Override
    public void nilai()
    {
         DecimalFormat dc = new DecimalFormat("#.##");
         Scanner awa = new Scanner(System.in);
         
         parent p = new parent();
         
         
         
             System.out.println("--------------------------------");
        
            String ulang = "y";
         while(ulang.equals ("y"))
         {
        System.out.println("1.Rata-Rata");
        System.out.println("2.Maksimum");
        System.out.println("3.Minimum");
        System.out.print("Pilih : ");
        pilih =awa.next(); 
             
         float rata;
        
        switch (pilih) {
            case "1":
                rata = total / x;
                System.out.println("Rata-Rata " + Double.valueOf(dc.format(rata)));
                
                
                
                break;
            case "2":{
                int max = p.bil[0];
                for(int i =0;i<x;i++)
                {
                    if(bil[i] > max)
                    {
                        max = bil[i];
                        
                    }
                    
                }           System.out.println( "Max " + max);
                break;
            }
            case "3":{
                int max = bil[0];
                for(int j =0; j<x;j++)
                {
                    
                    if(bil[j] < max)
                    {
                        
                        max = bil[j];
            }
           
        }           System.out.println("Min " + max);
                    break;
                }
            default:{
                System.out.println("Opsi Tidak Di Temukan");
                
               
                
                
            }
            }
         System.out.print("Apakah ingin mengulang ?(y/t)");
             ulang = awa.next();
             if("y".equals(ulang))
             {
                  for(int m =0;m<bil.length;m++)
                {
                    System.out.println(bil[m]);
                }
             }
        }
    }
    
}

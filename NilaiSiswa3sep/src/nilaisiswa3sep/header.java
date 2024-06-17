/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilaisiswa3sep;

/**
 *
 * @author ferdiyansyah
 */

import java.util.*;

import java.text.DecimalFormat;


public class header extends parent {
     
    protected String pilih; 
  
   
    @Override
    public void header()
    {        
        parent p = new parent();
        DecimalFormat dc = new DecimalFormat("#.##");
        Scanner awa = new Scanner(System.in);  
         
        System.out.print("Masukkan banyak siswa : ");
        p.x = awa.nextInt();
         
        int bil [] = new int[p.x]; 
        
        for(int i = 0;i<bil.length ;i++)
        {
            System.out.print("Siswa ke-" +(i+1)+ " :");
            bil[i] = awa.nextInt();
            p.total = p.total + bil[i];
        }
             System.out.println("------------------------------------------");
        for(int b : bil)
        {
            System.out.println("Nilai siswa : " + b);
        }
             System.out.println("------------------------------------------");
        
             int c = 0;
         String ulang = "y";
         while(ulang.equals ("y"))
         {  
        System.out.println("\n1.Nilai Total");
        System.out.println("2.Rata-Rata");
        System.out.println("3.Maksimum");
        System.out.println("4.Minimum");
        System.out.println("5.Exit");
        System.out.print("Pilih : ");
        pilih =awa.next(); 
             
         
          
         switch (pilih) {
             case"1":
                 System.out.println("Total Nilai : " + p.total);
             break;
        
        
            case "2":
                p.rata = p.total / p.x;
                System.out.println("Rata-Rata " + Double.valueOf(dc.format(p.rata)));
                
                
                
                break;
            case "3":{
                int max = bil[0];
                for(int i =0;i<p.x;i++)
                {
                    if(bil[i] > max)
                    {
                        max = bil[i];
                        
                    }
                    
                }           System.out.println( "Max " + max);
                
                
               
                break;
            }
            case "4":{
                int max = bil[0];
                for(int j =0; j<p.x;j++)
                {
                    
                    if(bil[j] < max)
                    {
                        
                        max = bil[j];
                    }
           
                } System.out.println("Min " + max);
                    break;
                }
            case "5":{
                System.out.println("Terima Kasih");
                System.exit(c);
                break;
            }
            default:{
                System.out.println("Opsi Tidak Di Temukan");
                System.exit(c);
                break;
                
               
                
                
            }
            }
//             System.out.print("Apakah ingin mengulang ?(y/t)");
//             ulang = awa.next();
//             if("y".equals(ulang))
//             {
             System.out.println("------------------------------------------");
                  for(int m =0;m<bil.length;m++)
                {
                    System.out.println("Nilai Siswa : " + bil[m]);
                   
                    
                }
//             }
        }
        
            
    } 
      
        
}
    


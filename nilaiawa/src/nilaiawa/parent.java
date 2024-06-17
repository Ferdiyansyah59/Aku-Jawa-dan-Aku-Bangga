/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilaiawa;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class parent {
     protected int x;
     float total =0;
     protected String pilih; 
     int bil [] ;
     
     public void nilai()
    {
        Scanner awa = new Scanner(System.in);
        
        System.out.print("Masukkan banyak siswa : ");
         x = awa.nextInt();
        
         bil[x] = 0;
        
        for(int i = 0;i<bil.length ;i++)
        {
            System.out.print("Siswa ke-" +(i+1)+ " :");
            bil[i] = awa.nextInt();
            total = total + bil[i];
        }
             System.out.println("--------------------------------");
        for(int b : bil)
        {
            System.out.println("Nilai siswa : " + b);
        }
    }
    
}

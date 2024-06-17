/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilanganprima2;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class BilanganPrima2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        int a , b;
        Scanner cari = new Scanner(System.in);
         
          String ulang = "y";
        while(ulang.equalsIgnoreCase("y"))
        {
        System.out.println("Login"); 
        System.out.print("Masukkan User : ");
        String z = cari.next();
        System.out.print("Masukkan Password : ");
        String y = cari.next();
            System.out.println("--------------------------------------");
        if("ferdi".equals(z) && "lak".equals(y))
        {       
       
        System.out.print("Bilangan Awal  : ");
        a = cari.nextInt();
        System.out.print("Bilangan akhir : ");
        b= cari.nextInt();
        
        
        for(int i=a;i<=b;i++)
        {
            int x = 0;
            for(int j=1;j<=i;j++)
            {
                if(i%j==0)
                    x=x+1;
            }      
            
            if(x==2)
                System.out.print(i +  " ");
        }
       
        
        }
        else{
        
            System.out.println("Username atau Password Salah");
             
        }
       System.out.print("\nApakah mau mengulang?(y/t) ");
            ulang = cari.next();
           
        }
    }
        
    }
    
    


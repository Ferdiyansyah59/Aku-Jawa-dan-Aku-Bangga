/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilanganprima;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class BilanganPrima {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner tulis = new Scanner(System.in);
        int a , b ;
        boolean prima = true;
        
        System.out.print("Masukkan angka pertama(Min 100) : ");
        a = tulis.nextInt();
        System.out.print("Masukka angka kedua(Max 200)    : ");
        b = tulis.nextInt();
        
        if(b <= 200)
        {
            for(int i=a;i<=b;i++)
            {
                for(int j = 2;j<i;j++)
                {
                    int c=0;
                    if((i%j)==0)
                    {
                        prima = false;
                        
                    }
                    
                }
                if(prima)
                    
                    System.out.print(+i + " ");
                    
                    prima = true;
                
             }
           
          
        }
        
        else
        {
            System.out.println("Melebihi Batas");
        }
    }
    
}

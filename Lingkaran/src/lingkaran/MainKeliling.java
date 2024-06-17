/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingkaran;

/**
 *
 * @author ferdiyansyah
 */

public class MainKeliling {
    
   
    public static void main(String[] args) {
       
        
        
        System.out.println("Lingkaran");
        System.out.println("============");
        
        Lingkaran main = new Lingkaran();
        double a = main.R();
        
        if(a < 0)
        {
            System.out.println("Jari-Jari tidak boleh Negatif");
        }
        else
        {
        System.out.println("Luas " + main.Luas());
        System.out.println("Keliling = " + main.Keliling());
        }  
        
      
       
        
    }
    
}

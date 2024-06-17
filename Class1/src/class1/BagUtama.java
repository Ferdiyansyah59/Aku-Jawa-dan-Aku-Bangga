/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class1;

/**
 *
 * @author ferdiyansyah
 */
public class BagUtama {
    
    public static void main(String[] args) {
        BagAtas obyek1 = new BagAtas();
        obyek1.judul();
        
        
       
       BagTengah obyek2 = new BagTengah();
       int a = obyek2.InputData();
       if(a%2 == 0)
       {
           obyek1.judul();
       
           
       }
       else 
       {
           System.out.println("Bilangan ganjil");
       }
   }
    }
          
    


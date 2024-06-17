/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class3;

/**
 *
 * @author ferdiyansyah
 */
public class BagUtama {

   public static void main (String[] args){
       Class1 obyek1 = new Class1();
       obyek1 = judul();
       
       Class2 obyek2 = new Class2();
       int a = obyek2.inputAngka();
       if(a%2 == 0)
       {
           System.out.println("Bilangan Genap");
       }
       else if(a%2 == 1)
       {
           System.out.println("Bilangan ganjil");
       }
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author ferdiyansyah
 */
public class Animal {

   protected String nama , sifat;
   protected int ukuran;
   
   public void setNama(String nama)
   {
       this.nama=nama;
   }
   public String getNama()
   {
       return nama;
   }
   public void setUkuran(int ukuran)
   {
       this.ukuran = ukuran;
   }
   public int getUkuran()
   {
       return ukuran;
   }
   public void setSifat(String sifat)
   {
       this.sifat=sifat;
   }
   public String getSifat()
   {
       return sifat;
   }
   
   
    
}

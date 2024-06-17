/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eksepsi;

/**
 *
 * @author ferdiyansyah
 */
public class Eksepsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.println(3/0);
            System.out.println("Cetak");
        }
        catch(ArithmeticException e)
        {
            System.out.println("Pembagian tidak boleh nol");
            System.out.println(e);
        }
        
        int angka[] = {1,2,3,4};
        try{
            System.out.println(angka[5]);
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println(ex);
            System.out.println("Index diluar batas Array");
        }
        
        
        System.out.println("\n\n\n");
        String passw = null;
        
        try
        {
            if(passw.equals("xxx"))
            {
                System.out.println("Selamat Datang");
            }
            else
            {
                System.out.println("Mari kita belajar bahasa jawa");
            }
        }
        catch(NullPointerException d)
        {
            System.out.println(d);
            System.out.println("Penggunaan null tidak valid");
        }
        
        System.out.println("\n\n");
        
        int bil = 10;
        
        try{
            System.out.println(bil/0);
        }
        catch(ArithmeticException z)
        {
            System.out.println("Peambagi tidak boleh nol");
        }
        catch(Exception e)
        {
            System.out.println("Ada error yang terjadi");
        }
        
        
        System.out.println("\n\n");
        String alamat = null;
        String buah[] = {"anggur","belimbing","Salak","Delima"};
        Object nama[] = new Float[2];
        
        try{
//               alamat.equals("jakarta");
//            System.out.println(buah[5]);
//            int a = 3/0;
//            nama[0] = new Integer(2);
        }
        catch(NullPointerException e)
        {
            System.out.println("Contih-1 catch");
            System.out.println(e);
            System.out.println("Penggunaan null tiidak valid");
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Contoh-2 catch :");
            System.out.println(ex);
            System.out.println("Index diluar batas array");
        }
        catch(ArithmeticException exc)
        {
            System.out.println("Contoh-3 catch :");
            System.out.println(exc);
            System.out.println("Pembagian tidak boleh nol");
        }
        catch(ArrayStoreException excp)
        {
            System.out.println("Contoh-4 catch :");
            System.out.println(excp);
            System.out.println("Penyimpanan aray dengan tipe data yang tidak sesuai");
        }
        
        System.out.println("\n\n");
        
        int a[] = new int[2];
        
        try
        {
            System.out.println("Mengakses indeks ke-3:" + a[3]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
            System.out.println("Indeks diluar batas array");
        }
        finally
        {
            a[1] = 6;
            System.out.println("\nPernyataan'finally' yang dieksekusi : ");
            System.out.println("Data indeks - satu: "+a[1]);
        }
    }
    
}

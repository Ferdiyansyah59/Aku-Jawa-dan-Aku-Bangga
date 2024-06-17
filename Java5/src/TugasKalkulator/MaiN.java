/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TugasKalkulator;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class MaiN {
    
    int contoh; //ini variabel Global
    public static void main(String[] args) { 
    //ini Class Main 
        
        int pilih;//ini variabel lokal
        double hasil;//ini juga variabel lokal
        Scanner cari = new Scanner(System.in);
        
        Java5 abc= new Java5(); //pemanggil class lain
        abc.identitas();//object
        System.out.println(" ");
        
        String ulang = "y";
        while(ulang.equals("y")){
            
        Inputan1 bcd = new Inputan1();//pemanggil class lain
            double a = bcd.inputin();//object
            Input2 cef = new Input2();//pemanggil class lain
            double b = cef.input2();//object
        
        System.out.println("--------------");
        System.out.println("1.Penjumlahan");
        System.out.println("2.Pengurangan");
        System.out.println("3.Perkalian");
        System.out.println("4.Pembagian");
        System.out.println("5.Modulus");
        System.out.print("Pilih : ");
        pilih = cari.nextInt();
        
        System.out.println("-----Hasil operasi-----");
        if(pilih == 1)//ini parameter
        {
           
            hasil = a+b;
            System.out.println("Hasil Penjumlahan : " + hasil);
            
            
            
        }
        else if(pilih == 2)//ini parameter
        {
            
            
            hasil = a-b;
            System.out.println("Hasil Pengurangan : " + hasil);
        }
        else if(pilih == 3)//ini parameter
        {
            
            
            hasil = a*b;
            System.out.println("Hasil Perkalian : " + hasil);
        }
        else if(pilih == 4)//ini parameter
        {
           
            
            hasil = a/b;
            System.out.println("Hasil Pembagian : " + hasil);
            
            if(a == 0)//ini parameter
            {
                System.out.println("Gak bisa 0");
            }
            else if(b == 0)//ini parameter
            {
                System.out.println("Gak bisa 0");
            }
        }
        else if(pilih == 5)//ini parameter
        {
          
            hasil = a%b;
            System.out.println("Hasil Modulus : " + hasil);
        }
        else
        {
            System.out.println("Operator tidak tersedia");
        }
        
            System.out.print("Apakah mau ulang?(y/t)");
            ulang = cari.next();
    }
    
}
}




/*
3.Bisa
4.Tidak bisa
*/
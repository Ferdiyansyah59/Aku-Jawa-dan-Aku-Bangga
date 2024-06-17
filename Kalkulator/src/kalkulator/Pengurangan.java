/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class Pengurangan {
    
      public double kurang()
{
    double angka1,angka2,hasil;
    Scanner key = new Scanner(System.in);
    System.out.print("Masukkan angka : ");
    angka1 = key.nextDouble();
    System.out.print("Masukkan angka : ");
    angka2 = key.nextDouble();
    
    hasil = angka1 - angka2;
    System.out.println("Hail : "+hasil);
    
    
    return hasil;


}
}

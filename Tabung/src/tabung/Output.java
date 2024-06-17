/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabung;

/**
 *
 * @author ferdiyansyah
 */
import java.util.Scanner;
public class Output {
   public double hasil()
   {
       Scanner apa = new Scanner(System.in);
       Input1 angka1 = new Input1();
       double a = angka1.angka();
       Input2 angka2 = new Input2();
       double b = angka2.angka();
       
       double hsl;
       hsl = a + b;
       System.out.println("Hail " + hsl);
       return hsl;
       
   }
}

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
public class Input1 {
    public double angka()
    {   
        Scanner apa = new Scanner(System.in);
        double pilih;
        System.out.print("Masukkan Angka : ");
        pilih = apa.nextDouble();
        return pilih;
    }
}

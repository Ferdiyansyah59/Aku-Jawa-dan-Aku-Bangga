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
public class Input2 {
    //ini adalah class
    
    public double input2()//ini adalah method
    {
        Scanner abb = new Scanner(System.in);
        double input;
        System.out.print("Masukkan bil 1 : ");
        input = abb.nextDouble();
        
        return input;
    }
    
}

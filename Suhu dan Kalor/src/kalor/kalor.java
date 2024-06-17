/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalor;

import java.util.Scanner;

/**
 *
 * @author ferdiyansyah
 */
public class kalor {
    protected double q , m , c , t;
   
    public Double kaalor()
    {
        Scanner awa = new Scanner(System.in);
        System.out.print("Massa : ");
        m = awa.nextDouble();
        System.out.print("Kalor Jenis : ");
        c = awa.nextDouble();
        System.out.print("Perubahan Suhu : ");
        t = awa.nextDouble();
        return q = m * c * t;
    }
}

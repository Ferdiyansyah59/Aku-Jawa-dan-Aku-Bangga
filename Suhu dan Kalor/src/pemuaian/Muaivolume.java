/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pemuaian;

import java.util.Scanner;

/**
 *
 * @author ferdiyansyah
 */
public class Muaivolume  {
   
    protected double volakhir , volawal , pervolume;
    public Double muai()
    {
        Scanner awa = new Scanner(System.in);
        System.out.print("Volume awal : ");
        volawal = awa.nextDouble();
        System.out.print("Pertambahan volume : ");
        pervolume = awa.nextDouble();
        return volakhir = volawal + pervolume;
    }
}

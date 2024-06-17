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
public class Muailuas {
    
    protected double luakhir , luawal , perluas;
    
    public Double muai()
    {
        Scanner awa = new Scanner(System.in);
        System.out.print("Luas awal : ");
        luawal = awa.nextDouble();
        System.out.print("Pertambahan Luas : ");
        perluas = awa.nextDouble();
        return luakhir = luawal + perluas;
    }
}

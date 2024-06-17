/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bola;

/**
 *
 * @author ferdiyansyah
 */
public class main {
    public static void main(String[] args) {
        Permainan main = new Permainan();
      
        System.out.println("=====" + main.pertandingan +"=====");
        main.lempar();
        main.menggelinding();
        main.tendang();
        main.sundul();
        main.tangkap();
        main.setBunyi("Wasit meniup peluit tanda pertandingan selesai");
        System.out.println(main.getBunyi());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poli;

/**
 *
 * @author ferdi
 */

//psvm ---> tab
public class SuaraHewan {
    public static void main(String[] args) {
        Hewan hw = new Hewan();
        Kuda kd = new Kuda();
        Kucing kc = new Kucing();
        
        hw.suara();
        
        hw = kd;
        hw.suara();
        
        hw = kc;
        hw.suara();
    }
}

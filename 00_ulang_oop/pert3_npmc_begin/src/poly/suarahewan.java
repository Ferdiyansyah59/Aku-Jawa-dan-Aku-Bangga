/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly;

/**
 *
 * @author ferdi
 */
public class suarahewan {
    public static void main(String[] args) {
        hewan hw = new hewan();
        kuda kd = new kuda();
        kucing kc = new kucing();
        
        hw.suara();
        
        hw = kd;
        hw.suara();
        
        hw = kc;
        hw.suara();
    }
}

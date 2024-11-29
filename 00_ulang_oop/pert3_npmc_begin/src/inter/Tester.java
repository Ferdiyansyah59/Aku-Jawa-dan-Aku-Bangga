/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

/**
 *
 * @author ferdi
 */
public class Tester {
    public static void main(String[] args) {
        Senjata gun = new Senjata(7);
        gun.tembakSenjata();
        gun.tembakSenjata();
        
        System.out.println("Sisa pelor " + gun.pelor);
        gun.reloadSenjata();
        gun.tukarSenjata(0);
    }
}

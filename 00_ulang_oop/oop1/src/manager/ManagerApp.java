/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author ferdi
 */
public class ManagerApp {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.name = "Ferdi";
        manager.sayHello("Paijo");
        
        VicePresident vp = new VicePresident();
        vp.name = "Perdi";
        vp.sayHello("Manager");
    }
}

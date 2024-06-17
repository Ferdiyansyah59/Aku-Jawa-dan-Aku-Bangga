/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfisme;

/**
 *
 * @author ferdiyansyah
 */
public class MainAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Kucing cat = new Kucing();
        Anjing dog = new Anjing();
        Bebek dock = new Bebek();
        
        animal.suara();
        cat.suara();
        dog.suara();
        dock.suara();
    }
    
}

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
public class Manager {
    String name;
    
    void sayHello(String name){
        System.out.println("Hi " + name + ", My Name Is " + this.name);
    }
}

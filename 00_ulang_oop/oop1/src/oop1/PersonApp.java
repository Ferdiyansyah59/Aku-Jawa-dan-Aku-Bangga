/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1;

/**
 *
 * @author ferdi
 */
public class PersonApp {
    public static void main(String[] args) {
//        Cara pertama
        Person person1 = new Person("Ferdiyans", "Jakarta");
//        Cara kedua
        Person person3;
//        person3 = new Person("Perdi");
        
//        person1.name = "Ferdiyansyah";
//        person1.address = "Jakarta";
        person1.sayHello("Mansia Bumi");
        person1.sayHi("Perdi");
         
//        person3.name = "Paijo Sutrisno";
        
        System.out.println(person1.name);
        System.out.println(person1.address);
        System.out.println(person1.country);
//        System.out.println(person3.name);
        
//        Person person2 = new Person();
        
    }
}

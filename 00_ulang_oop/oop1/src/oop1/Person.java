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
public class Person {
    String name;
    String address;
//        Valuenya fix atau gabisa di ubah lagi
    final String country = "Indonesia";
    
//    Constructor itu method yang pertama kali di akses pas object itu dibuat
//    Kalo construc ada parameternya nanti pas bikin object wajib ditambahin atribut buat parameter construc nya kalo nggk error
    
//    Nah tapi kalo misalnya mau gak wajib bikin constructor overloading jadi nanti bikin constructor lain yang gak ada parameternya atau parameternya di kurangin gitu
    
//    Bisa dipake kalo kita butuh parameter buat constructor tapi pengen gak wajib gitu atau ada yang optional
//    Person(String paramName, String paramAddress) {
//        name = paramName;
//        address = paramAddress;
//    }
    
//    Person(String paramName){
//        name = paramName;
//    }
//    
//    Person(){
//        
//    }
    
//    Atau nulisnya bisa gini
    
//    Jadi ini manggil constructor lain, nah kalau misalnya manggil construct yang 2 parameter isi 2 parameternya tapi kalo kayak
//    contoh dibawahnya manggil construct yang 1 parameter berarti isi parameternya 1 aja gitu deh.
//    Person(String paramName){
//        this(paramName, null);
//    }
//    
//    Person(){
//        this(null);
//    }
    
//    Kalo di situasi di dalem construct atau di dalam method nama parameter sama nama properti(field) nya sama bisa pake this
    Person(String name, String address){
//        yang di ruas kiri ini merepresentasikan propertinya sedangkan yang ruas kanan itu merepresentasikan parameternya
        this.name = name;
        this.address = address;
    }
    
    void sayHi(String name){
        System.out.println("Hi " + name + " My Name is " + this.name);
    }
    
    void sayHello(String paramName){
        System.out.println("Hello " + paramName + " My Name is " + name);
    }
    
    public static void main(String[] args) {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert2;

class MyClass {
    void tulis(){
        System.out.println("Tidak ada parameter");
    }
    
    void tulis(double d){
        System.out.println("Dengan satu "
                + "parameter bernilai : " + d);
    }
}

public class No9 {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.tulis();
        mc.tulis(9.5);
    }
}

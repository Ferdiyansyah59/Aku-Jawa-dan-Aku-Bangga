/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parent;

/**
 *
 * @author ferdiyansyah
 */
public class Mymain {
    
    public static void main(String[] args) {
        Parent tes = new Child();
        System.out.println("Nilai x : " + tes.x);
        tes.info();
    }
    
}

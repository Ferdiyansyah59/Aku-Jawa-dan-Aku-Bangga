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
class VicePresident extends Manager{
    
//    Tapi kalo ada override nanti method sayHello yang di Manager jadi gabisa dipake lagi keganti sama yang baru disini
    @Override
    void sayHello(String name){
        System.out.println("Aku adalah " + name + " Manusia " + this.name);
    }
    public static void main(String[] args) {
        
    }
}

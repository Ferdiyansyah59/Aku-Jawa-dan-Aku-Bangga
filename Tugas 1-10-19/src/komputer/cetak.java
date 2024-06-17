/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komputer;

/**
 *
 * @author ferdiyansyah
 */
public class cetak {
    public static void main(String[] args) {
        Laptop lp = new Laptop();
        
        lp.setEnter("Tekan Enter......");
        
        System.out.println("=====Komputer=====");
        System.out.println(lp.kom + lp.kan);
        System.out.println(lp.kom + lp.kir);
        lp.doubleKlik();
        
        System.out.println("\n=====PC=====");
        lp.tekanEnter();
        
        lp.setLaptop("Mouse Laptop : ");
        
        
        System.out.println("\n=====Laptop=====");
        System.out.println("Jenis Laptop : " + lp.jenis);
        System.out.println(lp.getLaptop()+lp.kan);
        System.out.println(lp.getLaptop()+lp.kir);
        System.out.println(lp.getLaptop()+"Double Klik");
        System.out.println("Keyboard Laptop : " + lp.getEnter());
        
    }
}

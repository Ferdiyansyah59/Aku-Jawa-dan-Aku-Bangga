/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematika;

/**
 *
 * @author ferdiyansyah
 */
public class Matematika {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("Nilai Mutlak -5 : " + Math.abs(-5));
        System.out.println("Nilai Mutlak  5 : " + Math.abs(-5));
        System.out.println("Nilai Maximum   : " + Math.max(2,10));
        System.out.println("Nilai Minimum   : " + Math.min(2,10));
        System.out.println("10 Pangkat 2    : " + Math.pow(10, 2));
        System.out.println("2 Pangkat 3     : " + Math.pow(2, 3));
        System.out.println("Akar 36         : " + Math.sqrt(36));
        System.out.println("Pembulatan Kebawah dari -3.333 : " + Math.floor(-3.333));
        System.out.println("Pembulatan Keatas dari -3.333 : " + Math.ceil(-3.333));
        System.out.println("Cos 0 : " + Math.cos(Math.toRadians(0)));
        System.out.println("Sin 90 : " + Math.sin(Math.toRadians(90)));
        System.out.println("Tan 45 : " + Math.tan(Math.toRadians(45)));
        System.out.println("Exsponen e pangkat 2 : " + Math.exp(2));
        System.out.println("ln 7.38905609893065 " + Math.log(7.38905609893065));
        System.out.println("log1000=" + Math.log10(1000));
        System.out.println("Random : " + Math.random()*100);
        System.out.println("phi : " + Math.PI);
        System.out.println("Pembulatan dari phi : " + Math.round(Math.PI));
        
    }
    
}

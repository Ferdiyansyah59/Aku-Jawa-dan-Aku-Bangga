/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbal;

/**
 *
 * @author ferdi
 */
public class Timbal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cetak = "";
        int x;
        for(x = 1; x<=10; x++){
            if(x==5)break;
            else cetak = cetak + x + "";
        }
        System.out.println(cetak);
    }
    
}

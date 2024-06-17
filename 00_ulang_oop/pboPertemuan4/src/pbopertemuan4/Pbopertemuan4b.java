/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan4;

import javax.swing.JOptionPane;

/**
 *
 * @author ferdi
 */
public class Pbopertemuan4b {
    
    static int pangkat(int x, int y){
        if (y == 0){
            return 1;
        }else{
            return x * pangkat(x, y-1);
        }
    }
    public static void main(String[] args) {
        int bil, pangkat;
        
        bil = Integer.valueOf(JOptionPane.showInputDialog("Masukkan Bilangan: "));
        pangkat = Integer.valueOf(JOptionPane.showInputDialog("Masukkan Pangkat: "));
        
        String pesan = bil + "^" + pangkat + "=" + pangkat(bil, pangkat);
        
        JOptionPane.showMessageDialog(null, pesan);
        
    }
}

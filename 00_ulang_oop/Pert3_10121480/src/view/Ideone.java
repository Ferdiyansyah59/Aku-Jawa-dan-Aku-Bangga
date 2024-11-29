/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author ferdi
 */
public class Ideone {
    
    public static Integer hitungNomorBit(int angka, int nomorBit) {
      
        StringBuilder biner = new StringBuilder();
        
        while (angka > 0) {
            int sisa = angka % 2;
            biner.insert(0, sisa);
            angka = angka / 2;
        }
        
        
        char[] binerArray = biner.toString().toCharArray();

      
        if (nomorBit >= 0 && nomorBit < binerArray.length) {
            int hasil = 0;
        
            for (int i = nomorBit; i < binerArray.length; i++) {
                if (binerArray[i] == '1') {
                    hasil += Math.pow(2, binerArray.length - 1 - i);
                }
            }
            return hasil;
        }
        
        return null;
    }

    public static void main(String[] args) {
        System.out.println(hitungNomorBit(13, 0));  // Output: 1
        System.out.println(hitungNomorBit(13, 1));  // Output: 3
        System.out.println(hitungNomorBit(13, 2));  // Output: null
    }
}
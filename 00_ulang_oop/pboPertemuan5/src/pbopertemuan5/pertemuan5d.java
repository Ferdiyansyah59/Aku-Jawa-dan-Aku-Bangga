/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan5;

import java.util.Scanner;

/**
 *
 * @author ferdi
 */

public class pertemuan5d {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        
        int jmlItem;
        System.out.print("Masukkan Jumlah Item: ");
        jmlItem = awa.nextInt();
        
        String item[] = new String[jmlItem];
        
        System.out.println("Masukkan : " + jmlItem + " Barang ");
        for(int i = 0; i < jmlItem; i++){
            item[i] = awa.next();
        }
        
        System.out.println("Daftar Barang yang disimpan");
        
        for(int i=0;i<jmlItem;i++){
            System.out.println((i+1) + "." + item[i]);
        }
        
        System.out.print("Tambahkan Barang ");
        String itembaru = awa.next();
        
        for(int i = 0; i<jmlItem;i++){
            if(item[i] == null){
                item[i] = itembaru;
                break;
            }
        }
        
        System.out.println("==============");
        for(String dd: item){
            System.out.println(dd);
        }
    }
}

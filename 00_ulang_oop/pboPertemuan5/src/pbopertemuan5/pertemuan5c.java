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
public class pertemuan5c {
    public static void main(String[] args) {
        int n = 0;
        Scanner awa = new Scanner(System.in);
        
        System.out.print("Masukkan Jumlah Data :");
        n = awa.nextInt();
        
        String data[] = new String[n];
        
        for(int i = 0; i < data.length;i++){
            System.out.print("Data ke-"+i+":");
            data[i] = awa.next();
        }
        
        System.out.println("-----------------------------");
        for(String d: data){
            System.out.println(d);
        }
    }
}

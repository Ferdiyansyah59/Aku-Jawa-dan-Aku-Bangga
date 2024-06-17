/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan3;

import java.util.Scanner;

/**
 *
 * @author ferdi
 */
public class pertemuan3b {
    static Scanner awa = new Scanner(System.in);
    public static void main(String[] args) {
        int batas;
        System.out.print("Masukakn batas: ");
        batas = awa.nextInt();
        int i = 1;
        do{
            System.out.print(i*i+" ");
            i++;
        }while(i <= batas);
        
        
//        int i = 1;
//        while(i <= batas){
//            System.out.print(i+" ");
//            i+=2;
//        }
            
        
        
//        for(int i = 1; i <= batas; i++){
//            System.out.println("Perulangan ke-"+i);
//        }
        
    }
}

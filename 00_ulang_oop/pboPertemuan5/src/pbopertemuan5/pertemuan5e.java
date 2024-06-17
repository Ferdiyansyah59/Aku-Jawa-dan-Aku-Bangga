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
public class pertemuan5e {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        
        int row, cols, m;
        
        System.out.print("Masukkan Baris: ");
        row = awa.nextInt();
        
        System.out.print("Masukkan Kolom: ");
        cols = awa.nextInt();
        
        int mat1[][] = new int[row][cols];
        int mat2[][] = new int[row][cols];
        
        System.out.println("Isi Element Matriks A!!");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols;j++){
                System.out.print("Masukkan baris ke-["+(i+1)+"]"+"["+(j+1)+"]: ");
                mat1[i][j] = awa.nextInt();
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("Matriks A: ");
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols;j++){
                System.out.print(mat1[i][j]+ " ");
            }
            System.out.println("");
        }
        
        System.out.println("-------------------------------------------");
        System.out.println("Isi Element Matriks B!!");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols;j++){
                System.out.print("Masukkan baris ke-["+(i+1)+"]"+"["+(j+1)+"]: ");
                mat2[i][j] = awa.nextInt();
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("Matriks B: ");
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols;j++){
                System.out.print(mat2[i][j]+ " ");
            }
            System.out.println("");
        }
        
        System.out.println("---------------------------------------------");        
        System.out.println("Hasil Penjumlahan Matriks A dan B");        
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols;j++){
                System.out.print((mat1[i][j]+ mat2[i][j]) + " ");
            }
            System.out.println("");
        }
        
//        System.out.println("---------------------------------------------");        
//        System.out.println("Hasil Perkalian Matriks A dan B");        
//        
//        for(int k = 0; k < row; k++){
//            for(int i = 0; i < row; i++){
//                int jumlah = 0;
//                for(int j = 0; j < cols;j++){
//                    jumlah = jumlah + (mat1[i][j] * mat2[j][i]);
//                }
//                mat1[k][i] = jumlah;
//                jumlah = 0;
//            }
//             System.out.println("");
//        }
//        
//        
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < cols;j++){
//                System.out.print(mat1[i][j] + " ");
//            }
//            System.out.println("");
//        }
        
        
    }
}

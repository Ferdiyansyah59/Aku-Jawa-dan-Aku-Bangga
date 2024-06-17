/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author genta
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utspbo {
    static Scanner g = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            int lantai, kamar;
            int jmlKamar = 0;
            int jmlLama = 0;
            int lama;

            System.out.print("Masukkan Jumlah Lantai Kamar Hotel:  ");
            lantai = g.nextInt();

            System.out.print("Masukkan Jumlah Kamar Hotel:  ");
            kamar = g.nextInt();
            
            if(lantai == 0){
                throw new RuntimeException("Lantai Tidak Ditemukan!");
            }else if(kamar == 0){
                throw new RuntimeException("Kamar Tidak Ditemukan!");
            }
            
            for(int i = 0; i <= lantai; i++){
                if((i+1) == 4 || (i+1) == 13 || (i+1) == 14){
                    continue;
                }else{
                    for(int j = -1; j <= kamar; j++){
                        if((j+2) == 3 || (j+2) == 4 || (j+2) == 13 || (j+2) == 14){
                            continue;
                        }else{
                            System.out.println("====================");
                            System.out.println("Lantai Ke "+ (i+1));
                            System.out.println("Kamar No. "+ (j+2));
                            System.out.print("Lama Huni = ");
                            lama = g.nextInt();
                            if(lama < 0){
                                throw new IllegalArgumentException("Lama Huni Tidak Bisa Negatif!");
                            }
                            jmlLama += lama;
                            jmlKamar++;
                        }
                    }
                }
            }
            System.out.println("Jumlah Kamar: " + jmlKamar);
            System.out.println("Total Lama Huni: " + jmlLama);
            double tingkatHuni = (double) jmlLama / (jmlKamar * 30);
            System.out.printf("Tingkat Hunian Hotel: %.2f ", tingkatHuni);
            System.out.println("");
        } catch (InputMismatchException e) {
            System.err.println("Input yang dimasukkan bukan bilangan bulat.");
        } catch (IllegalArgumentException e) {
            System.err.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        } finally{
            System.out.println("Terima Kasih Telah Berkunjung :D");
        }
    }
}

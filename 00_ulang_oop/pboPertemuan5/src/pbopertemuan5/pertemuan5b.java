/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan5;

/**
 *
 * @author ferdi
 */
public class pertemuan5b {
    public static void main(String[] args) {
        String nama[] = {"Vini", "Vici", "Vidi", "Viko"};
        int uts[] = {70, 80, 100, 30};
        int uas[] = {90, 40, 90, 50};
        
        System.out.println("\tData Mahasiswa");
        System.out.println("-------------------------------------------------");
        System.out.println("No\tNama\tUTS\tUAS\tRata2");
        System.out.println("-------------------------------------------------");
        
        for(int i=0; i<nama.length;i++){
            int rata = (uts[i] + uas[i]) / 2;
            System.out.println(i+1+"\t"+nama[i]+"\t"+uts[i]+"\t"+uas[i] + "\t" +rata);
        }
        System.out.println("");
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pegawairevisi;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class PegawaiRevisi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner awa = new Scanner(System.in);
        int a;
        System.out.print("Input banyak pegawai : ");
        int x = awa.nextInt();
        
        int bil [][] = new int [x][a];
        for(int i = 0; i<bil.length;i++)
        {
            System.out.print("pap : ");
            bil[i] = awa.nextInt();
        }
    }
    
}

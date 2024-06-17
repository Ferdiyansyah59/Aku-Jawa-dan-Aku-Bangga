package pbopertemuan5;

import java.util.Scanner;

/**
 *
 * @author ferdi
 */
public class PboPertemuan5 {

    /**
     * @param args the command line arguments
     */
    static Scanner awa = new Scanner(System.in);
    static int a[];
    static String b[] = new String[5];
    static String huruf[] = {"a","b","c","d","e"};
    public static void main(String[] args) {
        a = new int[10];
        
        for(int i = 0; i< a.length;i++){
            a[i] = i+1;
        }
        System.out.println("");
        
        for (int i = 0; i<a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println("");
        b[0] = "p";
        b[1] = "q";
        b[2] = "r";
        b[3] = "s";
        b[4] = "t";
        
        for(String b1 : b) {
            System.out.println(b1);
        }
        
        System.out.println("");
        
        for(int i = 0;i< huruf.length;i++){
            System.out.println(huruf[i]);
        }
        
    }   
    
}

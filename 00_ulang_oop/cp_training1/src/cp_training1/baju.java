package cp_training1;
import java.util.Scanner;
public class baju {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        int B = awa.nextInt();
        int P = awa.nextInt();
        int L = awa.nextInt();
        
        if (B <= 10 && P <= 40 && L <= 90){
            System.out.println("S");
        }else if (B <= 14 && P <= 60 && L <= 120){
            System.out.println("M");
        }else if (B <= 18 && P <= 80 && L <= 180){
            System.out.println("L");
        }else{
            System.out.println("X");
        } 
    }
}

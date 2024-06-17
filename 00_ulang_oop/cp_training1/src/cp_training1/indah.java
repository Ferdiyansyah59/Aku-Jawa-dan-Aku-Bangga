package cp_training1;
import java.util.Scanner;
public class indah {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        int So = awa.nextInt();
        int N = awa.nextInt();
        int D = awa.nextInt();
        
        for(int i = So, j = 0; j < N; j++){
            System.out.println(So);
            So += D;
        }
        
    }
}

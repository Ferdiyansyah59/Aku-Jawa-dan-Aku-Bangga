import java.util.Scanner;

public class RhythmGame {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        int n = awa.nextInt();
        int combo = 1, total = 0;
        
        String inp = awa.next();
        char[] arr = inp.toCharArray();
        for(int i = 0; i < n; i++){
            if(arr[i] == '+'){
                total += combo;
                if (combo != 12){
                    combo += 1;
                }else { 
                    combo = combo;
                }
            }else if(arr[i] == '-'){
                combo = 1;
            }
        }
        awa.close();
        System.out.println(total);
    }
}

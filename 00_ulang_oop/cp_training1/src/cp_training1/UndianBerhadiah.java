package cp_training1;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
public class UndianBerhadiah {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        List<Integer> res = new ArrayList<>(2);
        short n = awa.nextShort();
        int x = awa.nextInt();
        
        for(short i = 0; i < n; i++){
            int kupon_inp = awa.nextInt();
            if(res.isEmpty() || Math.abs(res.get(0) - x) == Math.abs(kupon_inp - x)){
                res.add(kupon_inp);
            }else if(Math.abs(res.get(0) - x) > Math.abs(kupon_inp - x)){
                res.clear();
                res.add(kupon_inp);
            }          
        }
        Collections.sort(res);

        res.forEach((item) -> {
            System.out.printf("%05d\n", item);
        });
    }
}

package cp_training1;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Sortir {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        List<Byte> arr = new ArrayList<>(3);
        for(byte i = 0; i < 3; i++){
            byte inp = awa.nextByte();
            arr.add(inp);
        }        
        String a = awa.next();
        if(a.equals("1")){
            Collections.sort(arr);
        }else if(a.equals("0")){
            Collections.sort(arr, Collections.reverseOrder());
        }
        for(byte i = 0; i < 3; i++){
            System.out.print(arr.get(i) +" ");
        }
    }
    
}

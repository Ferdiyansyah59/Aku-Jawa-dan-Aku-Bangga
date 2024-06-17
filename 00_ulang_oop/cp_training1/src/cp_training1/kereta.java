package cp_training1;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class kereta {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        List<Short> aa = new ArrayList<>();
        short n = awa.nextByte();
        
        for(short i = 1; i <= n; i++){
            short a = awa.nextShort();
            aa.add(a);
        }      
        short size = (short) ((short) aa.size() - (short) 1);
        
        for(short i = size; i >= 0; i--){
            System.out.print(aa.get(i));   
            if(i != 0){
                System.out.print(",");
            }else{
                System.out.print("");
            }    
        }
    }
}

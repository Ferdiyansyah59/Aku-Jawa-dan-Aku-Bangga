import java.util.Scanner;
public class seventeen {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        double n, total;
        n = awa.nextDouble();
        total = n % 17;
        System.out.println(total);
//        System.out.printf("%d%n",total);
    }
}

package cp_training1;

public class main {
    public static void main(String[] args) {
        
        String nama[] = {"Atta", "Marse", "Rakun"};
        double uts[] = {60, 80, 70};
        double uas[] = {70, 70, 60};
        double tugas[] = {90, 90, 90};
       
        
        System.out.println("Nama\t\tUTS\t\tUAS\t\tTUGAS\t\tNILAI AKHIR");
        
        
        for (int i = 0; i < 3; i++){
            double na = (0.35 * (uts[i])) + (0.45 * (uas[i])) + (0.2 * (tugas[i]));
            System.out.println(nama[i]+"\t\t"+uts[i]+"\t\t"+uas[i]+"\t\t"+tugas[i]+"\t\t"+na);
        }
        
        
//        int rows = 5, k = 0;
//
//        for (int i = 1; i <= rows; ++i, k = 0) {
//          for (int space = 1; space <= rows - i; ++space) {
//            System.out.print(" ");
//          }
//
//          while (k != 2 * i - 1) {
//            System.out.print("*");
//            ++k;
//          }
//
//          System.out.println();
//        }
    }
}
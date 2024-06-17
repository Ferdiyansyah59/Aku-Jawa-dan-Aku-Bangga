package cp_training1;
import java.util.Scanner;

public class batik {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = awa.nextInt();
        System.out.print("Masukkan jumlah mata pelajaran: ");
        int jumlahMataPelajaran = awa.nextInt();

        int[][] nilaiSiswa = new int[jumlahSiswa][jumlahMataPelajaran];

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("\nMasukkan nilai untuk Siswa " + (i + 1) + ":");
            for (int j = 0; j < jumlahMataPelajaran; j++) {
                System.out.print("Masukkan nilai untuk Mata Pelajaran " + (j + 1) + ": ");
                nilaiSiswa[i][j] = awa.nextInt();
            }
        }

        System.out.println("\nNilai Siswa:");
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.print("Siswa " + (i + 1) + ": ");
            for (int j = 0; j < jumlahMataPelajaran; j++) {
                System.out.print(nilaiSiswa[i][j] + " ");
            }
            System.out.println(); 
        }
    }
}

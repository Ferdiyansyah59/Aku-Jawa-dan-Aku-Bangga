package hotel;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Hotel {

    static Scanner awa = new Scanner(System.in);
    static int lantai, kamar;
    public static void past(int kode, int kl){
        char cek;
        int jumlahL = 0;
        String kk = "";
        for(int k = 1; k <= kl; k++){
            if(kode == 0 ? k == 4 || k == 13 || k == 14 : k == 3 || k == 4 || k == 13 || k == 14){
                jumlahL++;
                kk += Integer.toString(k) + " ";
            }
        }
        if(jumlahL != 0){
            System.out.println("Apkah anda ingin jumlahnya sesuai dengan jumlah yang anda masukkan?");
            System.out.println("Jika ya maka hanya akan melewati " + (kode == 0 ? "lantai ke " : "kamar ke ") + kk + "dan penamaannya akan melebih dari yang anda masukan ");
            System.out.print("(y/t)? ");
            cek = awa.next().charAt(0);

            if(cek == 'Y' || cek == 'y'){
                if(kode == 0){
                    lantai += jumlahL;
                }else{
                    kamar += jumlahL;
                }
            }
        }  
    }
    
    public static void main(String[] args) {
        try{
            System.out.print("Masukkan Jumlah Lantai: ");
            lantai = awa.nextInt();
            past(0, lantai);
            System.out.print("Masukkan Jumlah Kamar per lantai: ");
            kamar = awa.nextInt();
            past(1, kamar);
            int lama, jumlahKamar = 0, jumlahLama=0;
      
            
            if(lantai <= 0 || kamar <= 0 ) throw new IllegalArgumentException("Tidak bisa memasukkan nilai negatif atau 0");
            
            
            for(int i = 1; i <= lantai; i++){
                if(i == 4 || i == 13 || i == 14){
                    continue;
                }else{
                    for(int j = 1; j <= kamar; j++){
                        if(j == 3 || j == 4 || j == 13 || j == 14){
                            continue;
                        }else{
                            System.out.println("-------------------------");
                            System.out.println("Lantai-" + i + " & Kamar-" +j );
                            System.out.print("Lama Huni: ");
                            lama = awa.nextInt();
                            if(lama < 0) throw new IllegalArgumentException("Tidak bisa memasukkan nilai negatif");
                            jumlahLama += lama;
                            jumlahKamar++;
                        }
                    }
                }
            }
            

            System.out.println("\nJumlah Total Kamar = " + (jumlahKamar));
            System.out.println("Total Lama Huni = " + jumlahLama);
            double tingkatHuni = (double) jumlahLama / (jumlahKamar * 30);
            System.out.printf("\nTingkat Hunian Hotel = %.2f \n", tingkatHuni );
        }catch(InputMismatchException e){
            System.err.println("Tidak bisa input selain angka  " + e);
        }catch(IllegalArgumentException e){
            System.err.println(e);
        }catch(Exception e){
            System.err.println("Terjadi error pada program " + e);
        }finally{
            System.out.println("Terima Kasih!");
        }
        
    }
    
}

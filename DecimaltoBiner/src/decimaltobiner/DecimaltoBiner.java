/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimaltobiner;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class DecimaltoBiner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner awa = new Scanner(System.in);
        DecimalBiner db = new DecimalBiner();
        
        String a = "A";
        String b = "B";
        int c = 0;
        back:
              while(c==0)   
             {
        System.out.println("\nMENU UTAMA");
        System.out.println("=============");
        System.out.println("A.Login");
        System.out.println("B.Exit");
        System.out.print("Pilih : ");
        String pilih1 = awa.next();
        if(a.equalsIgnoreCase(pilih1))
        {
            System.out.println("Login");
            System.out.print("Username : ");
            String user = awa.next();
            System.out.print("Password : ");
            String pw = awa.next();
         
            if("ferdi".equals(user) && "120919".equals(pw))
            {
                int z = 0;
                while(z==0){
                
                System.out.println("\n1.Konversi Bilangan");
                System.out.println("2.Logout");
                System.out.print("Pilih : ");
                String pilih2 = awa.next();
               
                switch(pilih2)
                {
                    case "1" :
                        System.out.println("1.Binary");
                        System.out.println("2.Oktal");
                        System.out.println("3.Hexadesimal");
                        System.out.print("pilih : ");
                        String pilih10 = awa.next();
                        switch(pilih10)
                        {
                            case "1":
                                db.KonversiBiner();
                                break;
                            case "2":
                                db.KonvensiOktal();
                                break;
                            case "3":   
                                db.KonvensiHexa();
                                break;
                            default:
                                System.out.println("Pilihan Tidak Tersedia");
                                break;
                        }
                        break;
                    case "2":
                     
                        continue back;
                    default:
                        System.out.println("Pilihan Tidak Tersedia");
                        break;
                }
                
                }
                break;
               
            }
            else
            {
                System.out.println("Username atau Password salah");
            }
            
        }
        else if(b.equalsIgnoreCase(pilih1))
        {
            System.exit(c);
        }
        else
        {
            System.out.println("Pilihan Tidak Tersedia");
        }
    }
             }
    

}

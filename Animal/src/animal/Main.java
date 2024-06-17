/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author ferdiyansyah
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner awa = new Scanner(System.in);
        Identitas idi = new Identitas();   
        Animal a = new Animal();
        Mamalia m = new Mamalia();
        Aves av = new Aves();
        Ayam ay = new Ayam();
        Merpati mer = new Merpati();
        idi.iden();
        
         String ulang = "y";
        while(ulang.equals("y"))
        {
        
        System.out.println("\n1.Mamalia");
        System.out.println("2.Aves");
        System.out.print("Pilih :  ");
        String n = awa.next();
        a.setNama(n);
        
        
        if( n != null) {        //Convert to switch
            
            switch (n) {
                case "1":{
                    System.out.println("\n1.Kucing");
                    System.out.println("2.Kelinci");
                    System.out.println("3.Paus");
                    System.out.println("4.Singa");
                    System.out.println("5.Anjing");
                    System.out.print("Nama Mamalia : ");
                    String mama = awa.next();
                    m.setJenisMamalia(mama);
                    switch(mama)
                    {
                        
                        case "1":
                            m.setBisaJalan(true);
                            System.out.println("Kucing");
                            a.setSifat("Jinak");
                            System.out.println("Sifat : " + a.getSifat());
                            System.out.println("Bisa Jalan : " + m.getBisaJalan());
                            m.setJumlahKaki(4);
                            System.out.println("Jumlah Kaki : " + m.getJumlahKaki());
                            break;
                        case "2":
                            m.setBisaJalan(true);
                            System.out.println("Kelinci");
                            a.setSifat("Jinak");
                            System.out.println("Sifat : " + a.getSifat());
                            System.out.println("Bisa Jalan : " + m.getBisaJalan());
                            m.setJumlahKaki(4);
                            System.out.println("Jumlah Kaki : " + m.getJumlahKaki());
                            break;
                        case "3":
                            System.out.println("Paus");
                            a.setSifat("jinak");
                            System.out.println("Sifat : " + a.getSifat());
                            m.setBisaJalan(false);
                            System.out.println("Bisa Jalan : " + m.getBisaJalan() );
                            System.out.println("Jumlah Kaki : - " );
                            break;
                        case "4" :
                            m.setBisaJalan(true);
                            System.out.println("Singa");
                            a.setSifat("Galak");
                            System.out.println("Sifat : " +a.getSifat());
                            System.out.println("Bisa Jalan : " + m.getBisaJalan());
                            m.setJumlahKaki(4);
                            System.out.println("Jumlah Kaki : " + m.getJumlahKaki());
                            break;
                        case "5":
                            m.setBisaJalan(true);
                            System.out.println("Anjing");
                            a.setSifat("Jinak");
                            System.out.println("Sifat : " + a.getSifat());
                            System.out.println("Bisa Jalan : " + m.getBisaJalan());
                            m.setJumlahKaki(4);
                            System.out.println("Jumlah Kaki : " + m.getJumlahKaki());
                            break;
                        default:
                            System.out.println("Tidak Terdapat di List");
                            break;
                    }           break;
                }
               
                case "2":{
                    System.out.println("\n1.Ayam");
                    System.out.println("2.Burung");
                    System.out.print("Nama Aves : " );
                    String mama = awa.next();
                    av.setJenisAves(mama);
                    
                     if(null != mama)
                    switch (mama) {
                    case "1":
                        System.out.println("\n1.Bangkok");
                        System.out.println("2.Kate");
                        System.out.println("3.Saigon");
                        System.out.println("4.Kalkun");
                        System.out.print("Jenis Ayam : ");
                        String ja = awa.next();
                        ay.setJenisAyam(ja);
                        a.setSifat("Jinak");
                        switch (ja)
                        {
                            case "1":
                                ay.setBisaDiadu(true);
                                System.out.println("Ayam Bangkok");
                                a.setUkuran(50);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Diadu : " + ay.getBisaDiadu());
                                
                                break;
                            case "2":
                                ay.setBisaDiadu(false);
                                System.out.println("Ayam Kate");
                                a.setUkuran(30);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukurang : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Diadu : " + ay.getBisaDiadu());
                                break;
                            case "3":
                                ay.setBisaDiadu(true);
                                System.out.println("Ayam Saigon");
                                a.setUkuran(40);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Diadu : " + ay.getBisaDiadu());
                                
                                break;
                            case "4" :
                                ay.setBisaDiadu(false);
                                System.out.println("Kalkun");
                                a.setUkuran(85);
                                a.setSifat("Galak");
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Diadu : " + ay.getBisaDiadu());
                                break;
                            default:
                                System.out.println("Tidak Terdapat di List");
                                break;
                        }
                        break;
                    case "2":
                        System.out.println("\n1.Unta");
                        System.out.println("2.Merpati");
                        System.out.println("3.Pinguin");
                        System.out.println("4.Kasuari");
                        System.out.println("5.Merak");
                        System.out.println("6.Beo");
                        System.out.println("7.Kakatua");
                        System.out.print("Jenis Burung : ");
                        String jb = awa.next();
                        a.setSifat("Jinak");
                        switch(jb)
                        {
                            
                            
                            case "1" :
                                mer.setBisaTerbang(false);
                                System.out.println("Burung Unta");
                                a.setSifat("Galak");
                                a.setUkuran(250);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Terbang : " + mer.getBisaTerbang() );
                                break;
                            case "2" :
                                mer.setBisaTerbang(true);
                                System.out.println("Burung Merpati");
                                a.setUkuran(30);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Terbang : " + mer.getBisaTerbang());
                                break;
                            case "3" :
                                mer.setBisaTerbang(false);
                                a.setUkuran(80);
                                System.out.println("Pinguin");
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Terbang : " + mer.getBisaTerbang());
                                break;
                            case "4" :
                                mer.setBisaTerbang(false);
                                System.out.println("Burung Kasuari");
                                a.setUkuran(150);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Terbang : " + mer.getBisaTerbang());
                                break;
                            case "5" :
                                mer.setBisaTerbang(false);
                                System.out.println("Burung Merak");
                                a.setUkuran(125);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Terbang : " + mer.getBisaTerbang());
                                break;
                            case "6" :
                                mer.setBisaTerbang(true);
                                System.out.println("Burung Beo");
                                a.setUkuran(30);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Terbang : " + mer.getBisaTerbang());
                                break;
                            case "7" :
                                mer.setBisaTerbang(true);
                                System.out.println("Burung Kakatua");
                                a.setUkuran(40);
                                System.out.println("Sifat : " + a.getSifat());
                                System.out.println("Ukuran : " + a.getUkuran() + " cm");
                                System.out.println("Bisa Terbang : " + mer.getBisaTerbang());
                                break;
                            default :
                                System.out.println("Tidak Terdapat di List");
                                break;
                                
                        }
                        break;
                }          break;
                }
                default:
                    System.out.println("Tidak Terdapat di List");
                    break;
            }
            
        }
        System.out.print("\nApakah mau mengulang?(y/t) ");
            ulang = awa.next();
    }
        
        
        
    }
    
}

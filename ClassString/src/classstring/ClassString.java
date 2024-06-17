/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classstring;

/**
 *
 * @author ferdiyansyah
 */
public class ClassString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String a = "smkn24@gmail.com";
     String b = "HARAPAN";
     String c = "Harapan";
     String d = "harapan";
     String e = "harapan";
     String f = "RPL-OKAY";
     
     //charAt: menampilkan character ke-3 atau index ke-2
        System.out.println("Menampilkan index ke(6) dari kata 'smkn24@gmail.com':"+a.charAt(2));
     //membandingakan urutan (s>H berdasarkan kode asci)
        System.out.println("membandingkan H-->s berdasarkan kode ascii(115-72):" + a.compareTo(b));
     //membandingkan urutan (H<s berdasarkan kode asci)
        System.out.println("membandingakan H-->s berdasarkan kode ascii(72-115):"+b.compareTo(a));
     //membandinkan urutan (H=h jika tidak case sensitive)
        System.out.println("membandingkan H = h,jika tidak case sensitive:"+b.compareToIgnoreCase(d));
     //true or false?
        System.out.println("\nBenar/salah'smkn24@gmail.com = HARAPAN' : " +a.equals(b));
     //true or false?
        System.out.println("Benar/salah 'Harapan = harapan':"+b.equals(c));
     //true or false?
        System.out.println("Benar/salah 'harapan=harapan':"+d.equals(e));
     //true or false
        System.out.println("Benar/salah'HARAPAN = harapan tidak case sensitive':"+b.equalsIgnoreCase(e));
     //uppercase
        System.out.println("\nUppercase smkn24@gmail.com:"+a.toUpperCase());
     //lowercase
        System.out.println("Lowercase HARAPAN:"+b.toLowerCase());
     //mengganti karakter char array
        System.out.println("\nmengganti char dari array : ");
        char buah[] = "mangga_ini_manis".toCharArray();
        f.getChars(0,3,buah,7);
        System.out.println(buah);
     //panjang karakter
        System.out.println("\nPanjang String:"+a.length());
     //mereplace karakter
        System.out.println("Mengganti Karakter:"+c.replace("a", "i"));
     //menampilkan karakter mulai substring ke
        System.out.println("Menampilkan karakte index:"+a.substring(6));
     //menampilkan karakter substring, akhir substring
        System.out.println("menampilkan karakter mulai index s.d akhir index:"+d.trim());
     //mengirim karakter yang sama
        System.out.println("menampilkan karakter yang sama :");
     //membandingkan nilai
        System.out.println("\nmembandingkan nilai:"+String.valueOf(10>10));
        System.out.println("membandingkan nilai:"+String.valueOf(10<10));
        System.out.println("membandingkan nilai:"+String.valueOf(10==10));
     //String tidak ada perubahan pada nama objek String meskipun setelah penggunaan semua method
        System.out.println("\n~~~Pada class String obyek tidak berubah(tetap) meskipun setelah penggunaan method~~~");
        System.out.println(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n"+f);
    }
    
}

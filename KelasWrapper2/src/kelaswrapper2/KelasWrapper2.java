/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelaswrapper2;

/**
 *
 * @author ferdiyansyah
 */
public class KelasWrapper2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Byte a = 11;
        Integer b =24;
        Float c = 0.125f;
        Double d = 0.66666667d;
        Character e = 'A';
        
        //Mencetak Obyek kelas wrapper
        System.out.println("Nilai Objek Byte : " +a);
        System.out.println("Nilai Objek Integer : "+b);
        System.out.println("Nilai Objek Float : " +c);
        System.out.println("Nilai Objek Double : " +d);
        System.out.println("Nilai Objek Character:"+e);
        
        //cara lain mencetak obyek kelas Wrapper
        System.out.println("\nNilai Objek Byte : " +a.byteValue());
        System.out.println("Nilai Objek Integer : "+b.intValue());
        System.out.println("Nilai Objek Float : " +c.floatValue());
        System.out.println("Nilai Objek Double : " +d.doubleValue());
        System.out.println("Nilai Objek Character:"+e.charValue());
        
        
                Integer myInt1 = Integer.parseInt("100",2);
        System.out.println("\nKonversi dari basis 2-->10: " +myInt1);
        
        Integer myInt2 = Integer.parseInt("20",8);
        System.out.println("Konversi dari basis 8-->10:"+myInt2);
        
        Integer myInt3 = Integer.parseInt("A1",16);
        System.out.println("Konversi dari basis 16-->10:"+myInt3);
    }
    
}

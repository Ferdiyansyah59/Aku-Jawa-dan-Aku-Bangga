/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelaswrapper3;

/**
 *
 * @author ferdiyansyah
 */
public class KelasWrapper3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //membuat obyek kelas Wrapper yang memiliki nilai
        
        Byte a =2;
        Integer b = 20;
        Float c = 0.125f;
        Double d = 0.6666667;
        Character e = 'A';
        
        //Konversi Kelas Wrapper ke String
        String myString1 = a.toString();
        String myString2 = a.toString();
        String myString3 = a.toString();
        String myString4 = a.toString();
        String myString5 = a.toString();
        
        //menampilkan panjang String
        System.out.println("\npanjang a : "+myString1.length());
        System.out.println("panjang b : "+myString2.length());
        System.out.println("panjang c : "+myString3.length());
        System.out.println("panjang d : "+myString4.length());
        System.out.println("panjang e : "+myString5.length());
        
        //nilai min dan max
        System.out.println("\nnilai minimum byte:"+Byte.MIN_VALUE+"Nilai Maximum Byte"+Byte.MAX_VALUE);
        System.out.println("nilai minimum byte:"+Integer.MIN_VALUE+"Nilai Maximum Byte"+Integer.MAX_VALUE);
        System.out.println("nilai minimum byte:"+Float.MIN_VALUE+"Nilai Maximum Byte"+Float.MAX_VALUE);
        System.out.println("nilai minimum byte:"+Double.MIN_VALUE+"Nilai Maximum Byte"+Double.MAX_VALUE);
        
        //Konversi kelas wrapper Integer dari basisi 10 ke basis lain
        String obj1 = new String();
        obj1=Integer.toBinaryString(17);
        System.out.println("Konversi dari Basis 10-->2:"+obj1);
        
        String obj3 = new String();
        obj3=Integer.toHexString(17);
        System.out.println("Konversi dari basis 10-->16:"+obj3);
    }
    
}

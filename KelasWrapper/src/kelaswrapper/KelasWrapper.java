/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelaswrapper;

/**
 *
 * @author ferdiyansyah
 */
public class KelasWrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //tipe data primitif
        byte a =1;
        int b = 12;
        float c = 9.8f;
        double d = 3.14d;
        char e = 'B';
        
        //membuat obyek kelas Wrapping
        Byte obj1 = new Byte(a);
        Integer obj2 = new Integer(b);
        Float obj3 = new Float(c);
        Double obj4 = new Double(d);
        Character obj5 = new Character(e);
        
        //mencetak obyek kelas Wrapper
        System.out.println("Nilai Obyek Byte : " +obj1);
        System.out.println("Nilai Obyek Integer : " +obj2);
        System.out.println("Nilai Obyek Float : " +obj3);
        System.out.println("Nilai Obyek Double : " +obj4);
        System.out.println("Nilai Obyek Character : " +obj5);
    }
    
}

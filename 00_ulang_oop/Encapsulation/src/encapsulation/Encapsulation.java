/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encapsulation;

/**
 *
 * @author ferdi
 */
public class Encapsulation {

    /**
     * @param args the command line arguments
     */
    
    private int alas, tinggi;
    private double luasSegitiga;
    
    public void setAlas(int alas){
        this.alas = alas;
    }
    
    public int getAlas(){
        return alas;
    }
    
    public void setTinggi(int tinggi){
        this.tinggi = tinggi;
    }
    
    public int getTinggi(){
        return tinggi;
    }
    
    public void setLuasSegitiga(int alas, int tinggi){
        luasSegitiga = 0.5 * (double) (alas * tinggi);
    }
    
    public double getLuasSegitiga(){
        return luasSegitiga;
    }
    public static void main(String[] args) {
        Encapsulation n = new Encapsulation();
        n.setAlas(8);
        n.setTinggi(12);
        n.setLuasSegitiga(n.getAlas(), n.getTinggi());
        System.out.println(" Luas Segitiga adalah " + n.getLuasSegitiga());
        
    }
    
}

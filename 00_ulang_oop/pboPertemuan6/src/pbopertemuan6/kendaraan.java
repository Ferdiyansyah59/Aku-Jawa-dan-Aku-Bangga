/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan6;

/**
 *
 * @author ferdi
 */
public class kendaraan {
    
//    Atribute
    private String merk, warna;
    protected String namaClass = "Kendaraan";
    
    
    protected void setMerk(String merk){
        this.merk = merk;
        merk = null; // untuk menghapus paramter dari memori
    }
    
    protected String getMerk(){
        return merk;
    }
    
    protected void setWarna(String warna){
        this.warna = warna;
        warna = null;
    }
    
    protected String getWarna(){
        return warna;
    }
    
    protected void tampil(String a){
        System.out.println(a);
        a = null;
    }
    
    public String keterangan(){
        return "Ini adalah class" + namaClass;
    }
    
    protected void hapus(){
//        HAPUS VARIABLLE PRIVATE DATI MEMORI
        warna = null;
        merk = null;
        namaClass = null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}

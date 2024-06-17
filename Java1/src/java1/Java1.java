/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1;

/**
 *
 * @author ferdiyansyah
 */
public class Java1 {

    /**
     * @param args the command line arguments
     */
    String nama,habitat;
    int umur;
    
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public void setUmur(int umur){
        this.umur = umur;
    }
    public int getUmur(){
        return umur;
    }
    public void setHabitat(String habitat)
    {
        this.habitat = habitat;
    }
    public String getHabitat()
    {
        return habitat;
    }
    public static void main(String[] args) {
        Java1 jerapah = new Java1();
        jerapah.setNama("Bambang");
        jerapah.setUmur(100);
        jerapah.setHabitat("Hutan");
        System.out.println("Nama Jerapah    : " + jerapah.getNama());
        System.out.println("Umur Jerapah    : " + jerapah.getUmur()+" Thn");
        System.out.println("Habitat Jerapah : " + jerapah.getHabitat());
        
        Java1 gajah = new Java1();
        gajah.setNama("Sumanto");
        gajah.setUmur(500);
        gajah.setHabitat("Hutan");
        System.out.println("\nNama Gajah      : " + gajah.getNama());
        System.out.println("Umur Gajah      : " + gajah.getUmur()+ " Thn");
        System.out.println("Habitat Gajah   : "+ gajah.getHabitat());
        
       
        
    }
    
}

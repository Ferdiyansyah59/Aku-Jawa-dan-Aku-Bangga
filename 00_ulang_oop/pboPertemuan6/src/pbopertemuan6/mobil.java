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
public class mobil extends kendaraan {
    private long harga;
    protected String namaClass = "Mobil";
    
    protected void setHarga(String harga){
        this.harga = Long.parseLong(harga);
        harga = null;
    }
    protected long getHarga(){
        return harga;
    }
    
    
    @Override
    public String keterangan(){
        return namaClass + " : ini adalah class " +namaClass;
    }
    
    public String keteranganKendaraan(){
//        Akses atribute dan method parent
        return  super.namaClass+ " : " + super.keterangan();
    }
    
    
    
    protected void hapus(int harga){
        harga = 0;
        super.hapus();
    }
}

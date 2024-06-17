/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbopertemuan7;

/**
 *
 * @author ferdi
 */
public class ConstructorMotor extends ConstructorKendaraan {
    private String warna;
    protected ConstructorMotor(String merk, String warna){
        super(merk); // Memanggil constructor
        this.warna = warna;
        
        
//        Hapus variable paramter dari memory
        merk = null;
        warna = null;
    }
    
    protected String getWarna(){
        return warna;
    }
    
    @Override
    protected void hapus(){
        warna = null;
        super.hapus(); // manggil merhod hapus punya parent / superclass
    }
}

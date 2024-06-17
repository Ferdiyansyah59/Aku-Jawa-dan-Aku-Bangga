/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sepedamotor;

/**
 *
 * @author ferdi
 */
public class SepedaMotor {

    /**
     * @param args the command line arguments
     */
    private String merk;
    private long harga;
    public void setMerk(String merkMotor){
        merk = merkMotor;
    }
    
    public String getMerk(){
        return merk;
    }
    
    public long harga(long hargaMotor){
        return harga =  hargaMotor;
    }
    
    
    public static void main(String[] args) {
        SepedaMotor  s = new SepedaMotor();
        s.setMerk("Honda");
        System.out.println("Motor ini bermerk: " + s.getMerk());
        System.out.println("Motor ini berharga: " + s.harga(1000007));
    }
    
    
    
}

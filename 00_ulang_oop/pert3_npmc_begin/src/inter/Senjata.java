/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

/**
 *
 * @author ferdi
 */
public class Senjata implements OpsiSenjata {
    int pelor = 0;
    String[] senjata = {"Magnum", "AK47"};
    
    Senjata(int pelor){
        this.pelor = pelor;
    }
    
    @Override
    public void tembakSenjata(){
        if (pelor != 0){
            System.out.println("dor..dor..dor..");
            this.pelor = pelor - 1;
        }else{
            System.out.println("Sisa pelor habis");
        }
    }
    
    public void reloadSenjata(){
        System.out.println("Senjata di reload!");
        this.pelor += 7;
    }
    
    public void tukarSenjata(int kodeSenjata){
        System.out.println("Senjata tuker ke : " + this.senjata[kodeSenjata]);
    }
}

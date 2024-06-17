/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipanb;

/**
 *
 * @author ferdi
 */
public class menu {
    public void bio(){
        System.out.println("FERRE");
    }
    
//    double angka(int a){
//        int aa = a + 10;
//        return aa;
//    }
    
    protected void lingkaran(int r){
        final double phi = 3.14;
        
        int luas =  (int) (phi * r * r);
        int keliling = (int) (2 * phi * r);
        
        System.out.println("Luas: "+ luas);
        System.out.println("Keliling : " + keliling);
    }
    
    protected void gg(int j){
        for (int i = 0; i <= j; i++){
            if(i % 2 == 0){
                System.out.println("Bilangan ke-"+i+" adalah Genap!");
            }else {
                System.out.println("Bilangan ke-"+i+" adalah Ganjil!");
            }
        }
    }
}

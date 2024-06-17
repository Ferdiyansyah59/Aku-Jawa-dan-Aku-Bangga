/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author ferdi
 */
public class Shapes {
    int getCorner(){
        return 0;
    }
}

class Rectangle extends Shapes{
    @Override
    int getCorner(){
//        Ini manggil method get corner yang di class shapes
//        super.getCorner();
        return 4;
    }
    
//    Atau bisa di tampung method baru
    int getParentCorner(){
        return super.getCorner();
    }
    
}

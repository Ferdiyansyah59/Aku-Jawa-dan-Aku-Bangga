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
public class ShapesApp {
    public static void main(String[] args) {
        Shapes sp = new Shapes();
        System.out.println(sp.getCorner());
        
        Rectangle rt = new Rectangle();
        System.out.println(rt.getCorner());
        System.out.println(rt.getParentCorner());
    }
}

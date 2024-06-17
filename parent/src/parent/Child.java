/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parent;

/**
 *
 * @author ferdiyansyah
 */
public class Child extends Parent{
    int x = 10;
    
    @Override
    public void info()
    {
        System.out.println("Saya subclass");
    }
}

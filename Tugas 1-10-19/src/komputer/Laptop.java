/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komputer;

/**
 *
 * @author ferdiyansyah
 */
public class Laptop extends PC implements MouseBaru , Keyboard{
    String leptop;
    
    public void setLaptop(String leptop)
    {
        this.leptop=leptop;
    }
    public String getLaptop()
    {
        return leptop;
    }
}

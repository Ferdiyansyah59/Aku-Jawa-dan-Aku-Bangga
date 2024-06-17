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
public class PC extends Komputer implements Keyboard{
   String enter;
    @Override
    
    public void tekanEnter()
    {
        System.out.println("Keyboard PC : Tekan Enter.....");
    }
    public void setEnter(String enter)
    {
       this.enter=enter; 
    }
    public String getEnter()
    {
        return enter;
    }
}

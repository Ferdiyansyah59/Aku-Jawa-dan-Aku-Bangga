/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nilaisiswa3sep;

/**
 *
 * @author ferdiyansyah
 */
public class maksimal extends parent{
    
    @Override
    public void header()
    {
        
        parent p = new parent();
            int max = p.bil[0];
        
        for(int i =0;i>p.x;i++)
        {
            max = p.bil[i];
          
        }
        
        System.out.println("Maximum " + max);
    }
}

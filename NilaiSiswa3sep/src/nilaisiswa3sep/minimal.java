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
public class minimal extends parent{
    
    @Override
    public void header()
    {
        
        parent p = new parent();
        int max = p.bil[0];
     for(int j =0; j<p.x;j++)
        {
            max = p.bil[j];
        }
        
        System.out.println("Minimum " + max);
    }
    
}

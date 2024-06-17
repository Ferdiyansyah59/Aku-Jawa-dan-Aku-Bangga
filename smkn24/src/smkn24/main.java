/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smkn24;

/**
 *
 * @author ferdiyansyah
 */
public class main {
    
    public static void main(String[] args) {
        rpl r = new rpl();
        print(r);
        
        ph p = new ph();
        print(p);
          
        
    }
    public static void print(Smkn24 uw)
    {
        System.out.println(uw.NamaKaprog());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelasstring;

/**
 *
 * @author ferdiyansyah
 */
public class KelasRuntime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //membuat obyek kelas runtime
        Runtime rt = Runtime.getRuntime();
        
        System.out.println("Total Memori : "+rt.totalMemory());
        
        System.out.println("Free Memori : "+rt.freeMemory()+"byte");
        
        //besar memori maksimu java Runtime
        System.out.println("Max memory : "+rt.maxMemory()+"byte");
        
        //gc=garbage collector
        System.gc();
        System.out.println("Free Memory after gc: " +rt.freeMemory());
        
        for(int i=0;1<10000;i++)
        {
            new KelasRuntime();
        }
        System.out.println("Free Memory after creating 10000 instance "+rt.freeMemory());
        
        
    }
    
}

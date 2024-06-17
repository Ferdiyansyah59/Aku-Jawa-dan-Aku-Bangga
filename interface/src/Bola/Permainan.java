/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bola;

/**
 *
 * @author ferdiyansyah
 */
public class Permainan implements Bola , BolaBasket {
    String bunyi;
    
    @Override
    public void lempar()
    {
        System.out.println("Bambang melempar Bola....");
    }
    @Override
    public void menggelinding()
    {
        System.out.println("Bola menggelinding ke arah Hartono");
    }
    @Override
    public void tendang()
    {
        System.out.println("Lalu bola di tendang Hartono");
    }
    @Override
    public void sundul()
    {
        System.out.println("Selanjutnya disundul Sumanto");
    }
    @Override
    public void tangkap()
    {
        System.out.println("Kiper berusaha menangkap bola namu gagal dan gooool......!");
    }
    @Override
    public void setBunyi(String bunyi)
    {
       this.bunyi = bunyi;
    }
    public String getBunyi()
    {
        return bunyi;
    }
            
}

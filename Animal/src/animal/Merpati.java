/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author ferdiyansyah
 */
public class Merpati extends Aves{
    public Merpati()
    {
    
    }
    public Merpati(String nama , double ukuran)
    {
        nama = nama;
        ukuran = ukuran;
    }
    
    @Override
    public void setBisaTerbang(boolean bisaTerbang)
    {
        this.bisaTerbang = bisaTerbang;
    }
    @Override
    public boolean getBisaTerbang()
    {
        return bisaTerbang;
    }
    
}

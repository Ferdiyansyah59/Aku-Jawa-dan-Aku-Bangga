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
public class Aves extends Animal{
    protected String jenisAves;
    protected String terbang;
    protected boolean bisaTerbang ;
    
    public Aves()
    {
    
    }
    public Aves (String nama , double ukuran)
    {
        nama = nama;
        ukuran = ukuran;
    }
    public void setBisaTerbang(boolean bisaTerbang)
    {
        this.bisaTerbang = bisaTerbang;
    }
    public boolean getBisaTerbang()
    {
        return bisaTerbang;
    }
    public void setJenisAves(String jenisAves)
    {
        this.jenisAves = jenisAves;
    }
    public String getJenisAves()
    {
        return jenisAves;
    }
    
}

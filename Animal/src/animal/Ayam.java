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
public class Ayam extends Aves {
    
    protected String jenisAyam;
    protected String adu;
    protected boolean bisaDiadu;
    
    public Ayam()
    {
        
    }
    public Ayam(String nama , double ukuran)
    {
        nama = nama;
        ukuran = ukuran;
    }
    public void setJenisAyam(String jenisAyam)
    {
        this.jenisAyam = jenisAyam;
    }
    public String getJenisAyam()
    {
        return jenisAyam;
    }
    public void setBisaDiadu(boolean bisaDiadu)
    {
        this.bisaDiadu = bisaDiadu;
    }
    public boolean getBisaDiadu()
    {
        return bisaDiadu;
    }
}

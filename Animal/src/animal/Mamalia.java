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
public class Mamalia extends Animal{
    
    protected String jalan;
    protected String jenisMamalia;
    protected boolean bisaJalan;
    protected int jumlahKaki;
    
    public  Mamalia()
    {
        
    }
    public Mamalia(String nama)
    {
        this.nama = nama;
    }
    public void setBisaJalan(boolean bisaJalan)
    {
        this.bisaJalan = bisaJalan;
    }
    public boolean getBisaJalan()
    {
        return bisaJalan;
    }
    public void setJumlahKaki(int jumlahKaki)
    {
         this.jumlahKaki = jumlahKaki;
    }
    public int getJumlahKaki()
    {
        return jumlahKaki;
    }
    public void setJenisMamalia(String jenisMamalia)
    {
        this.jenisMamalia = jenisMamalia;
    }
    public String getJenisMamalia()
    {
        return jenisMamalia;
    }
}

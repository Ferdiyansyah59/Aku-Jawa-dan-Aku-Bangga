/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingkartabung;

/**
 *
 * @author ferdiyansyah
 */
public class TabungLingkar extends LingkarTabung{
    private double tinggi;
    
    public TabungLingkar()
    {
    
    }
    public TabungLingkar(double t)
    {
        tinggi = t;
    }
    
    public void setTinggi(double t)
    {
       if(t <= 0)
       {
           tinggi = 1;
       }
       else
       {
           tinggi = t;
       }
    }
    public double getTinggi()
    {
        return tinggi;
    }
    public double luasPermtabung()
    {
        return KelLingkaran()*(tinggi+jari);
    }
    public double volTabung()
    {
        return luasLingkaran()*tinggi;
    }
}

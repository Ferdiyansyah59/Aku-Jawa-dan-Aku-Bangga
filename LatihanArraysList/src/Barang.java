/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferdiyansyah
 */
public class Barang {
    int kode;
    String nama;
    
    public Barang(int kode , String nama)
    {
        this.kode = kode;
        this.nama = nama;
    }
    public int getKode()
    {
        return kode;
    }
    public String getNama()
    {
        return nama;
    }
    
}

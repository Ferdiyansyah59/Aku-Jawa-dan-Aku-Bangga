/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferdiyansyah
 */
import java.util.ArrayList;
public class BarangMain {
    
    ArrayList<Barang> tampung = new ArrayList();
    
    public void isiData(int kode , String nama)
    {
        tampung.add(new Barang(kode,nama));
    }
    public void showData()
    {
        //method menampikan data
        System.out.println("Kode Barang" + "\tNama Barang");
        System.out.println(" ");
        
        //looping barang ke 1,2dst
        for(Barang barang : tampung)
        {
            System.out.println(barang.getKode() + "\t\t" +barang.getNama());
        }
    }
    
    public static void main(String[] args) {
        BarangMain bm = new BarangMain();
        bm.isiData(1, "Pulpen");
        bm.isiData(2, "Buku");
        bm.isiData(3, "Spidol");
                
    }
}

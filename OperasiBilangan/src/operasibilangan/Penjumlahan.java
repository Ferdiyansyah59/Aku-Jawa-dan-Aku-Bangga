/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operasibilangan;

/**
 *
 * @author ferdiyansyah
 */
import java.text.DecimalFormat;
public class Penjumlahan extends OperasiBilangan{
    
    @Override
    public void hasilOperasi()
    {
        DecimalFormat dc = new DecimalFormat("#.##");
        
        OperasiBilangan op = new OperasiBilangan();
        op.hasilOperasi();
        op.hasil = op.bil1 + op.bil2;
        System.out.println("Hail : " +Double.valueOf(dc.format(op.hasil)));
    }
    
}

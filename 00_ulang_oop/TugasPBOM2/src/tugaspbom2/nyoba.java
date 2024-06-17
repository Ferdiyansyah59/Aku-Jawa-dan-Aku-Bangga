/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspbom2;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ferdi
 */
public class nyoba {
    public static void main(String[] args) {
        int pil; char ulang = 'y'; double total = 0; String itemPembelian="";
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DecimalFormat dF = new DecimalFormat("#,###");
        do {
            String menuText = "     Selamat datang di Portal Pemesanan\n    IBNU RESTAURANT\n"
            +"\nDaftar Menu Paket Spesial"
            +"\n===================\n"
                + "Paket 1 : Nasi goreng ayam + Air Mineral (Rp 20.000)\n"
                + "Paket 2 : Nasi Gila + Air Mineral (Rp 25.000)\n"
                + "Paket 3 : Soto Ayam + Es Teh Manis (Rp 30.000)\n"
                + "Paket 4 : Soto Daging + Es Teh Manis (Rp 35.000)\n"
                + "Paket 5 : Nasi Uduk + Ayam Penyet + Aneka Minuman (Rp 40.000)\n\n"
                + "Pilihan anda";
            pil = Integer.parseInt(JOptionPane.showInputDialog(menuText));
            int hargaPil = harga(pil);

            switch (pil) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                String inputQty = JOptionPane.showInputDialog("Kamu memilih Menu Paket " + pil
                + "\nHarga Paket " + pil + " adalah " + dF.format(hargaPil)
                + "\nMasukkan jumlah yang dibeli: ");
                int qty = Integer.parseInt(inputQty);
                    int totalMenu = (qty * hargaPil);
                    total += (qty * hargaPil);
                    itemPembelian += qty + "\t Paket " + pil +" \t "+ dF.format(totalMenu) +  "\n";
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Menu tidak ada. Silakan pilih menu yang lain.");
                continue;
            }
            ulang = ' ';
            while (ulang != 't' && ulang != 'y') {
                ulang = Character.toLowerCase(JOptionPane.showInputDialog("Total : Rp " + dF.format(total)
                    + "\nIngin menambah menu ? \nY = Ya \nT =  Tidak").charAt(0));
            }
        } while (ulang != 't');
        float diskon = disc(total);
        double totalSebelumPPN = total;
        double ppn = totalSebelumPPN * 0.11;
        double totalAkhir = totalSebelumPPN + ppn - diskon;
        double uangBayar = Double.parseDouble(JOptionPane.showInputDialog("Total Pembayaran : Rp " + dF.format(totalAkhir)
                + "\nMasukkan nominal uang pembayaran: "));
        double kembalian = uangBayar - totalAkhir;
        String waktuStruk = waktu.format(formatWaktu);

        JOptionPane.showMessageDialog(null, "\t     IBNU RESTAURANT"
            + "\n\nQTY ITEM"
            + "\n--------------------------------------\n"
            + "\nBarang yang dibeli:\n" + itemPembelian
            + "\n--------------------------------------\n"
            + "\nSub Total : Rp " + dF.format(total) + "\n"
            + "\n--------------------------------------\n"
            + "\nDasar Pengenaan Pajak : Rp " + dF.format(totalSebelumPPN)
            + "\nPPn 11% : Rp "+dF.format(ppn)
            + "\nDiskon yang diterima : Rp " + dF.format(diskon)
            + "\n--------------------------------------\n"
            + "\nTotal : Rp "+dF.format(totalAkhir)
            + "\nCash : Rp "+dF.format(uangBayar)
            + "\nKembalian : Rp " + dF.format(kembalian)
            + "\n\n         " + waktuStruk
            + "\n\n\nTerima Kasih sudah Memesan");
            JOptionPane.showMessageDialog(null,"Dibuat Oleh\nMuhammad Ibnu Ardhiansyah\n10121850\n3KA01");
    }

    public static int harga(int pil) {
        int paket = 0;

        switch (pil) {
            case 1:
                paket = 20000;
                break;
            case 2:
                paket = 25000;
                break;
            case 3:
                paket = 30000;
                break;
            case 4:
                paket = 35000;
                break;
            case 5:
                paket = 40000;
                break;
            default:
                break;
        }

        return paket;
    }

    public static float disc(double total) {
        float diskon = 0; 
        String pesanDiskon = "Tidak ada diskon";

        if (total >= 100000) {
            diskon = (float) (total * 0.09);
            pesanDiskon = "Mendapat Diskon 9%";
        } else if (total >= 75000) {
            diskon = (float) (total * 0.07);
            pesanDiskon = "Mendapat Diskon 7%";
        } else if (total >= 50000) {
            diskon = (float) (total * 0.05);
            pesanDiskon = "Mendapat Diskon 5%";
        }
        JOptionPane.showMessageDialog(null, pesanDiskon) ;
        return diskon;
    }
}

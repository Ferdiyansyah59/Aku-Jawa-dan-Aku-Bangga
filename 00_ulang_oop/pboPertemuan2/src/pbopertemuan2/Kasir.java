class Produk {
    private String nama;
    private double harga;

    public Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp " + harga);
    }
}

class Kasir {
    public static void main(String[] args) {
        Produk d = new Produk("Nasi Dendeng", 15000);
        Produk e = new Produk("Es Jeruk", 5000);

   
        System.out.println("Makanan:");
        System.out.println("Nama: " + d.getNama());
        System.out.println("Harga: Rp " + d.getHarga());
        System.out.println("-------------------------");

        System.out.println("Minuman:");
        System.out.println("Nama: " + e.getNama());
        System.out.println("Harga: Rp " + e.getHarga());
        System.out.println("-------------------------");

        double totalPembelian = d.getHarga() + e.getHarga();
        System.out.println("Total Pembelian: Rp " + totalPembelian);
    }
}

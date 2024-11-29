private void getData(){
System.out.println("ID\t\tJENIS RUANG\t\tHARGA SEWA");
try {
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(); // Isi argumen
while(rs.next()){
System.out.println(rs.getInt("id_ruang")+"\t\t "+rs.getString("jenis_ruang")+"
\t\t\t"+rs.getFloat("harga_sewa"));
}
}catch(SQLException e){
System.out.println(e.getMessage());
}
}
private void insertData(){
try{
pst = con.prepareStatement(); // Isi argumen
System.out.print("Masukkan ID: ");
int id = awa.nextInt();
pst.setInt(1, id);
System.out.print("Masukkan Jenis Ruang: ");
String jenis = awa.next();
pst.setString(2, jenis);
System.out.print("Masukkan Harga Sewa: ");
float sewa = awa.nextFloat();
pst.setFloat(3, sewa);
pst.executeUpdate();
}catch(SQLException e){
System.out.println(e.getMessage());
}
}
private void deleteData(){
try{
pst = con.prepareStatement(); // Isi argumen
System.out.print("Masukkan id yang ingin di hapus: ");
int id = awa.nextInt();
pst.setInt(1, id);
pst.executeUpdate();
}catch(SQLException e){
System.out.println(e.getMessage());
}
}
/**
* @param args the command line arguments
*/
public static void main(String[] args) {
char ulang;
try{
do{
System.out.println("==========================");
System.out.println("HOTEL NI YEEEE");
System.out.println("==========================");
System.out.println("1. Tampilkan Data");
System.out.println("2. Menambahkan Data");
System.out.println("3. Menghapus Data");
System.out.print("Pilih: ");
int pilih = awa.nextInt();
if(pilih == 1){
}else if(pilih == 2){
}else if(pilih == 3){
}else{
System.out.println("Pilihan tidak tersedia!");
ulang = 'y';
}
System.out.print("Ingin memilih (y/t)");
ulang = awa.next().charAt(0);
}while(ulang != 't');
}catch(Exception e){
System.out.println(e.getMessage());
}finally{
System.out.println("TERIMA KASIH");
}
}

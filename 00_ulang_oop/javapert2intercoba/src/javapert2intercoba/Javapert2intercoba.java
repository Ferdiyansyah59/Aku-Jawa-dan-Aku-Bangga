/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapert2intercoba;

import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author ferdi
 */
public class Javapert2intercoba {
   final String queryGet = "SELECT * FROM coba";
   final String queryInsert = "INSERT INTO coba (id_ruang, jenis_ruang, harga_sewa) VALUES (?, ?, ?)";
   final String queryDelete = "DELETE FROM coba WHERE id_ruang = ?";
   
   Connection con;
   static Scanner awa = new Scanner(System.in);
   PreparedStatement pst;
            
    Javapert2intercoba() {
        con = koneksi.connection();
    }
    
    private void getData(){
        System.out.println("ID\t\tJENIS RUANG\t\tHARGA SEWA");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryGet);
            while(rs.next()){
                System.out.println(rs.getInt("id_ruang")+"\t\t   "+rs.getString("jenis_ruang")+"\t\t\t"+rs.getFloat("harga_sewa"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void insertData(){
        try{
            pst = con.prepareStatement(queryInsert);
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
            pst = con.prepareStatement(queryDelete);
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
        Javapert2intercoba i = new Javapert2intercoba();        
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
                    i.getData();
                }else if(pilih == 2){
                    i.insertData();
                }else if(pilih == 3){
                    i.deleteData();
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
    
}

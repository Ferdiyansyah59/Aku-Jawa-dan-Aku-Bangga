/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao.karyawanDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.karyawan;

/**
 *
 * @author ferdiyansyah
 */
@WebServlet(name = "karyawanCtr", urlPatterns = {"/karyawanCtr"})
public class karyawanCtr extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("application/json"); //respon berupa data json
        String page = request.getParameter("page"); //mengambil nilai parameter page
        PrintWriter out = response.getWriter(); //menampilkan data
        karyawanDao kardo = new karyawanDao(); //membuat objek karyawan dao
        Gson gson = new Gson();
        if(page == null){ //viewer mengirim nilai parameter page adalah null
            List<karyawan>listKaryawan = kardo.getAllKaryawan();
            String jsonKaryawan = gson.toJson(listKaryawan); //convert to json
            out.println(jsonKaryawan); //tampilkan data 
        }else if("tambah".equals(page)){
            String nik = request.getParameter("nik");
            String nama = request.getParameter("nama");
            if(kardo.getRecordByNik(nik).getNik() != null){
                response.setContentType("text/html;charset=UTF-8");
                out.print("Nik : "+nik+" - "+nama+" sudah terpakai, OK... ");
            }else{
                karyawan kar = new karyawan();
                kar.setNik(request.getParameter("nik"));
                kar.setNama(request.getParameter("nama"));
                kar.setGender(request.getParameter("gender"));
                kar.setTmpLahir(request.getParameter("tmpLahir"));
                kar.setTglLahir(request.getParameter("tglLahir"));
                kar.setAlamat(request.getParameter("alamat"));
                kar.setTelepon(request.getParameter("telepon"));
                kardo.simpanData(kar, page);
                response.setContentType("text/html;charset=UTF-8");
                out.print("Data berhasil disimpan, OK...");
            }
        }else if("tampil".equals(page)){
            String jSonKaryawan = gson.toJson(kardo.getRecordByNik(request.getParameter("nik")));
            response.setContentType("application/json");
            out.println(jSonKaryawan);
        }else if("edit".equals(page)){
            karyawan kar = new karyawan();
            kar.setNik(request.getParameter("nik"));
            kar.setNama(request.getParameter("nama"));
            kar.setGender(request.getParameter("gender"));
            kar.setTmpLahir(request.getParameter("tmpLahir"));
            kar.setTglLahir(request.getParameter("tglLahir"));
            kar.setAlamat(request.getParameter("alamat"));
            kar.setTelepon(request.getParameter("telepon"));
            kardo.simpanData(kar, page);
            response.setContentType("text/html;charset=UTF-8");
            out.print("Data Berhasil di Edit");
        }else if("hapus".equals(page)){
            kardo.hapusData(request.getParameter("nik"));
            response.setContentType("text/html;charset=UTF-8");
            out.print("Data Berhasil di Hapus");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

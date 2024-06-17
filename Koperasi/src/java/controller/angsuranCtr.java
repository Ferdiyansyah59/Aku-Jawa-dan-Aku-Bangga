/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dao.angsuranDao;
import dao.pinjamanDao;
import model.pinjaman;
import model.angsuran;
import java.util.List;
/**
 *
 * @author ferdiyansyah
 */
@WebServlet(name = "angsuranCtr", urlPatterns = {"/angsuranCtr"})
public class angsuranCtr extends HttpServlet {

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
        response.setContentType("application/json");
        String page = request.getParameter("page");
        PrintWriter out = response.getWriter();
        angsuranDao angdo = new angsuranDao();
        pinjamanDao pinjam = new pinjamanDao();
        Gson gson = new Gson();
        if(page == null){
            List<angsuran>listAngsuran = angdo.getAllAngsuran();
            String jsonAngsuran = gson.toJson(listAngsuran);
            out.println(jsonAngsuran);
        }else if("tambah".equals(page)){
            String nopinjaman = request.getParameter("nopinjaman");
            if(angdo.getRecordByNo(nopinjaman).getNopinjaman() != null){
               response.setContentType("text/html;charset=UTF-8");
               out.print("No Pinjaman: "+nopinjaman+" sudah terpakai"); 
            }else{
                angsuran awa = new angsuran();
                awa.setNopinjaman(request.getParameter("nopinjaman"));
                awa.setAngsuranke(request.getParameter("angsurke"));
                awa.setTglangsur(request.getParameter("tglangsur"));
                awa.setBesarangsur(request.getParameter("besarangsur"));
                awa.setSisapinjaman(request.getParameter("sisapinjaman"));
                awa.setNokaryawan(request.getParameter("nokaryawan"));
                angdo.simpanData(awa);
                response.setContentType("text/html;charset=UTF-8");
                out.print("Data berhasil disimpan, OK...");
            }
        }else if("tampil".equals(page)){
            String jsonPinjaman = gson.toJson(angdo.getRecordByNo(request.getParameter("nopinjaman")));
            response.setContentType("apllication/json");
            out.println(jsonPinjaman);   
        }else if("edit".equals(page)){
            angsuran awa = new angsuran();
            awa.setNopinjaman(request.getParameter("nopinjaman"));
            awa.setAngsuranke(request.getParameter("angsurke"));
            awa.setTglangsur(request.getParameter("tglangsur"));
            awa.setBesarangsur(request.getParameter("besarangsur"));
            awa.setSisapinjaman(request.getParameter("sisapinjaman"));
            angdo.editData(awa);
            response.setContentType("text/html;charset=UTF-8");
            out.print("Data berhasil diedit, OK...");
        }else if("hapus".equals(page)){
            angdo.hapusData(request.getParameter("nopinjaman"));
            response.setContentType("text/html;charset=UTF-8");
            out.print("Data Berhasil di Hapus");
        }else if("pinjaman".equals(page)){
            List<pinjaman>listPinjaman = angdo.getPinjaman();
            String jsonAngsuran = gson.toJson(listPinjaman);
            out.println(jsonAngsuran);
        }else if("rupiah".equals(page)){
            List<angsuran>listAngsuran = angdo.getRupiah(request.getParameter("nopinjaman"));
            String jsonAngsuran = gson.toJson(listAngsuran);
            out.println(jsonAngsuran);
            
//            String nopinjaman = request.getParameter("nopinjaman");
//            List<angsuran>listAngsuran = angdo.getRupiah(nopinjaman);
//            String jsonRupiah = gson.toJson(listAngsuran);
//            response.setContentType("apllication/json");
//            out.println(jsonRupiah);
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

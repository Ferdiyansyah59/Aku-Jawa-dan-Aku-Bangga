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
import dao.pinjamanDao;
import model.pinjaman;
import java.util.List;
/**
 *
 * @author ferdiyansyah
 */
@WebServlet(name = "pinjamanCtr", urlPatterns = {"/pinjamanCtr"})
public class pinjamanCtr extends HttpServlet {

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
        pinjamanDao pinjam = new pinjamanDao();
        Gson gson = new Gson();
        if(page == null){
            List<pinjaman>listPinjaman = pinjam.getAllPinjaman();
            String jsonPinjaman = gson.toJson(listPinjaman);
            out.println(jsonPinjaman);
        }else if("tambah".equals(page)){
            String nopinjaman = request.getParameter("nopinjaman");
            if(pinjam.getRecordbyNo(nopinjaman).getNopinjaman() != null){
                response.setContentType("text/html;charset=UTF-8");
                out.print("No Pinjaman: "+nopinjaman+" sudah terpakai");
            }else{
                pinjaman pin = new pinjaman();
                pin.setNopinjaman(request.getParameter("nopinjaman"));
                pin.setNoanggota(request.getParameter("noanggota"));
                pin.setTglpinjaman(request.getParameter("tglpinjaman"));
                pin.setPokokpinjaman(request.getParameter("pokokpinjaman"));
                pin.setBungapinjaman(request.getParameter("bungapinjaman"));
                pin.setLamapinjaman(request.getParameter("lamapinjaman"));
                pin.setAngsuranpokok(request.getParameter("angsuranpokok"));
                pin.setAngsuranbunga(request.getParameter("angsurabunga"));
                pin.setAccpetugas(request.getParameter("accpetugas"));
                pinjam.simpanData(pin);
                response.setContentType("text/html;charset=UTF-8");
                out.print("Data berhasil disimpan, OK...");
            }
        }else if("tampil".equals(page)){
            String jsonPinjaman = gson.toJson(pinjam.getRecordbyNo(request.getParameter("nopinjaman")));
            response.setContentType("apllication/json");
            out.println(jsonPinjaman);
        }else if("edit".equals(page)){
            pinjaman pin = new pinjaman();
            pin.setNoanggota(request.getParameter("noanggota"));
            pin.setTglpinjaman(request.getParameter("tglpinjaman"));
            pin.setPokokpinjaman(request.getParameter("pokokpinjaman"));
            pin.setBungapinjaman(request.getParameter("bungapinjaman"));
            pin.setLamapinjaman(request.getParameter("lamapinjaman"));
            pin.setAngsuranpokok(request.getParameter("angsuranpokok"));
            pin.setAngsuranbunga(request.getParameter("angsurabunga"));
            pin.setAccpetugas(request.getParameter("accpetugas"));
            pin.setNopinjaman(request.getParameter("nopinjaman"));
            pinjam.editData(pin);
            response.setContentType("text/html;charset=UTF-8");
            out.print("Data berhasil diedit, OK...");
        }else if("hapus".equals(page)){
            pinjam.hapusData(request.getParameter("nopinjaman"));
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

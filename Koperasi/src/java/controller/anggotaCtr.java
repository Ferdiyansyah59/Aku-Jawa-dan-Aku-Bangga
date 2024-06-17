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
import dao.anggotaDao;
import model.anggota;
import java.util.List;

/**
 *
 * @author ferdiyansyah
 */
@WebServlet(name = "anggotaCtr", urlPatterns = {"/anggotaCtr"})
public class anggotaCtr extends HttpServlet {

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
        anggotaDao agdo = new anggotaDao();
        Gson gson = new Gson();
        if(page == null){
            List<anggota>listAnggota = agdo.getAllAnggota();
            String jsonAnggota = gson.toJson(listAnggota);
            out.println(jsonAnggota);
        }else if("tambah".equals(page)){
            String noanggota = request.getParameter("noanggota");
            String nama = request.getParameter("nama");
            if(agdo.getRecordByNo(noanggota).getNoanggota() != null){
                response.setContentType("text/html;charset=UTF-8");
                out.print("No Anggota : "+noanggota+" - "+nama+" sudah terpakai, OK... ");
            }else{
                anggota agg = new anggota();
                agg.setNoanggota(request.getParameter("noanggota"));
                agg.setNama(request.getParameter("nama"));
                agg.setGender(request.getParameter("gender"));
                agg.setTmplahir(request.getParameter("tmplahir"));
                agg.setTgllahir(request.getParameter("tgllahir"));
                agg.setAlamat(request.getParameter("alamat"));
                agg.setTelepon(request.getParameter("telepon"));
                agdo.simpanData(agg);
                response.setContentType("text/html;charset=UTF-8");
                out.print("Data berhasil disimpan, OK...");
            }
        }else if("tampil".equals(page)){
            String jSonAnggota = gson.toJson(agdo.getRecordByNo(request.getParameter("noanggota")));
            response.setContentType("application/json");
            out.println(jSonAnggota);
        }else if("edit".equals(page)){
            anggota agg = new anggota();
            agg.setNoanggota(request.getParameter("noanggota"));
            agg.setNama(request.getParameter("nama"));
            agg.setGender(request.getParameter("gender"));
            agg.setTmplahir(request.getParameter("tmplahir"));
            agg.setTgllahir(request.getParameter("tgllahir"));
            agg.setAlamat(request.getParameter("alamat"));
            agg.setTelepon(request.getParameter("telepon"));
            agdo.editData(agg);
            response.setContentType("text/html;charset=UTF-8");
            out.print("Data Berhasil di Edit");
        }else if("hapus".equals(page)){
            agdo.hapusData(request.getParameter("noanggota"));
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

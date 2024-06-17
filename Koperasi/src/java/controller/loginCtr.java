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
import dao.loginDao;
import model.login;
import java.util.List;
/**
 *
 * @author ferdiyansyah
 */
@WebServlet(name = "loginCtr", urlPatterns = {"/loginCtr"})
public class loginCtr extends HttpServlet {

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
        loginDao logdo = new loginDao();
        Gson gson = new Gson();
        if("login".equals(page)){
            String jsonLogin = gson.toJson(logdo.getLogin(request.getParameter("userid")));
            response.setContentType("apllication/json");
            out.println(jsonLogin);
        }else if(page == null){
            List<login>listLogin = logdo.getDataUser();
            String jsonLogin = gson.toJson(listLogin);
            out.println(jsonLogin);
        }else if("tambah".equals(page)){
            String userid = request.getParameter("userid");
            if(logdo.getLogin(userid).getUserid() != null){
                response.setContentType("text/html;charset=UTF-8");
                out.print("User ID: "+userid+" sudah terpakai");
            }else{
                login log = new login();
                log.setUserid(request.getParameter("userid"));
                log.setPassword(request.getParameter("password"));
                log.setNik(request.getParameter("nik"));
                log.setLevel(request.getParameter("level"));
                log.setAktif(request.getParameter("aktif"));
                logdo.simpanData(log);
                response.setContentType("text/html;charset=UTF-8");
                out.print("Data berhasil disimpan, OK...");
            }
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

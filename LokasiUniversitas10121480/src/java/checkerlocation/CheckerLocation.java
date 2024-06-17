/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerlocation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ferdi
 */
@WebServlet(name = "CheckerLocation", urlPatterns = {"/checkerlocation"})
public class CheckerLocation extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckerLocation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckerLocation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String keywordUniversitas, lokasi;
        keywordUniversitas = request.getParameter("universitas");
        
        lokasi = getLocation(keywordUniversitas);
        request.setAttribute("universitas", keywordUniversitas);
        request.setAttribute("lokasi", lokasi);
        
        request.getServletContext().getRequestDispatcher("/hasil.jsp").forward(request, response);
    }
    
    protected String getLocation(String universitas){
        String lokasi;
        
        if(universitas.equals("gunadarma")){
            lokasi = "depok";
        }else if(universitas.equals("ui") || universitas.equals("universitas indonesia")){
            lokasi = "depok";
        }else if(universitas.equals("itb") || universitas.equals("institut teknologi bandung")){
            lokasi = "bandung";
        }else if(universitas.equals("undip") || universitas.equals("universitas diponegoro")){
            lokasi = "depok";
        }else if(universitas.equals("ugm") || universitas.equals("universitas gajah mada")){
            lokasi = "jogja";
        }else{
            lokasi = "tidak diketahui";
        }
        return lokasi;
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

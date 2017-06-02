/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficar;

import dao.CatalogDAO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.CatalogVO;


public class NuevoCatalogServlet extends HttpServlet {
    
    private CatalogDAO catalog;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, URISyntaxException {
        response.setContentType("text/html;charset=UTF-8");
            /* TODO output your page here. You may use following sample code. */
            this.catalog = new CatalogDAO();
            int sID = 0;
            int pID = 0;
            int cost = 0;
            
            try {
                sID = Integer.parseInt(request.getParameter("sID"));
                pID = Integer.parseInt(request.getParameter("pID"));
                cost = Integer.parseInt(request.getParameter("cost"));
                
            } catch (Exception e) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            CatalogVO cvo = new CatalogVO();
            cvo.setsID(sID);
            cvo.setpID(pID);
            cvo.setCost(cost);

            boolean inserta = this.catalog.insertar(cvo);

            if (inserta) {
                request.setAttribute("mensaje", "error");
            } else {
                request.setAttribute("mensaje", "ok");
            }
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NuevoCatalogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NuevoCatalogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

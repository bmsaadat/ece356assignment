/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ece356;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Sabashan Ragavan
 */
public class LoginServlet extends HttpServlet {

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
        String url;
        try {
            url = query3helper(request, response);
        }
        catch (Exception e) {
            url = "/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

        protected String query3helper(HttpServletRequest request, HttpServletResponse response)
            throws java.sql.SQLException, ClassNotFoundException {
            String username = request.getParameter("user_name"); 
            String password = request.getParameter("password"); 
            String salt = UserDBAO.getSalt(username); 
            String url = "/index.jsp"; 
            if(salt != null)
            {
                UserData ret = UserDBAO.queryUser(username, password, salt);
                if(ret != null)
                {
                    request.setAttribute("userData", ret);
                    HttpSession session = request.getSession();
                    session.setAttribute("userData", ret);
                    UserData u = (UserData)session.getAttribute("userData");  
                    
                    if(ret.userType.equals("doctor"))
                    {
                        url = "/DoctorProfileServlet?hideInformation=0"; 
                    }
                    else if(ret.userType.equals("patient"))
                    {
                        url = "/patientLoggedInView.jsp"; 
                    }
                }
                else
                {
                    url = "/index.jsp";
                }
            }
            else
            {
                url = "/index.jsp";
            } 
            return url;    
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

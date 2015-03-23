/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ece356;
import java.util.*;

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
 * @author Sabashan
 */
public class DoctorSearchServlet extends HttpServlet {

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
        if (!UserDBAO.isLoggedIn(request)) return;

        response.setContentType("text/html;charset=UTF-8");
        String url; 
        try {
            query3helper(request, response);
            url = "/doctorSearchResultsView.jsp";
        }
        catch (Exception e) {
            url = "/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response); 
    }
    
     protected void query3helper(HttpServletRequest request, HttpServletResponse response)
            throws java.sql.SQLException, ClassNotFoundException {
        HttpSession session = request.getSession(false);
        UserData user = (UserData)session.getAttribute("userData"); 
        HashMap<String, String> doctorParam = new HashMap<String, String>(); 
        
        if(request.getParameter("firstname") != null && request.getParameter("firstname") != "")
            doctorParam.put("first_name", request.getParameter("firstname"));
        
        if(request.getParameter("lastname") != null && request.getParameter("lastname") != "")
            doctorParam.put("last_name", request.getParameter("lastname")); 
        
        if(request.getParameter("gender") != null && request.getParameter("gender") != "") 
            doctorParam.put("gender", request.getParameter("gender"));
        
        if(request.getParameter("streetNumber") != null && request.getParameter("streetNumber") != "")
            doctorParam.put("street_num", request.getParameter("streetNumber"));
        
        if(request.getParameter("streetName") != null && request.getParameter("streetName") != "")
                doctorParam.put("street_name", request.getParameter("streetName"));
        
        if(request.getParameter("unitNumber") != null && request.getParameter("unitNumber") != "")
            doctorParam.put("street_unit_number", request.getParameter("unitNumber"));
        
        if(request.getParameter("city") != null && request.getParameter("city") != "")    
            doctorParam.put("city", request.getParameter("city"));
        
        if(request.getParameter("state") != null && request.getParameter("state") != "") 
            doctorParam.put("state", request.getParameter("state"));
        
        if(request.getParameter("postalCode") != null && request.getParameter("postalCode") != "")
            doctorParam.put("postal_code", request.getParameter("postalCode"));
        
        if(request.getParameter("specialization") != null && request.getParameter("specialization") != "")
            doctorParam.put("spectypeName", request.getParameter("specialization"));   
        
        if(request.getParameter("yearsLicensed") != null && request.getParameter("yearsLicensed") != "")      
            doctorParam.put("yearsLicensed", request.getParameter("yearsLicensed"));
        
        if(request.getParameter("avgStars") != null && request.getParameter("avgStars") != "")        
            doctorParam.put("averageRating", request.getParameter("avgStars"));
        
        if(request.getParameter("reviewByFriends") != null && request.getParameter("reviewByFriends") != "")
            doctorParam.put("reviewByFriends", request.getParameter("reviewByFriends"));   
        
        if(request.getParameter("reviewKeyword") != null && request.getParameter("reviewKeyword") != "")
            doctorParam.put("comment", request.getParameter("reviewKeyword"));
        ArrayList<DoctorData> ret = UserDBAO.queryDoctor(doctorParam, user.userName.toString());        
        request.setAttribute("doctorList", ret);
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

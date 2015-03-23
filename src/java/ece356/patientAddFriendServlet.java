/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ece356;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author behrozsaadat
 */
@WebServlet(name = "patientAddFriendServlet", urlPatterns = {"/patientAddFriendServlet"})
public class patientAddFriendServlet extends HttpServlet {

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
        // Hardcoded friends
        HttpSession session = request.getSession();
        String friendA = ((UserData)session.getAttribute("userData")).getUserName();
        String friendB = request.getParameter("user");        
        String message;
        try {
            FriendShipStatus friendStatus = UserDBAO.addFriend(friendA, friendB);
            switch (friendStatus) {
                case ALREADY_FRIENDS: 
                    message = "You are already friends with " + friendB; 
                    break;
                case WAITING_FOR_ACCEPT: 
                    message = "You've already sent a request to " + friendB;
                    break;
                case REQUEST_SENT: 
                    message = "Request sent to " + friendB;
                    break;
                case FRIENDSHIP_ESTABLISHED: 
                    message = "You are now friends with " + friendB;
                    break;
                default: 
                    message = "Something went wrong!";
                    break;
            }
        } catch (Exception e) {
            message = "Something went wrong! Try again." + e;
        }
        response.setContentType("text/plain");  
        response.setCharacterEncoding("UTF-8"); 
        response.getWriter().write(message); 
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

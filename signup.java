/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grocery;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp pavailion
 */
public class signup extends HttpServlet {

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
            out.println("<title>Servlet signup</title>");
            out.println("</head>");
            out.println("<body>");

            String uname = request.getParameter("username");
            String email = request.getParameter("email");
            String pass = request.getParameter("password1");
            String cpass = request.getParameter("password2");

            if (pass.equals(cpass)) {
                try {
                    //connaction

                    //1st
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //2nd
                    String url1 = "jdbc:mysql://localhost:3306/grocery";
                    String cuser = "Jash";
                    String cpassword = "@Smani5636";

                    Connection con = DriverManager.getConnection(url1, cuser, cpassword);

                    //3rd
                    String q = "insert into signup(uname,email,password,cpassword) values(?,?,?,?)";

                    PreparedStatement pstmt = con.prepareStatement(q);

                    pstmt.setString(1, uname);
                    pstmt.setString(2, email);
                    pstmt.setString(3, pass);
                    pstmt.setString(4, cpass);

                    pstmt.executeUpdate();

                    out.println("<h1>sign Up Successfuly</h1>");

                    pstmt.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                out.println("<h1>Password is not matched!!</h1>");
            }

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

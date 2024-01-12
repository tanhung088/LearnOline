
package com.mycompany.luyenthi3.Servlet;

import com.mycompany.luyenthi3.DAO.EmployeeDAO;
import com.mycompany.luyenthi3.DAO.phoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "ResetServlet", urlPatterns = {"/reset"})
public class ResetServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int result = 0;
            String id = request.getParameter("id");
            Connection connect = phoneDAO.connectDB();
            PreparedStatement preparedStatement = connect.prepareStatement("UPDATE employee SET password='fpt@aptech' WHERE id=?");
            preparedStatement.setString(1, id);
            result = preparedStatement.executeUpdate();
            if (result != 0) {
                response.sendRedirect("/luyenthi3/");
            }else{
                request.getRequestDispatcher("views/employee/error.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int result = 0;
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            Connection connect = phoneDAO.connectDB();
            PreparedStatement preparedStatement = connect.prepareStatement("UPDATE employee SET password=? WHERE id=?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, id);
            result = preparedStatement.executeUpdate();
            if (result != 0) {
                response.sendRedirect("/luyenthi3/");
            }else{
                request.getRequestDispatcher("views/employee/error.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

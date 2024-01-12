package com.mycompany.luyenthi1.Servlet;

import com.mycompany.luyenthi1.DAO.EmpDAO;
import com.mycompany.luyenthi1.Model.EmpModel;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "EmpServlet", urlPatterns = {"/Emps"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
  maxFileSize = 1024 * 1024 * 5, 
  maxRequestSize = 1024 * 1024 * 5 * 5)
public class EmpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmpServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = "";
            if (request.getParameterMap().containsKey("action")) {
                action = request.getParameter("action");
            }
            switch (action) { // If action param
                case "create":
                    request.getRequestDispatcher("views/employee/create.jsp").forward(request, response);
                    break;
                case "delete":
                    //softDeleteUser(request, response);
                    break;
                default:
                    request.setAttribute("emps", EmpDAO.getAllUsers());
                    request.getRequestDispatcher("views/employee/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = "";
            if (request.getParameterMap().containsKey("action")) {
                action = request.getParameter("action");
            }
            switch (action) { // If action param
                case "create":
                    ServletContext servletContext = getServletContext();
                    EmpDAO.addEmp(request, response ,servletContext);
                    break;
                case "delete":
                    //softDeleteUser(request, response);
                    break;
                default:
                    request.setAttribute("emps", EmpDAO.getAllUsers());
                    request.getRequestDispatcher("views/employee/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

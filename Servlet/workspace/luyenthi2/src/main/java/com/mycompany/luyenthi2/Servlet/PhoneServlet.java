package com.mycompany.luyenthi2.Servlet;

import com.mycompany.luyenthi2.DAO.PhoneDAO;
import com.mycompany.luyenthi2.DAO.UploadDAO;
import com.mycompany.luyenthi2.Model.PhoneModel;
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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tanhu
 */
@WebServlet(name = "PhoneServlet", urlPatterns = {"/phones"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class PhoneServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PhoneServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhoneServlet at " + request.getContextPath() + "</h1>");
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
                    request.getRequestDispatcher("views/phone/create.jsp").forward(request, response);
                    break;
                case "delete":
                    //softDeleteUser(request, response);
                    break;
                default:
                    request.setAttribute("phones", PhoneDAO.getAll());
                    request.getRequestDispatcher("views/phone/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhoneServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                    PhoneModel phone = new PhoneModel();
                    phone.setName(request.getParameter("name"));
                    String priceParam = request.getParameter("price");
                    if (priceParam != null && !priceParam.isEmpty()) {
                        try {
                            double price = Double.parseDouble(priceParam);
                            phone.setPrice(price);
                        } catch (NumberFormatException e) {
                            phone.getErrors().put("price", "Price must be a valid numeric value.");
                        }
                    } else {
                        phone.getErrors().put("price", "Price is required.");
                    }
                    Part filePart = request.getPart("file");
                    if (filePart != null && filePart.getSize() > 0) {
                        UploadDAO ud = new UploadDAO();
                        String imagePath = ud.uploadFile(request, response, servletContext);
                        phone.setImage(imagePath);
                    } else {
                        phone.getErrors().put("image", "Image is required.");
                    }
                    phone.validation();
                    HashMap<String, String> errors = phone.getErrors();
                    if (errors.isEmpty()) {
                        int rs = PhoneDAO.create(request, response, servletContext);
                        if (rs != 0) {
                            response.sendRedirect("/luyenthi2/phones");
                        }
                    } else {
                        request.setAttribute("errors", errors);
                        // Render view if errors
                        request.getRequestDispatcher("views/phone/create.jsp").forward(request, response);
                    }
                    break;
                case "delete":
                    //softDeleteUser(request, response);
                    break;
                default:
                    request.setAttribute("phones", PhoneDAO.getAll());
                    request.getRequestDispatcher("views/phone/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhoneServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PhoneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

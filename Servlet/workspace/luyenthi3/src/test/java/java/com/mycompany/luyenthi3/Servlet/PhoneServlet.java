/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.luyenthi3.Servlet;

import com.mycompany.luyenthi3.DAO.UploadFileDAO;
import com.mycompany.luyenthi3.DAO.phoneDAO;
import com.mycompany.luyenthi3.Model.PhoneModel;
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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    String id = request.getParameter("id");
                    int result = phoneDAO.delete(id);
                    if(result != 0){
                        response.sendRedirect("/luyenthi3/phones");
                    }
                    break;
                case "edit":
                    String idEdit = request.getParameter("id");
                    request.setAttribute("data", phoneDAO.getById(idEdit));
                    request.getRequestDispatcher("views/phone/edit.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("datas", phoneDAO.getAll());
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
                    PhoneModel model = new PhoneModel();
                    model.setId(request.getParameter("id"));
                    model.setName(request.getParameter("name"));
                    String priceParam = request.getParameter("price");
                    if (priceParam != null && !priceParam.isEmpty()) {
                        try {
                            double price = Double.parseDouble(priceParam);
                            model.setPrice(price);
                        } catch (NumberFormatException e) {
                            model.getErrors().put("price", "Price must be a valid numeric value.");
                        }
                    } else {
                        model.getErrors().put("price", "Price is required.");
                    }
                    Part filePart = request.getPart("file");
                    if (filePart != null && filePart.getSize() > 0) {
                        UploadFileDAO ud = new UploadFileDAO();
                        String imagePath = ud.uploadFile(request, response, servletContext);
                        model.setImage(imagePath);
                    } else {
                        model.getErrors().put("image", "Image is required.");
                    }
                    model.validation();
                    HashMap<String, String> errors = model.getErrors();
                    boolean checkID = phoneDAO.isIdExists(request.getParameter("id"));
                    if(checkID != false){
                        model.getErrors().put("id", "ID must be not dupicate.");
                        request.setAttribute("errors", errors);
                        // Render view if errors
                        request.getRequestDispatcher("views/phone/create.jsp").forward(request, response);
                    }
                    if (errors.isEmpty()) {
                        int rs = phoneDAO.create(model);
                        if (rs != 0) {
                            //response.sendRedirect("/luyenthi3/phones");
                            request.getRequestDispatcher("views/phone/success.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("errors", errors);
                        // Render view if errors
                        request.getRequestDispatcher("views/phone/create.jsp").forward(request, response);
                    }
                    break;
                case "edit":
                    ServletContext servletContextEdit = getServletContext();
                    PhoneModel modelEdit = new PhoneModel();
                    modelEdit.setId(request.getParameter("id"));
                    modelEdit.setName(request.getParameter("name"));
                    String priceParamEdit = request.getParameter("price");
                    if (priceParamEdit != null && !priceParamEdit.isEmpty()) {
                        try {
                            double price = Double.parseDouble(priceParamEdit);
                            modelEdit.setPrice(price);
                        } catch (NumberFormatException e) {
                            modelEdit.getErrors().put("price", "Price must be a valid numeric value.");
                        }
                    } else {
                        modelEdit.getErrors().put("price", "Price is required.");
                    }
                    Part filePartEdit = request.getPart("file");
                    if (filePartEdit != null && filePartEdit.getSize() > 0) {
                        UploadFileDAO ud = new UploadFileDAO();
                        String imagePath = ud.uploadFile(request, response, servletContextEdit);
                        modelEdit.setImage(imagePath);
                    } else {
                        modelEdit.getErrors().put("image", "Image is required.");
                    }
                    modelEdit.validation();
                    HashMap<String, String> errorsEdit = modelEdit.getErrors();
                    if (errorsEdit.isEmpty()) {
                        int rs = phoneDAO.update(modelEdit);
                        if (rs != 0) {
                            response.sendRedirect("/luyenthi3/phones");
                        }
                    } else {
                        request.setAttribute("errors", errorsEdit);
                        request.getRequestDispatcher("views/phone/edit.jsp").forward(request, response);
                    }
                    break;
                default:
                    request.setAttribute("datas", phoneDAO.getAll());
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

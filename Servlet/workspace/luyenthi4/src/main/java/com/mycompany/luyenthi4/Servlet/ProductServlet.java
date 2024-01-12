package com.mycompany.luyenthi4.Servlet;

import com.mycompany.luyenthi4.DAO.SDAO;
import com.mycompany.luyenthi4.DAO.UploadFileDAO;
import com.mycompany.luyenthi4.Model.ProductModel;
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
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tanhu
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath() + "</h1>");
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
                    request.getRequestDispatcher("views/product/create.jsp").forward(request, response);
                    break;
                case "delete":
                    int id = Integer.parseInt(request.getParameter("id"));
                    int result = SDAO.delete(id);
                    if (result != 0) {
                        response.sendRedirect("/luyenthi4/products");
                    }
                    break;
                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("data", SDAO.getById(idEdit));
                    request.getRequestDispatcher("views/product/edit.jsp").forward(request, response);
                    break;
                default:
                    request.setAttribute("datas", SDAO.getAll());
                    request.getRequestDispatcher("views/product/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                    ProductModel model = new ProductModel();
                    model.setName(request.getParameter("product_name"));
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
                    if (errors.isEmpty()) {
                        int rs = SDAO.create(model);
                        if (rs != 0) {
                            //response.sendRedirect("/luyenthi3/phones");
                            request.getRequestDispatcher("views/product/success.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("errors", errors);
                        request.getRequestDispatcher("views/product/create.jsp").forward(request, response);
                    }
                    break;
                case "edit":
                    ServletContext servletContextEdit = getServletContext();
                    ProductModel modelEdit = new ProductModel();
                    modelEdit.setId(Integer.parseInt(request.getParameter("id")));
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
                        int rsEdit = SDAO.update(modelEdit);
                        if (rsEdit != 0) {
                            response.sendRedirect("/luyenthi4/products");
                        }
                    } else {
                        request.setAttribute("errors", errorsEdit);
                        request.getRequestDispatcher("views/product/edit.jsp").forward(request, response);
                    }
                    break;
                default:
                    request.setAttribute("datas", SDAO.getAll());
                    request.getRequestDispatcher("views/product/index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

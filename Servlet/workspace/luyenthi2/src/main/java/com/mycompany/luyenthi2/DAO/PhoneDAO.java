package com.mycompany.luyenthi2.DAO;

import com.mycompany.luyenthi2.Model.PhoneModel;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneDAO {

    public static Connection connectDB() {
        // connection object
        Connection connection = null;
        try {
            // returns the class object
            Class.forName("org.postgresql.Driver");
            // it creates a connection to the database using
            // the url
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/luyenthi2",
                    "postgres", "123");
        } catch (Exception message) {
            System.out.println(message);
        }
        return connection;
    }

    public static int create(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws SQLException {
        try {
            UploadDAO ud = new UploadDAO();
            String filePathName = ud.uploadFile(request, response, servletContext);
            if (filePathName != null) {
                int result = 0;
                Connection connect = PhoneDAO.connectDB();
                PreparedStatement preparedStatement = connect.prepareStatement(
                        "insert into phone(name,price,image) values (?,?,?)");
                preparedStatement.setString(1, request.getParameter("name"));
                preparedStatement.setDouble(2,Double.parseDouble(request.getParameter("price")));
                preparedStatement.setString(3, filePathName);
                result = preparedStatement.executeUpdate();
                connect.close();
                return result;
            }
        } catch (Exception ex) {
            Logger.getLogger(PhoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int update(int id, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws SQLException {
        try {
            UploadDAO ud = new UploadDAO();
            String filePathName = ud.uploadFile(request, response, servletContext);
            if (filePathName != null) {
                int result = 0;

                Connection connect = PhoneDAO.connectDB();
                PreparedStatement preparedStatement = connect.prepareStatement(
                        "UPDATE phone SET name=?, price=?, image=? WHERE id=?");
                preparedStatement.setString(1, request.getParameter("name"));
                preparedStatement.setString(2, request.getParameter("price"));
                preparedStatement.setString(3, filePathName);
                preparedStatement.setInt(4, id);
                result = preparedStatement.executeUpdate();
                connect.close();
                return result;
            }

        } catch (Exception ex) {
            Logger.getLogger(PhoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static List<PhoneModel> getAll()
            throws SQLException {
        List<PhoneModel> list = new ArrayList<PhoneModel>();

        Connection connect = PhoneDAO.connectDB();

        PreparedStatement preparedStatement = connect.prepareStatement(
                "select * from phone");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            PhoneModel phone = new PhoneModel();
            phone.setId(resultSet.getInt(1));
            phone.setName(resultSet.getString(2));
            phone.setPrice(resultSet.getDouble(3));
            phone.setImage(resultSet.getString(4));
            // store the values into the list
            list.add(phone);
        }

        connect.close();
        return list;
    }
}

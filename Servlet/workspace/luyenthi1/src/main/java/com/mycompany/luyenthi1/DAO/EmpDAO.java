package com.mycompany.luyenthi1.DAO;

import com.mycompany.luyenthi1.Model.EmpModel;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpDAO {

    public static Connection connectDB() {
        // connection object
        Connection connection = null;
        try {
            // returns the class object
            Class.forName("org.postgresql.Driver");
            // it creates a connection to the database using
            // the url
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/luyenthi1",
                    "postgres", "123");
        } catch (Exception message) {
            System.out.println(message);
        }
        return connection;
    }

    public static int addEmp(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws SQLException {
        try {
            EmpDAO ed = new EmpDAO();
            String filePathName = ed.uploadFIle(request, response, servletContext);
            if (filePathName != null) {
                int result = 0;
                Connection connect = EmpDAO.connectDB();
                PreparedStatement preparedStatement = connect.prepareStatement(
                        "insert into employee(name,email,password,image) values (?,?,?,?)");
                preparedStatement.setString(1, request.getParameter("name"));
                preparedStatement.setString(2, request.getParameter("email"));
                preparedStatement.setString(3, request.getParameter("password"));
                preparedStatement.setString(4, filePathName);
                result = preparedStatement.executeUpdate();
                connect.close();
                return result;
            }
        } catch (Exception ex) {
            Logger.getLogger(EmpDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int updateUser(EmpModel emp)
            throws SQLException {
        int result = 0;

        Connection connect = EmpDAO.connectDB();
        PreparedStatement preparedStatement = connect.prepareStatement(
                "UPDATE employee SET name=?, email=?, image=? WHERE id=?");
        preparedStatement.setString(1, emp.getName());
        preparedStatement.setString(2, emp.getEmail());
        preparedStatement.setString(3, emp.getImage());
        preparedStatement.setInt(4, emp.getId());

        result = preparedStatement.executeUpdate();

        connect.close();
        return result;
    }

    public static int deleteUser(int id) throws SQLException {
        int result = 0;

        // create connection at the call of this method
        Connection connect = EmpDAO.connectDB();

        // SQL statement is precompiled and stored in a
        // PreparedStatement object
        PreparedStatement preparedStatement = connect.prepareStatement(
                "delete from USERS where id =?");
        preparedStatement.setInt(1, id);

        result = preparedStatement.executeUpdate();

        // close the database connection
        connect.close();
        return result;
    }

    public static EmpModel getEmpById(int id) throws SQLException {
        // create a user object
        EmpModel emp = new EmpModel();

        // create connection at the call of the method
        Connection connect = EmpDAO.connectDB();

        // SQL statement is precompiled and stored in a
        // PreparedStatement object
        PreparedStatement preparedStatement = connect.prepareStatement(
                "select * from employee where id=?");

        preparedStatement.setInt(1, id);

        ResultSet resultSet
                = preparedStatement.executeQuery();

        if (resultSet.next()) {
            emp.setId(resultSet.getInt(1));
            emp.setName(resultSet.getString(2));
            emp.setEmail(resultSet.getString(3));
            emp.setPassword(resultSet.getString(4));
            emp.setImage(resultSet.getString(5));
        }

        // close the database connection
        connect.close();
        return emp;
    }

    public static List<EmpModel> getAllUsers()
            throws SQLException {
        List<EmpModel> list = new ArrayList<EmpModel>();

        Connection connect = EmpDAO.connectDB();

        PreparedStatement preparedStatement = connect.prepareStatement(
                "select * from employee");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            EmpModel emp = new EmpModel();
            emp.setId(resultSet.getInt(1));
            emp.setName(resultSet.getString(2));
            emp.setEmail(resultSet.getString(3));
            emp.setPassword(resultSet.getString(4));
            emp.setImage(resultSet.getString(5));
            // store the values into the list
            list.add(emp);
        }

        connect.close();
        return list;
    }

    public String uploadFIle(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws Exception {
        String path = servletContext.getRealPath("");
        File uploadsPath = new File(path + "/uploads");
        if (!uploadsPath.exists()) {
            //create upload folder if not exist.
            uploadsPath.mkdir();
        }
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        fileName = fileName.substring(3);
        for (Part part : request.getParts()) {
            part.write(path + "/uploads" + File.separator + fileName);
        }
        return "/uploads/" + fileName;
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace(
                        "\"", "");
            }
        }
        return null;
    }
}

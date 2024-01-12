
package com.mycompany.luyenthi3.DAO;
import com.mycompany.luyenthi3.Model.EmployeeModel;
import com.mycompany.luyenthi3.Model.ProductModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static Connection connectDB() {
        // connection object
        Connection connection = null;
        try {
            // returns the class object
            Class.forName("org.postgresql.Driver");
            // it creates a connection to the database using
            // the url
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/luyenthi3",
                    "postgres", "123");
        } catch (Exception message) {
            System.out.println(message);
        }
        return connection;
    }
    
    public static List<EmployeeModel> getAll()
            throws SQLException {
        // creating an empty arraylist of type User.
        List<EmployeeModel> list = new ArrayList<EmployeeModel>();

        // create connection at the call of the method
        Connection connect = ProductDAO.connectDB();
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "select * from employee where role='user'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            EmployeeModel model = new EmployeeModel();
            model.setId(resultSet.getString(1));
            model.setName(resultSet.getString(2));
            model.setPassword(resultSet.getString(3));
            model.setSalary(resultSet.getDouble(4));
            model.setRole(resultSet.getString(5));
            list.add(model);
        }
        connect.close();
        return list;
    }
    
}

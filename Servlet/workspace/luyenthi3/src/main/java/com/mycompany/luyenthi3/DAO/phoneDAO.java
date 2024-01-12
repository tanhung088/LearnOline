package com.mycompany.luyenthi3.DAO;

import com.mycompany.luyenthi3.Model.PhoneModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class phoneDAO {

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

    public static int create(PhoneModel model) throws SQLException {
        int result = 0;
        Connection connect = phoneDAO.connectDB();
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "insert into phone(id,name,price,image) values (?,?,?,?)");
        preparedStatement.setString(1, model.getId());
        preparedStatement.setString(2, model.getName());
        preparedStatement.setDouble(3, model.getPrice());
        preparedStatement.setString(4, model.getImage());
        result = preparedStatement.executeUpdate();
        connect.close();
        return result;
    }

    public static int update(PhoneModel model)
            throws SQLException {
        int result = 0;
        Connection connect = phoneDAO.connectDB();

        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "UPDATE phone SET name=?, price=?, image=? WHERE id=?");
        preparedStatement.setString(1, model.getName());
        preparedStatement.setDouble(2, model.getPrice());
        preparedStatement.setString(3, model.getImage());
        preparedStatement.setString(4, model.getId());

        result = preparedStatement.executeUpdate();
        connect.close();
        return result;
    }

    public static int delete(String id) throws SQLException {
        int result = 0;

        // create connection at the call of this method
        Connection connect = phoneDAO.connectDB();

        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "delete from phone where id =?");
        preparedStatement.setString(1, id);
        result = preparedStatement.executeUpdate();
        connect.close();
        return result;
    }

    public static PhoneModel getById(String id) throws SQLException {
        // create a user object
        PhoneModel model = new PhoneModel();
        Connection connect = phoneDAO.connectDB();
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "select * from phone where id=?");

        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            model.setId(resultSet.getString(1));
            model.setName(resultSet.getString(2));
            model.setPrice(resultSet.getDouble(3));
            model.setImage(resultSet.getString(4));
        }
        connect.close();
        return model;
    }

    public static List<PhoneModel> getAll()
            throws SQLException {
        // creating an empty arraylist of type User.
        List<PhoneModel> list = new ArrayList<PhoneModel>();

        // create connection at the call of the method
        Connection connect = phoneDAO.connectDB();
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "select * from phone");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            PhoneModel model = new PhoneModel();
            model.setId(resultSet.getString(1));
            model.setName(resultSet.getString(2));
            model.setPrice(resultSet.getDouble(3));
            model.setImage(resultSet.getString(4));
            list.add(model);
        }
        connect.close();
        return list;
    }

    public static boolean isIdExists(String id) throws SQLException {
        Connection connect = phoneDAO.connectDB();
        PreparedStatement preparedStatement = connect.prepareStatement(
                "SELECT COUNT(*) FROM phone WHERE id = ?"
        );
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }

        return false;
    }

}

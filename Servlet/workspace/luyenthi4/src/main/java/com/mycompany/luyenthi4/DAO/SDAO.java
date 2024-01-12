
package com.mycompany.luyenthi4.DAO;
import com.mycompany.luyenthi4.Model.ProductModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SDAO {
    public static Connection connectDB() {
        // connection object
        Connection connection = null;
        try {
            // returns the class object
            Class.forName("org.postgresql.Driver");
            // it creates a connection to the database using
            // the url
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/luyenthi4",
                    "postgres", "123");
        } catch (Exception message) {
            System.out.println(message);
        }
        return connection;
    }

    public static int create(ProductModel model) throws SQLException {
        int result = 0;
        Connection connect = SDAO.connectDB();
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "insert into product(name,price,image) values (?,?,?)");

        preparedStatement.setString(1, model.getName());
        preparedStatement.setDouble(2, model.getPrice());
        preparedStatement.setString(3, model.getImage());
        result = preparedStatement.executeUpdate();
        connect.close();
        return result;
    }

    public static int update(ProductModel model)
            throws SQLException {
        int result = 0;
        Connection connect = SDAO.connectDB();

        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "UPDATE product SET name=?, price=?, image=? WHERE id=?");
        preparedStatement.setString(1, model.getName());
        preparedStatement.setDouble(2, model.getPrice());
        preparedStatement.setString(3, model.getImage());
        preparedStatement.setInt(4, model.getId());

        result = preparedStatement.executeUpdate();
        connect.close();
        return result;
    }

    public static int delete(int id) throws SQLException {
        int result = 0;

        // create connection at the call of this method
        Connection connect = SDAO.connectDB();

        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "delete from product where id =?");
        preparedStatement.setInt(1, id);
        result = preparedStatement.executeUpdate();
        connect.close();
        return result;
    }

    public static ProductModel getById(int id) throws SQLException {
        // create a user object
        ProductModel model = new ProductModel();
        Connection connect = SDAO.connectDB();
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "select * from product where id=?");

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            model.setId(resultSet.getInt(1));
            model.setName(resultSet.getString(2));
            model.setPrice(resultSet.getDouble(3));
            model.setImage(resultSet.getString(4));
        }
        connect.close();
        return model;
    }

    public static List<ProductModel> getAll()
            throws SQLException {
        // creating an empty arraylist of type User.
        List<ProductModel> list = new ArrayList<ProductModel>();

        // create connection at the call of the method
        Connection connect = SDAO.connectDB();
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                        "select * from product");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ProductModel model = new ProductModel();
            model.setId(resultSet.getInt(1));
            model.setName(resultSet.getString(2));
            model.setPrice(resultSet.getDouble(3));
            model.setImage(resultSet.getString(4));
            list.add(model);
        }
        connect.close();
        return list;
    }

    public static boolean isIdExists(String id) throws SQLException {
        Connection connect = SDAO.connectDB();
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

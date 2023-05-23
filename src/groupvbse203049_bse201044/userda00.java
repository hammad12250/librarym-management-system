
package groupvbse203049_bse201044;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hammad
 */import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class userda00 implements Userrdoa {
private Connection connection;

    public userda00() {

        try {
            String url = "jdbc:mysql://localhost:3233/library";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public List<User> getalluser() {
        List<User> users = new ArrayList<>();

        try {
            String query = "SELECT * FROM User";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                User user = new User(id, username,password);
                users.add(user);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return users;
}
public void adduser(User user) {
        try {
            String query = "INSERT INTO User (id,username,  password) VALUES (2, manager2, 11AA)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getuid());
            preparedStatement.setString(2, user.getusername());
            preparedStatement.setString(3, user.getpassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}




package groupvbse203049_bse201044;
 import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Bookdaoimpl implements bookdoa {
   

private Connection connection;

    public Bookdaoimpl() {
        try {
            String url = "jdbc:mysql://localhost:3233/library";
            String username = "root";
            String password = "";
           
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public List<book> ViewBooks() {
        List<book> books = new ArrayList<>();

        try {
            String query = "SELECT * FROM books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String price = resultSet.getString("price");

                book book = new book(id, title, genre, price);
                books.add(book);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
 public void addBook(book book) {
        try {
            String query = "INSERT INTO books (id,title,  genre,price,issued) VALUES (2, data science, data,2000RS,false)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getgenre());
            preparedStatement.setString(4, book.getprice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public List<book> getIssuedBooks() {
        List<book> issuedBooks = new ArrayList<>();

        try {
            String query = "SELECT * FROM books WHERE issued = true";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String price = resultSet.getString("price");

                book book = new book(id, title, genre, price);
                issuedBooks.add(book);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issuedBooks;
    }
   public void issuebook(int bookId) {
        try {
            String query = "UPDATE books SET issued = true WHERE id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnbook(int bookId) {
        try {
            String query = "UPDATE books SET issued = false WHERE id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


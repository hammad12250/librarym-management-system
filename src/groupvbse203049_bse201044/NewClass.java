
package groupvbse203049_bse201044;

/**
 *
 * @author Hammad
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class NewClass extends JFrame {
private JTextField usernameField;
private JPasswordField passwordField;
public NewClass() {
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Login");
        setSize(270, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 80, 25);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 80, 25);
        usernameField = new JTextField();
        usernameField.setBounds(50, 50, 120, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(50, 100, 120, 25);
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(110, 140, 80, 25);
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("manager") && password.equals("123")) {
                JOptionPane.showMessageDialog(panel, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid username or password.");
            }
        });
        loginButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(username, password)) {
                    openAdminFunctionPage();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); 
        panel.add(loginButton);
        add(panel);
        panel.setLayout(null);
    }
    private boolean authenticate(String username, String password) {
      return username.equals("manager") && password.equals("123");
    }
    private void openAdminFunctionPage() {
        AdminFunctionPageGUI adminGUI = new AdminFunctionPageGUI();
        adminGUI.setVisible(true);
        dispose();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            NewClass loginGUI = new NewClass();
                loginGUI.setVisible(true);
            }
        });
        
    }
}
class AdminFunctionPageGUI extends JFrame {
private JList<String> bookList;
private DefaultListModel<String> listModel;
public bookdoa bookDAO;
public Userrdoa userDAO;
    public AdminFunctionPageGUI() {
         bookDAO = new Bookdaoimpl(); 
        userDAO = new userda00();
        setTitle("Admin Function Page");
        JLabel tf = new JLabel("Admin functions ");
        tf.setBounds(110, 50, 100, 30);
        
        setSize(600, 500);
        JButton bt = new JButton("View book");
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewBooks();
            }
        });
        bt.setBounds(110, 140, 100, 30);
        bt.setBackground(Color.GRAY);
        JButton bt1 = new JButton("view user");
         bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getallusers();
            }
        });
        bt1.setBounds(220, 140, 100, 30);
        bt1.setBackground(Color.GRAY);
        JButton bt2 = new JButton("view issue book");
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getIssuedBooks();
            }
        });
        bt2.setBounds(330, 140, 100, 30);
        bt2.setBackground(Color.GRAY);
         JButton bt3 = new JButton("issue book");
           bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookIdString = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter the book ID:", "Issue Book", JOptionPane.PLAIN_MESSAGE);
        if (bookIdString != null) {
            try {
                int bookId = Integer.parseInt(bookIdString);
                issuebook(bookId);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(AdminFunctionPageGUI.this, "Invalid book ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});
        bt3.setBounds(440, 140, 100, 30);
        bt3.setBackground(Color.GRAY);
        JButton bt4 = new JButton("add user"); 
        bt4.setBounds(110, 200, 100, 30);
        bt4.setBackground(Color.GRAY);
         bt4.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String id1 = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter user id:", "Add User", JOptionPane.PLAIN_MESSAGE);
        String name = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter user name :", "Add User", JOptionPane.PLAIN_MESSAGE);
        String password = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter user password:", "Add User", JOptionPane.PLAIN_MESSAGE);
int id=Integer.parseInt(id1);
            User user = new User(id, name, password);
            adduser(user);
        
    }
});
        JButton bt5 = new JButton("add book");
           bt5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String id1 = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter book id:", "Add Book", JOptionPane.PLAIN_MESSAGE);
        String title = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter book title:", "Add Book", JOptionPane.PLAIN_MESSAGE);
        String genre = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter book genre:", "Add Book", JOptionPane.PLAIN_MESSAGE);
        String price = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter book price:", "Add Book", JOptionPane.PLAIN_MESSAGE);
        int id=Integer.parseInt(id1);
            Book book = new Book(id,title, genre, price);
            addBook(book);
        
    }
});
        bt5.setBounds(220, 200, 100, 30);
        bt5.setBackground(Color.GRAY);
        JButton bt6 = new JButton("return book");
       bt6.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String bookIdString = JOptionPane.showInputDialog(AdminFunctionPageGUI.this, "Enter the book ID:", "Return Book", JOptionPane.PLAIN_MESSAGE);
        if (bookIdString != null) {
            try {
                int bookId = Integer.parseInt(bookIdString);
                returnbook(bookId);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(AdminFunctionPageGUI.this, "Invalid book ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});
        bt6.setBounds(330, 200, 100, 30);
        bt6.setBackground(Color.GRAY);
        
        JButton bt7 = new JButton("create database");
          bt7.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        createdatabase();
    }
});
        bt7.setBounds(440, 200, 100, 30);
        bt7.setBackground(Color.GRAY);
        setLayout(null);
        add(tf);
        add(bt);
        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
private void viewBooks() {
        List<book> books = bookDAO.ViewBooks();

        StringBuilder sb = new StringBuilder();
        for (book book : books) {
            sb.append("ID is: ").append(book.getId()).append(", ")
              .append("Title is: ").append(book.getTitle()).append(", ")
              .append("Genre is: ").append(book.getgenre()).append(", ")
              .append("Price is: ").append(book.getprice()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "View Books", JOptionPane.PLAIN_MESSAGE);
    }

    private void getallusers() {
       List<User> users = userDAO.getalluser();

    if (!users.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append("ID: ").append(user.getuid()).append(", ")
              .append("Name: ").append(user.getusername()).append(", ")
              .append("Password: ").append(user.getpassword()).append("\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "View Users", JOptionPane.PLAIN_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "No users found.", "View Users", JOptionPane.INFORMATION_MESSAGE);
    }
}

    private void getIssuedBooks() {
        List<book> issuedBooks = bookDAO.getIssuedBooks();

        StringBuilder sb = new StringBuilder();
        for (book book : issuedBooks) {
            sb.append("ID: ").append(book.getId()).append(", ")
              .append("Title: ").append(book.getTitle()).append(", ")
              .append("Genre: ").append(book.getgenre()).append(", ")
              .append("Price: ").append(book.getprice()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "View Issued Books", JOptionPane.PLAIN_MESSAGE);
    }
private void issuebook(int bookId) {
       bookDAO.issuebook(bookId);
    JOptionPane.showMessageDialog(this, "Book issued successfully.", "Issue Book", JOptionPane.INFORMATION_MESSAGE);
}

    private void adduser(User user) {
        userDAO.adduser(user);
    JOptionPane.showMessageDialog(this, "User added successfully.", "Add User", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addBook(book book) {
        bookDAO.addBook(book);
    JOptionPane.showMessageDialog(this, "Book added successfully.", "Add Book", JOptionPane.INFORMATION_MESSAGE);
    }

    private void returnbook(int bookId) {
        bookDAO.returnbook(bookId);
    JOptionPane.showMessageDialog(this, "Book returned successfully.", "Return Book", JOptionPane.INFORMATION_MESSAGE);
    }

    private void createdatabase() {
         bookDAO=new Bookdaoimpl();

    JOptionPane.showMessageDialog(this, "Database created/ successfully.", "Create Database", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        AdminFunctionPageGUI adminGUI = new AdminFunctionPageGUI();
        adminGUI.setVisible(true);
    }
}



package groupvbse203049_bse201044;
import java.util.ArrayList;
import java.util.List;
public interface bookdoa {
    

List<book> ViewBooks();
    void returnbook(int bookId);
    void addBook(book book);
    void issuebook(int bookId);
 List<book> getIssuedBooks();
}



package groupvbse203049_bse201044;

public class book {

private int id;
    private String title;
    private String genre;
     private String price;
     public book(int id, String title, String genre,String price) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
    }
  public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getgenre() {
        return genre;
    }
    public String getprice() {
        return price;
    }
}   


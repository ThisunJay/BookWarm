package Model;

public class WishList {
    private int Id;
    private String Title;
    private String Author;
    private double price;


    public WishList(String Title) {
        this.Title = Title;
    }

    public WishList(int id, String title, String author, double price) {
        Id = id;
        Title = title;
        Author = author;
        this.price = price;
    }

    public WishList() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

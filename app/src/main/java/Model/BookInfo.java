package Model;

public class BookInfo {

    private int ID;
    private String title, author, price, pages, review;

    public BookInfo(){}

    public BookInfo(int ID, String title, String author, String price, String pages, String review) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.review = review;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

package Model;

public class RBooks {

    private int ID;
    private String Name;
    private String Author;
    private String From;
    private String Till;
    private String genre;

    public RBooks(int ID, String name, String author, String from, String till, String genre) {
        this.ID = ID;
        Name = name;
        Author = author;
        From = from;
        Till = till;
        this.genre = genre;
    }

    public RBooks() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTill() {
        return Till;
    }

    public void setTill(String till) {
        Till = till;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

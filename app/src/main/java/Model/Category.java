package Model;

public class Category {
    private String Uname;
    private int ID;


    public Category(String uname , int id) {
        ID = id;
        Uname = uname;
    }
    public Category(){

    }

    public String getUname() {

        return Uname;
    }

    public void setUname(String uname) {

        Uname = uname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

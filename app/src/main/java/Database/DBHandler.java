package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import Model.BookInfo;
import Model.Category;
import Model.RBooks;
import Model.Users;
import Model.WishList;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "bookworm.db";

    public DBHandler(Context context){
        super(context, DB_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //Thisun's bookinfo table creation

        String create_table_bookinfo = "CREATE TABLE " + BookWormMaster.Book.TABLE_NAME + " (" +
                BookWormMaster.Book._ID + " INTEGER PRIMARY KEY, " +
                BookWormMaster.Book.COLUMN_NAME_TITLE + " TEXT, " +
                BookWormMaster.Book.COLUMN_NAME_AUTHOR + " TEXT, " +
                //price
                BookWormMaster.Book.COLUMN_NAME_PRICE + " TEXT, " +
                //pages
                BookWormMaster.Book.COLUMN_NAME_PAGES + " TEXT, " +
                //review
                BookWormMaster.Book.COLUMN_NAME_REVIEW + " TEXT);";

        db.execSQL(create_table_bookinfo);
        // End of Thisun's block

        //osanda's create table method

        String create_table_category = "CREATE TABLE " + BookWormMaster.Category.TABLE_NAME_CAT + " ("+
                BookWormMaster.Category._ID + " INTEGER PRIMARY KEY, " +
                BookWormMaster.Category.COLUMN_NAME_CATNAME + " TEXT);";

        db.execSQL(create_table_category);
        //end osanda's methods

        //=================AAdi===================================

        String create_table_Read = "CREATE TABLE " + BookWormMaster.ReadBook.TABLE_RBOOK + " ("+
                BookWormMaster.ReadBook._ID + " INTEGER PRIMARY KEY, " +
                BookWormMaster.ReadBook.COLUMN_RNAME + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RAUTHOR + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RFROM + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RTILL + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RGENRE + " TEXT);";

        db.execSQL(create_table_Read);
        Log.i( "DB" , create_table_Read );

        //======================kavi============================================

        String create_table_wishList = "CREATE TABLE " + BookWormMaster.AddWishList.TABLE_WLIST + " ("+
                BookWormMaster.AddWishList._ID + " INTEGER PRIMARY KEY, " +
                BookWormMaster.AddWishList.COLUMN_Title + " TEXT, " +
                BookWormMaster.AddWishList.COLUMN_Author + " TEXT, " +
                BookWormMaster.AddWishList.COLUMN_Price + " DOUBLE  );";

        db.execSQL(create_table_wishList);
        //Log.i( "DB" , create_table_wishList );

    }
//................................END OF CREATING TABLES..................................
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXiSTS " + BookWormMaster.ReadBook.TABLE_RBOOK);
       // onCreate(db);
    }

    //Thisun's add book method to add book information to the table
    public boolean addBook(String title, String author, String price, String pages, String review){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BookWormMaster.Book.COLUMN_NAME_TITLE, title);
        contentValues.put(BookWormMaster.Book.COLUMN_NAME_AUTHOR, author);
        contentValues.put(BookWormMaster.Book.COLUMN_NAME_PRICE, price);
        contentValues.put(BookWormMaster.Book.COLUMN_NAME_PAGES, pages);
        contentValues.put(BookWormMaster.Book.COLUMN_NAME_REVIEW, review);

        long result = db.insert(BookWormMaster.Book.TABLE_NAME, null, contentValues);

        if(result > 0){
            return true;
        }else{
            return false;
        }

    }
    //end of thisun's method

    //==================================OSANDA's display catogory method | Do not edit this=============================

    public ArrayList<Users> readAllInfor() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {BookWormMaster.Category._ID,BookWormMaster.Category.COLUMN_NAME_CATNAME};

        String sortOrder = BookWormMaster.Category.COLUMN_NAME_CATNAME;

        Cursor values = db.query(BookWormMaster.Category.TABLE_NAME_CAT,projection,null,null,null,null,sortOrder);

        ArrayList<Users> users = new ArrayList<Users>();

        while (values.moveToNext()){
            String userName = values.getString(values.getColumnIndexOrThrow(BookWormMaster.Category.COLUMN_NAME_CATNAME));
            users.add( new Users(userName) );

        }
        return users;
    }

    public boolean deleteuser(String username){
        SQLiteDatabase db = getReadableDatabase();
        String Selection = BookWormMaster.Category.COLUMN_NAME_CATNAME + " LIKE ?";
        String[] SelectionArgs = { username };

        long result  = db.delete(BookWormMaster.Category.TABLE_NAME_CAT , Selection , SelectionArgs );
        if(result > 0){
            return true;
        }else{
            return false;
        }
    }

    public void deleteRead(int id){
        SQLiteDatabase db = getReadableDatabase();

        String Selection = BookWormMaster.ReadBook._ID + " = ?";
        String[] SelectionArgs = { String.valueOf(id) };

        db.delete(BookWormMaster.ReadBook.TABLE_RBOOK , Selection ,SelectionArgs );
        Log.i( "DB", "Delete : " + id );
    }

    public boolean editRead(String id, String name, String author ,String from, String till, String genre){

        Log.i("ID: ", id);
        Log.i("ID: ", name);
        Log.i("ID: ", author);
        SQLiteDatabase db = getReadableDatabase();
//
        ContentValues contentValues = new ContentValues();
//
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RNAME,name);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RAUTHOR,author);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RFROM,from);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RTILL,till);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RGENRE,genre);
//
        String Selection = BookWormMaster.ReadBook._ID + " = ? ";
        String SelectionArgs[] = { id };
//
        int re = db.update(BookWormMaster.ReadBook.TABLE_RBOOK , contentValues ,Selection ,SelectionArgs);
//
        if(re > 0){
            return true;
        }else {
            return false;
        }
        //return true;
    }
//...................Thisun's delete Book Method......................
    public void deleteBook(int id){

        SQLiteDatabase db = getReadableDatabase();

        String Selection = BookWormMaster.Book._ID + " = ?";
        String[] SelectionArgs = { String.valueOf(id) };

        db.delete(BookWormMaster.Book.TABLE_NAME, Selection, SelectionArgs);
        Log.i("DB", "Delete : " + id);
    }
//.......................End of Thisun's delete Book Method................................

    public boolean BUpdate(String id , String review){
        Log.i( "Book Review: " , review);

        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BookWormMaster.Book.COLUMN_NAME_REVIEW, review);

        String selection = BookWormMaster.Book._ID + " = ?";

        String[] SelectionArgs = { id };
        Log.i( "Book ID: " , id);

        int result = db.update(BookWormMaster.Book.TABLE_NAME, contentValues, selection, SelectionArgs);

        if(result > 0){
            return true;
        }else{
            return false;
        }

    }


    public boolean userUpdate(String username ){
        SQLiteDatabase db  = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BookWormMaster.Category.COLUMN_NAME_CATNAME , username );

        String Selection = BookWormMaster.Category.COLUMN_NAME_CATNAME + " Like ? ";
        Log.i("DB" , Selection  );
        String[] SelectionArgs = { username };

        long result  =db.update(BookWormMaster.Category.TABLE_NAME_CAT ,contentValues , Selection , SelectionArgs);

        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }
//======================kavi=============================================================================

    public void deleteWish(int id){
        SQLiteDatabase db = getReadableDatabase();

        String Selection = BookWormMaster.AddWishList._ID + " = ?";
        String[] SelectionArgs = { String.valueOf(id)};

        db.delete(BookWormMaster.AddWishList.TABLE_WLIST , Selection ,SelectionArgs );
        Log.i("DB", "REMOVED" +id);
    }


//==================================Kavi Update=======================================

    public boolean WishUpdate(String title,String author,double price){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BookWormMaster.AddWishList.COLUMN_Title , title);
        contentValues.put(BookWormMaster.AddWishList.COLUMN_Author , author);
        contentValues.put(BookWormMaster.AddWishList.COLUMN_Price , price);

        String Selection = BookWormMaster.AddWishList.COLUMN_Title + "  ? ";
        Log.i("DB" , Selection );
        String SelectionArgs[] = { title };

        int wish = db.update(BookWormMaster.AddWishList.TABLE_WLIST , contentValues ,Selection , SelectionArgs);

        if(wish > 0){
            return true;
        }
        else {
            return false;
        }
    }





    public boolean addCategoryOsu(String name){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BookWormMaster.Category.COLUMN_NAME_CATNAME,name);


        long result = db.insert(BookWormMaster.Category.TABLE_NAME_CAT,null,contentValues);

        if (result > 0){
            return true;
        }else {
            return false;
        }

    }
    public ArrayList<Category> readAllCategoriesOsa() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {BookWormMaster.Category.COLUMN_NAME_CATNAME , BookWormMaster.Category._ID };

        String sortOrder = BookWormMaster.Category.COLUMN_NAME_CATNAME;

        Cursor values = db.query(BookWormMaster.Category.TABLE_NAME_CAT ,projection,null,null,null,null,sortOrder);

        ArrayList<Category> CATEGORIES = new ArrayList<Category>();

        while (values.moveToNext()){
            Category category = new Category();
            String categoryname = values.getString( values.getColumnIndexOrThrow( BookWormMaster.Category.COLUMN_NAME_CATNAME ));
            category.setUname( categoryname);
            category.setID( values.getInt( values.getColumnIndexOrThrow(BookWormMaster.Category._ID) )  );
            CATEGORIES.add( category );


        }
        return CATEGORIES;
    }

    //=========================================OSANDA's display method is over==============================



    public boolean addCategory(String name){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BookWormMaster.Category.COLUMN_NAME_CATNAME, name);

        long result = db.insert(BookWormMaster.Category.TABLE_NAME_CAT, null, contentValues);

        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }
//================================AAdi==========================
    public boolean addReadB(String name,String author,String dfrom,String dtill,String genre){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BookWormMaster.ReadBook.COLUMN_RNAME,name);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RAUTHOR,author);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RFROM,dfrom);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RTILL,dtill);
        contentValues.put(BookWormMaster.ReadBook.COLUMN_RGENRE,genre);

        long result = db.insert(BookWormMaster.ReadBook.TABLE_RBOOK,null,contentValues);

        if (result > 0){
            return true;
        }else {
            return false;
        }

    }
    //=============================kavindi=====================================

    public boolean AddWishList(String Title, String Author, double Price){


        Log.i("DB",Price+"");
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BookWormMaster.AddWishList.COLUMN_Title,Title);
        contentValues.put(BookWormMaster.AddWishList.COLUMN_Author,Author);
        contentValues.put(BookWormMaster.AddWishList.COLUMN_Price, Price);

        long result = db.insert(BookWormMaster.AddWishList.TABLE_WLIST,null,contentValues);

        if(result > 0){
            return true;
        }
        else {
            return false;
        }


    }

    //-----------------Adi---------------------------------------------------------------------------------------------
    public ArrayList<RBooks> readAllRbooks() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {BookWormMaster.ReadBook.COLUMN_RNAME , BookWormMaster.ReadBook._ID, BookWormMaster.ReadBook.COLUMN_RAUTHOR, BookWormMaster.ReadBook.COLUMN_RFROM, BookWormMaster.ReadBook.COLUMN_RTILL, BookWormMaster.ReadBook.COLUMN_RGENRE};

        String sortOrder = BookWormMaster.ReadBook.COLUMN_RNAME;

        Cursor values = db.query(BookWormMaster.ReadBook.TABLE_RBOOK ,projection,null,null,null,null,sortOrder);

        ArrayList<RBooks> books = new ArrayList<RBooks>();

        while (values.moveToNext()){
            RBooks book = new RBooks();
            String bookName = values.getString( values.getColumnIndexOrThrow( BookWormMaster.ReadBook.COLUMN_RNAME ));
            book.setName( bookName);
            book.setID( values.getInt( values.getColumnIndexOrThrow(BookWormMaster.ReadBook._ID) )  );
            book.setAuthor(values.getString(values.getColumnIndexOrThrow(BookWormMaster.ReadBook.COLUMN_RAUTHOR)));
            book.setFrom(values.getString(values.getColumnIndexOrThrow(BookWormMaster.ReadBook.COLUMN_RFROM)));
            book.setTill(values.getString(values.getColumnIndexOrThrow(BookWormMaster.ReadBook.COLUMN_RTILL)));
            book.setGenre(values.getString(values.getColumnIndexOrThrow(BookWormMaster.ReadBook.COLUMN_RGENRE)));
            books.add( book );


        }
        return books;
    }

    public ArrayList<BookInfo> readAllBookinfo(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {BookWormMaster.Book.COLUMN_NAME_TITLE , BookWormMaster.Book._ID, BookWormMaster.Book.COLUMN_NAME_REVIEW };

        String sortOrder = BookWormMaster.Book.COLUMN_NAME_TITLE;

        Cursor values = db.query(BookWormMaster.Book.TABLE_NAME, projection, null, null, null, null, sortOrder);

        ArrayList<BookInfo> books = new ArrayList<BookInfo>();

        while(values.moveToNext()){
            BookInfo book = new BookInfo();
            String bookTitle = values.getString(values.getColumnIndexOrThrow(BookWormMaster.Book.COLUMN_NAME_TITLE));
            String bookReview = values.getString(values.getColumnIndexOrThrow(BookWormMaster.Book.COLUMN_NAME_REVIEW));
            book.setTitle(bookTitle);
            book.setID(values.getInt( values.getColumnIndexOrThrow(BookWormMaster.Book._ID)));
            book.setReview(bookReview);
            books.add(book);
        }

        return books;
    }

    //-----------------kavi---------------------------------------------------------------------------------------------

    public ArrayList<WishList> readAllWishList(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {BookWormMaster.AddWishList.COLUMN_Title, BookWormMaster.AddWishList._ID, BookWormMaster.AddWishList.COLUMN_Price ,BookWormMaster.AddWishList.COLUMN_Author};

        String sortOrder = BookWormMaster.AddWishList.COLUMN_Title;

        Cursor values = db.query(BookWormMaster.AddWishList.TABLE_WLIST ,projection,null,null,null,null,sortOrder);

        ArrayList<WishList> wishLists = new ArrayList<WishList>();

        while (values.moveToNext()){
            WishList wish = new WishList();
            String title = values.getString( values.getColumnIndexOrThrow( BookWormMaster.AddWishList.COLUMN_Title));
            wish.setTitle(title);
            wish.setAuthor( values.getString(values.getColumnIndexOrThrow(BookWormMaster.AddWishList.COLUMN_Author)));
            wish.setId( values.getInt( values.getColumnIndexOrThrow(BookWormMaster.AddWishList._ID) )  );
            wish.setPrice(values.getDouble(values.getColumnIndexOrThrow(BookWormMaster.AddWishList.COLUMN_Price)));
            //Log.i("", );
            wishLists.add( wish );
        }
        return wishLists;
    }



}

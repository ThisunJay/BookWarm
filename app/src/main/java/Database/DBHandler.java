package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "bookworm.db";

    public DBHandler(Context context){
        super(context, DB_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

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

        String create_table_category = "CREATE TABLE " + BookWormMaster.Category.TABLE_NAME_CAT + " ("+
                BookWormMaster.Category._ID + " INTEGER PRIMARY KEY, " +
                BookWormMaster.Category.COLUMN_NAME_CATNAME + " TEXT);";

        db.execSQL(create_table_category);

        String create_table_Read = "CREATE TABLE " + BookWormMaster.ReadBook.TABLE_RBOOK + " ("+
                BookWormMaster.ReadBook._ID + " INTEGER PRIMARY KEY, " +
                BookWormMaster.ReadBook.COLUMN_RNAME + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RAUTHOR + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RFROM + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RTILL + " TEXT, " +
                BookWormMaster.ReadBook.COLUMN_RGENRE + " TEXT);";

        db.execSQL(create_table_Read);
        Log.i( "DB" , create_table_Read );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

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
}

package Database;

import android.provider.BaseColumns;

public final class BookWormMaster {

    private BookWormMaster(){}

    protected static class Book implements BaseColumns{

        protected static final String TABLE_NAME = "bookinfo";
        protected static final String COLUMN_NAME_TITLE = "title";
        protected static final String COLUMN_NAME_AUTHOR = "author";
        protected static final String COLUMN_NAME_PRICE = "price";
        protected static final String COLUMN_NAME_PAGES = "pages";
        protected static final String COLUMN_NAME_REVIEW = "review";

    }

    protected static class Category implements BaseColumns{

        protected static final String TABLE_NAME_CAT = "category";
        protected static final String COLUMN_NAME_CATNAME = "name";
    }

    protected static class ReadBook implements BaseColumns{

        protected static final String TABLE_RBOOK = "bookread";
        protected static final String COLUMN_RNAME = "name";
        protected static final String COLUMN_RAUTHOR = "author";
        protected static final String COLUMN_RFROM = "rfrom";
        protected static final String COLUMN_RTILL = "rtill";
        protected static final String COLUMN_RGENRE = "genere";
    }

    protected static class AddWishList implements BaseColumns{

        protected static final String TABLE_WList = "wishList";
        protected static final String COLUMN_Title = "Title";
        protected static final String COLUMN_Author = "Author";
        protected static final String COLUMN_Price = "Price";
    }

}

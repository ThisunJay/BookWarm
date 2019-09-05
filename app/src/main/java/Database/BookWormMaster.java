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

}

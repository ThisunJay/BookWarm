package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.bookworm.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.BookInfo;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookAdapterViewHolder> {

    private ArrayList<BookInfo> arrayList;
   // private BookAdapter.OnReadingListener rOnReadingListner;

    public BookAdapter(ArrayList<BookInfo> arrayList) {
        this.arrayList = arrayList;
        //this.rOnReadingListner = onReadingListener;
    }

    @NonNull
    @Override
    public BookAdapter.BookAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.booklist, viewGroup, false);

        return new BookAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapterViewHolder bookAdapterViewHolder, int i) {
        BookInfo object = arrayList.get(i);
        bookAdapterViewHolder.name.setText( object.getTitle() );
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class BookAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        //OnReadingListener onReadingListener;

        public BookAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.titleView);
           // this.onReadingListener = onReadingListener;
            //itemView.setOnClickListener(this);

        }


    }

//    public interface OnReadingListener{
//        void OnReadingClick(int position);
//    }

}

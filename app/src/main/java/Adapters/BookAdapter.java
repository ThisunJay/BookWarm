package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.bookworm.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.BookInfo;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookAdapterViewHolder> {

    private ArrayList<BookInfo> arrayList;
    private onBookListner onBook;

    public BookAdapter(ArrayList<BookInfo> arrayList, onBookListner onBook) {
        this.arrayList = arrayList;
        this.onBook = onBook;
    }

    @NonNull
    @Override
    public BookAdapter.BookAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.booklist, viewGroup, false);

        return new BookAdapterViewHolder(v, onBook);
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

    public class BookAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView name;
        onBookListner onBookListner;


        public BookAdapterViewHolder(@NonNull View itemView, onBookListner onBookListner) {
            super(itemView);
            name = itemView.findViewById(R.id.titleView);
            this.onBookListner = onBookListner;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view){
            onBookListner.OnBookClick(getAdapterPosition());

        }
    }

    public interface onBookListner{
       void OnBookClick(int position);
    }

}

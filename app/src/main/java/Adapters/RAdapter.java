package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.bookworm.R;

import java.util.ArrayList;

import Model.RBooks;

public class RAdapter  extends RecyclerView.Adapter<RAdapter.RAdapterViewHolder> {

    private ArrayList<RBooks> arrayList;
    private OnReadingListener rOnReadingListner;

    public RAdapter(ArrayList<RBooks> arrayList,OnReadingListener onReadingListener) {
        this.arrayList = arrayList;
        this.rOnReadingListner = onReadingListener;
    }

    @NonNull
    @Override
    public RAdapter.RAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.reading_list , viewGroup , false);
        return new RAdapterViewHolder(view,rOnReadingListner);
    }

    @Override
    public void onBindViewHolder(@NonNull RAdapterViewHolder Holder, int i) {
                RBooks object = arrayList.get(i);
                Holder.name.setText(object.getName() );
                //Holder.type.setText(object.getGenre());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView type;
        OnReadingListener onReadingListener;
        public RAdapterViewHolder(@NonNull View itemView, OnReadingListener onReadingListener) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            //type = itemView.findViewById(R.id.spinner);
            this.onReadingListener = onReadingListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            onReadingListener.OnReadingClick(getAdapterPosition());
        }
    }

    public interface OnReadingListener{
        void OnReadingClick(int position);
    }

    public void filterList(ArrayList<RBooks> filteredList){
        arrayList = filteredList;
        notifyDataSetChanged();
    }


}

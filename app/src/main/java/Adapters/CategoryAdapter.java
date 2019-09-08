package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.bookworm.R;

import java.util.ArrayList;

import Model.Category;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder> {

    private ArrayList<Category> arrayList;
    private OnReadingListener OsaOnReadingListner;

    public CategoryAdapter(ArrayList<Category> arrayList, OnReadingListener OsaOnReadingListner) {
        this.arrayList = arrayList;
        this.OsaOnReadingListner = OsaOnReadingListner;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.categorylist , viewGroup , false);
        return new CategoryAdapterViewHolder(view,OsaOnReadingListner);    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapterViewHolder categoryAdapterViewHolder, int i) {
        Category object = arrayList.get(i);
        categoryAdapterViewHolder.name.setText(object.getUname() );

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CategoryAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        OnReadingListener OsaOnReadingListner;
        public CategoryAdapterViewHolder(@NonNull View itemView, OnReadingListener OsaOnReadingListner) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_nameOSA);
            this.OsaOnReadingListner = OsaOnReadingListner;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            OsaOnReadingListner.OnReadingClick(getAdapterPosition());
        }
    }

    public interface OnReadingListener {
        void OnReadingClick(int position);
    }
}

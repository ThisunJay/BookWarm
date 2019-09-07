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

    public RAdapter(ArrayList<RBooks> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RAdapter.RAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.reading_list , viewGroup , false);
        return new RAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RAdapterViewHolder Holder, int i) {
                RBooks object = arrayList.get(i);
                Holder.name.setText(object.getName() );

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        public RAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);

        }
    }


}

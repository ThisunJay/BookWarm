package Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.bookworm.R;

import java.util.ArrayList;

import Model.WishList;

public class WishAdapter extends RecyclerView.Adapter<WishAdapter.WishAdapterViewHolder> {


        private ArrayList<WishList> arrayList;
        private OnWishingListener WOnWishingListner;

        public WishAdapter(ArrayList<WishList> arrayList) {
            this.arrayList = arrayList;

        }

        public void setArrayList(ArrayList<WishList> arrayList) {
            this.arrayList = arrayList;
            notifyDataSetChanged();
        }


    @NonNull
    @Override
    public WishAdapter.WishAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view = LayoutInflater.from( viewGroup.getContext() ).inflate(R.layout.wish_list, viewGroup , false);
         return new WishAdapterViewHolder(view,WOnWishingListner);
    }

    @Override
    public void onBindViewHolder(@NonNull WishAdapterViewHolder ViewHolder, int i) {
        WishList object = arrayList.get(i);
        ViewHolder.name.setText(object.getTitle() );
    }

    @Override
    public int getItemCount() { return arrayList.size();}

    public class WishAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView name;
            OnWishingListener onwishingListner;

            public WishAdapterViewHolder(@NonNull View itemView, OnWishingListener onWishingListener){
                super(itemView);
                name = itemView.findViewById(R.id.addWish);
                this.onwishingListner = onWishingListener;

                itemView.setOnClickListener(this);
            }

            @Override
        public void onClick(View view) { onwishingListner.OnWishingClick(getAdapterPosition());}


    }

    public interface OnWishingListener{
            void OnWishingClick(int position);
    }
}

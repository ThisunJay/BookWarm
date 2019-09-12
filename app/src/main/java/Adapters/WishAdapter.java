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


        private ArrayList<WishList> WarrayList;
        private OnWishingListener monWishingListener;

        public WishAdapter(ArrayList<WishList> arrayList, OnWishingListener onWishingListener) {
            this.WarrayList = arrayList;
            this.monWishingListener = onWishingListener;

        }


    public void setArrayList(ArrayList<WishList> arrayList) {
            this.WarrayList = arrayList;
            notifyDataSetChanged();
        }



    @NonNull
    @Override
    public WishAdapter.WishAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view = LayoutInflater.from( viewGroup.getContext() ).inflate(R.layout.wish_list, viewGroup , false);
         return new WishAdapterViewHolder(view,monWishingListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WishAdapterViewHolder ViewHolder, int i) {
        WishList object = WarrayList.get(i);
        ViewHolder.name.setText(object.getTitle() );
    }

    @Override
    public int getItemCount() { return WarrayList.size();}

    public class WishAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView name;
            OnWishingListener onWishingListener;

            public WishAdapterViewHolder(@NonNull View itemView, OnWishingListener onWishingListener){
                super(itemView);
                name = itemView.findViewById(R.id.addWish);
                this.onWishingListener = onWishingListener;

                itemView.setOnClickListener(this);

            }


            @Override
        public void onClick(View view) {
                onWishingListener.OnWishingClick(getAdapterPosition());
            }


    }

    public interface OnWishingListener{
            void OnWishingClick(int position);
    }
}

package com.mrsyafapri.restokan;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListRestaurantAdapter extends RecyclerView.Adapter<ListRestaurantAdapter.ListViewHolder> {

    private final ArrayList<Restaurant> listRestaurant;

    public ListRestaurantAdapter(ArrayList<Restaurant> list) {
        this.listRestaurant = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_restaurant, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Restaurant restaurant = listRestaurant.get(position);
        Glide.with(holder.itemView.getContext())
                .load(restaurant.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(restaurant.getName());
        holder.tvDesc.setText(restaurant.getDesc());
        holder.tvAddress.setText(restaurant.getAddress());
        holder.tvRating.setText(String.valueOf(restaurant.getRating()));
        holder.itemView.setOnClickListener(view -> {
            Intent moveToDetail = new Intent(holder.itemView.getContext(), DetailActivity.class);
            moveToDetail.putExtra("photo", restaurant.getPhoto());
            moveToDetail.putExtra("name", restaurant.getName());
            moveToDetail.putExtra("address", restaurant.getAddress());
            moveToDetail.putExtra("rating", restaurant.getRating());
            moveToDetail.putExtra("desc", restaurant.getDesc());
            holder.itemView.getContext().startActivity(moveToDetail);
        });
    }

    @Override
    public int getItemCount() {
        return listRestaurant.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc, tvAddress, tvRating;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
            tvAddress = itemView.findViewById(R.id.tv_item_address);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
        }
    }
}

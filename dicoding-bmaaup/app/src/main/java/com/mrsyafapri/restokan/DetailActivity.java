package com.mrsyafapri.restokan;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgPhoto = findViewById(R.id.img_item_photo);
        TextView tvName = findViewById(R.id.tv_item_name);
        TextView tvDesc = findViewById(R.id.tv_item_desc);
        TextView tvAddress = findViewById(R.id.tv_item_address);
        TextView tvRating = findViewById(R.id.tv_item_rating);

        Intent intent = getIntent();

        final String name = intent.getExtras().getString("name");
        final String desc = intent.getExtras().getString("desc");
        final String address = intent.getExtras().getString("address");
        final double rating = intent.getExtras().getDouble("rating");
        final int photo = intent.getExtras().getInt("photo");


        Glide.with(this)
                .load(photo)
                .apply(new RequestOptions())
                .into(imgPhoto);
        tvName.setText(name);
        tvDesc.setText(desc);
        tvAddress.setText(address);
        tvRating.setText(String.valueOf(rating));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Restaurant");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
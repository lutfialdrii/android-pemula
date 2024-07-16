package com.mrsyafapri.restokan;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRestaurants;
    private final ArrayList<Restaurant> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRestaurants = findViewById(R.id.rv_restaurants);
        rvRestaurants.setHasFixedSize(true);

        list.addAll(RestaurantData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        ListRestaurantAdapter listRestaurantAdapter = new ListRestaurantAdapter(list);
        rvRestaurants.setAdapter(listRestaurantAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        if (selectedMode == R.id.action_about) {
            Intent moveIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(moveIntent);
        }
    }
}
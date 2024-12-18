package com.example.buffetlight;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    private ListView recyclerView;
    private ListItemAdapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        recyclerView = findViewById(R.id.recyclerView);
        

        // Заполнение списка данными
        listItems = new ArrayList<>();
        listItems.add(new ListItem("Амстердам", R.drawable.amsterdam));
        listItems.add(new ListItem("Оливье", R.drawable.olivier));
        listItems.add(new ListItem("Октябрь", R.drawable.october));
        listItems.add(new ListItem("Яблочный компот", R.drawable.apple));
        listItems.add(new ListItem("Кофе", R.drawable.coffee));
        listItems.add(new ListItem("Коктель с огурцом", R.drawable.cucumber));

        // Инициализация адаптера и установка в RecyclerView
        adapter = new ListItemAdapter(this, listItems);
        recyclerView.setAdapter((ListAdapter) adapter);
    }
}
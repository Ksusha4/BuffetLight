package com.example.buffetlight;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);

        // Инициализация ListView
        listView = findViewById(R.id.aboba);

        // Создание списка элементов
        ArrayList<ListItem> listItems = new ArrayList<>();
        listItems.add(new ListItem("Амстердам", R.drawable.amsterdam));
        listItems.add(new ListItem("Оливье", R.drawable.olivier));
        listItems.add(new ListItem("Октябрь", R.drawable.october));

        // Установка адаптера
        ListItemAdapter adapter = new ListItemAdapter(this, listItems);
        listView.setAdapter(adapter);
    }
}


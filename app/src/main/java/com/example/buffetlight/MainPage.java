package com.example.buffetlight;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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
        listItems.add(new ListItem("Бокс Амстердам", R.drawable.amsterdam));
        listItems.add(new ListItem("Оливье", R.drawable.olivier));
        listItems.add(new ListItem("Октябрь", R.drawable.october));
        listItems.add(new ListItem("Яблочный компот", R.drawable.apple));
        listItems.add(new ListItem("Кофе", R.drawable.coffee));
        listItems.add(new ListItem("Коктель с огурцом", R.drawable.cucumber));

        // Установка адаптера
        ListItemAdapter adapter = new ListItemAdapter(this, listItems);
        listView.setAdapter(adapter);

        // Обработка нажатий на элементы списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Получение нажатого элемента
                ListItem clickedItem = listItems.get(position);

                // Создание намерения для перехода на новую активность
                Intent intent = new Intent(MainPage.this, ShowDetailActivity.class); // Замените CurrentActivity на MainPage

                // Передача данных в новую активность
                intent.putExtra("Бокс Амстердам", clickedItem.getText()); // Имя элемента
                startActivity(intent);
            }
        });
    }
}
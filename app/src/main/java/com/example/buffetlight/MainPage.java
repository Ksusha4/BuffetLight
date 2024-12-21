package com.example.buffetlight;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.buffetlight.poop.ListItem;
import com.example.buffetlight.poop.ListItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);

        // Инициализация ListView
        listView = findViewById(R.id.list_items);

        // Создание списка элементов
        ArrayList<ListItem> listItems = new ArrayList<>();
        listItems.add(new ListItem("Бокс Амстердам", R.drawable.amsterdam, "4500", "вафли, орехи, инжир, виноград, манго, шоколад, клубника, физалис."));
        listItems.add(new ListItem("Салат Оливье с семгой и красной икрой", R.drawable.olivier,"414", "семга слабосоленая, картофель, яйцо, горошек зеленый (консервированный), майонез, икра красная, перец черный (мельница)."));
        listItems.add(new ListItem("Салат \"Октябрь\"", R.drawable.october,"500", "тыква, куриное филе, моцарелла-мини, маслины, сладкая масляно-соевая заправка."));
        listItems.add(new ListItem("Долма с говядиной со сметанным соусом", R.drawable.dolma,"3273", "говядина, виноградные листья, сметана."));
        listItems.add(new ListItem("Кофе с маршмеллоу", R.drawable.marshmallow,"399", "вода, кофе растворимый, маршмеллоу, сахар."));
        listItems.add(new ListItem("Бокс Диснейленд", R.drawable.disneyland,"3600", "печенье, сыр косичка, сардельки, виноград, фисташки, гренки, канапе."));

        // Установка адаптера
        ListItemAdapter adapter = new ListItemAdapter(MainPage.this, listItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Получаем выбранный элемент
            ListItem selectedItem = listItems.get(position);

            // Создаем интент для перехода в ShowDetailActivity
            Intent intent = new Intent(MainPage.this, ShowDetailActivity.class);

            // Передаем данные: название и картинку
            intent.putExtra("food_name", selectedItem.getText());
            intent.putExtra("image_res_id", selectedItem.getImageResId());
            intent.putExtra("food_price", selectedItem.getPrice());
            intent.putExtra("food_ingredients", selectedItem.getIng());


            // Стартуем активность
            startActivity(intent);
        });
    }
}
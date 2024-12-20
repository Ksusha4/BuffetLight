package com.example.buffetlight;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView ingredientsTextView;
    private TextView priceTextView;
    private ImageView foodImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        // Инициализация UI элементов
        nameTextView = findViewById(R.id.titleTxt);
        ingredientsTextView = findViewById(R.id.descriptionTxt);
        priceTextView = findViewById(R.id.priceTxt);
        foodImageView = findViewById(R.id.food);

        // Получаем данные из интента
        String foodName = getIntent().getStringExtra("food_name");
        String foodIngredients = getIntent().getStringExtra("food_ingredients");
        String foodPrice = getIntent().getStringExtra("food_price");
        int imageResId = getIntent().getIntExtra("image_res_id", R.drawable.add); // Дефолтное изображение

        // Устанавливаем название и картинку
        nameTextView.setText(foodName);
        foodImageView.setImageResource(imageResId);

        // Устанавливаем ингредиенты и цену
        ingredientsTextView.setText("Состав: " + foodIngredients);
        priceTextView.setText(String.format("Цена: " + foodPrice));
    }
}
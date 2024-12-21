package com.example.buffetlight;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView ingredientsTextView;
    private TextView priceTextView;
    private ImageView foodImageView;
    private TextView numberOrderTxt;
    private ImageView plus;
    private ImageView minus;
    private int count = 1;
    private double unitPrice; // Переменная для цены за единицу товара

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
        String foodPrice = getIntent().getStringExtra("food_price"); // Оставляем как строку
        int imageResId = getIntent().getIntExtra("image_res_id", R.drawable.add); // Дефолтное изображение

        // Преобразуем строку foodPrice в double
        unitPrice = Double.parseDouble(foodPrice); // Преобразуем строку в double

        // Устанавливаем название и картинку
        nameTextView.setText(foodName);
        foodImageView.setImageResource(imageResId);

        // Устанавливаем ингредиенты
        ingredientsTextView.setText("Состав: " + foodIngredients);

        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        // Устанавливаем обработчик для кнопки "плюс"
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                updateCount();
            }
        });

        // Устанавливаем обработчик для кнопки "минус"
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1) { // Предотвращаем уменьшение меньше 1
                    count--;
                }
                updateCount();
            }
        });

        // Инициализируем TextView
        updateCount();
    }

    private void updateCount() {
        numberOrderTxt.setText(String.valueOf(count));
        double totalPrice = count * unitPrice; // Рассчитываем общую стоимость
        priceTextView.setText(String.format("Цена: %.2f", totalPrice)); // Обновляем текст цены
    }
}
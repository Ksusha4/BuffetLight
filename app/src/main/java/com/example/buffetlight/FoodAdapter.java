package com.example.buffetlight;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private List<FoodModel> foodList;
    private LayoutInflater inflater;

    public FoodAdapter(Context context, List<FoodModel> foodList) {
        this.context = context;
        this.foodList = foodList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.recyclerview_card, parent, false);
        }

        // Инициализация UI элементов
        TextView foodNameTextView = convertView.findViewById(R.id.titleTxt);

        // Получаем текущий элемент
        FoodModel food = foodList.get(position);

        // Устанавливаем название блюда
        foodNameTextView.setText(food.getName());

        // Обработка клика на элемент списка
        convertView.setOnClickListener(v -> {
            // Переход на ShowDetailActivity, передаем название блюда и изображение
            Intent intent = new Intent(context, ShowDetailActivity.class);
            intent.putExtra("food_name", food.getName());
            intent.putExtra("image_res_id", R.drawable.add); // Здесь можно указать картинку по умолчанию
            context.startActivity(intent);
        });

        return convertView;
    }
}
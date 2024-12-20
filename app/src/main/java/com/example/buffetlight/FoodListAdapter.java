package com.example.buffetlight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodListAdapter extends BaseAdapter {
    private Context context;
    private List<FoodModel> foodlist;
    private LayoutInflater inflater;

    // Конструктор
    public FoodListAdapter(Context context, List<FoodModel> foodlist) {
        this.context = context;
        this.foodlist = foodlist;
        this.inflater = LayoutInflater.from(context); // Инициализируем inflater
    }

    @Override
    public int getCount() {
        return foodlist.size();
    }

    @Override
    public Object getItem(int position) {
        return foodlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Проверяем, является ли convertView нулевым
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.recyclerview_card, parent, false); // Используем ваш XML для элемента списка
        }

        // Ищем элементы в представлении
        TextView titleTxt = convertView.findViewById(R.id.textView5);

        // Получаем текущий элемент из списка
        FoodModel foodModel = foodlist.get(position);
        titleTxt.setText(foodModel.getName());

        return convertView;
    }
}

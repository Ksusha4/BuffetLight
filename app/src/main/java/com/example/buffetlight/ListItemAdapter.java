package com.example.buffetlight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListItemAdapter extends BaseAdapter {

    private Context context;
    private List<ListItem> listItems;
    private LayoutInflater inflater;

    // Инициализируем inflater в конструкторе
    public ListItemAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
        this.inflater = LayoutInflater.from(context); // Инициализация LayoutInflater
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Используем inflater для создания нового элемента списка
            convertView = LayoutInflater.from(context).inflate(R.layout.recyclerview_card, parent, false);
        }

        // Ищем элементы в текущем представлении
        ImageView imageView = convertView.findViewById(R.id.imageView8);
        TextView textView = convertView.findViewById(R.id.textView5);

        // Получаем текущий элемент из списка
        ListItem listItem = listItems.get(position);

        // Устанавливаем данные
        imageView.setImageResource(listItem.getImageResId());
        textView.setText(listItem.getText());

        return convertView;
    }
}
package com.example.buffetlight;

import static com.example.buffetlight.SupabaseConfig.SUPABASE_KEY;
import static com.example.buffetlight.SupabaseConfig.SUPABASE_URL;

import androidx.annotation.NonNull;

import com.example.buffetlight.HttpHelper;
import com.example.buffetlight.FoodModel; // Импортируйте вашу модель
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class FoodService {

    public static void getFoods(FoodCallback callback) {
        String url = SUPABASE_URL + "/rest/v1/Каталог1?select=\"Название\",\"Цена\",\"Состав\"";
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + SUPABASE_KEY)
                .addHeader("apikey", SUPABASE_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        HttpHelper.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure("Ошибка сети: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    try {
                        // Преобразование JSON в список объектов FoodModel
                        Type listType = new TypeToken<List<FoodModel>>() {}.getType();
                        List<FoodModel> foods = new Gson().fromJson(responseData, listType);

                        callback.onSuccess(foods);
                    } catch (Exception e) {
                        callback.onFailure("Ошибка обработки данных: " + e.getMessage());
                    }
                } else {
                    callback.onFailure("Ошибка загрузки данных: Код " + response.code());
                }
            }
        });
    }

    // Интерфейс обратного вызова
    public interface FoodCallback {
        void onSuccess(List<FoodModel> foods);
        void onFailure(String message);
    }
}

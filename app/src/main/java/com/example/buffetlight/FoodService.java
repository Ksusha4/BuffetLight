package com.example.buffetlight;

import static com.example.buffetlight.SupabaseConfig.SUPABASE_KEY;
import static com.example.buffetlight.SupabaseConfig.SUPABASE_URL;

import android.util.Log;

import androidx.annotation.NonNull;

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

    // Получаем список блюд
    public static void getFoods(FoodCallback callback) {
        String url = SUPABASE_URL + "/rest/v1/catalog?select=names,price,ingredients";

        // Строим запрос
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + SUPABASE_KEY)
                .addHeader("apikey", SUPABASE_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        // Выполняем запрос
        HttpHelper.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure("Ошибка сети: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String responseData = response.body().string();
                    try {
                        // Преобразуем JSON в список объектов FoodModel
                        Type listType = new TypeToken<List<FoodModel>>() {}.getType();
                        List<FoodModel> foods = new Gson().fromJson(responseData, listType);

                        // Вызываем успех в колбэке с полученными данными
                        callback.onSuccess(foods);
                    } catch (Exception e) {
                        // Логируем и передаем ошибку в колбэк
                        callback.onFailure("Ошибка обработки данных: " + e.getMessage());
                    }
                } else {
                    // Логируем и передаем ошибку в колбэк, если код ответа не успешный
                    callback.onFailure("Ошибка загрузки данных: Код " + response.code());
                }
            }
        });
    }

    // Интерфейс обратного вызова
    public interface FoodCallback {
        void onSuccess(List<FoodModel> foods); // Данные успешно получены
        void onFailure(String message); // Ошибка при получении данных
    }
}
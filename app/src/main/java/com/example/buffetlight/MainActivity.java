package com.example.buffetlight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.invoke.ConstantCallSite;

public class MainActivity extends AppCompatActivity {
    private Button StartApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartApp=findViewById(R.id.enter);
        StartApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainPage.class));
            }
        });
    }
}
package com.example.calculadoramax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button backButton = findViewById(R.id.buttonBack);
        Button nextButton = findViewById(R.id.buttonNext);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar de vuelta al MainActivity
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir al siguiente MainActivity
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
    }
}

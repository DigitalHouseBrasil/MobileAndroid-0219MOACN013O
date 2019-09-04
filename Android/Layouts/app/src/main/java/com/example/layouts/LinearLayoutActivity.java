package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class LinearLayoutActivity extends AppCompatActivity {
    private Button btnFrame;
    private Button btnRelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFrame = findViewById(R.id.btnFrameLayout);
        btnRelative = findViewById(R.id.btnRelativeLayout);

        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Iniciando uma nova intenção para ir para a tela com o FrameLayout
                startActivity(new Intent(LinearLayoutActivity.this, FrameLayoutActivity.class));
            }
        });

        btnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Iniciando uma nova intenção para ir para a tela com o RelativeLayout
                startActivity(new Intent(LinearLayoutActivity.this, RelativeLayoutActivity.class));
            }
        });



    }
}

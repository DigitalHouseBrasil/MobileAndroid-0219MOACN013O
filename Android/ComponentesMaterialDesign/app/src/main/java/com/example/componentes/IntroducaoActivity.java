package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class IntroducaoActivity extends AppCompatActivity {

    private ImageView imgSplash;
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao);

        imgSplash = findViewById(R.id.img_music);

        imgSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump();
            }
        });

        //chamada do método que  irá temporizar a duração da tela de splash
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 3000);
    }

    //Método que vai para a tela de Home através de uma Intent
    private void jump(){
        timer.cancel();
        startActivity(new Intent(IntroducaoActivity.this, HomeActivity.class));
        finish();

    }
}

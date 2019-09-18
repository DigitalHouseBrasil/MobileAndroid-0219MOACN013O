package com.example.ciclovidafragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo", "Activity: Metodo onCreate() chamado");
        setContentView(R.layout.activity_main);
        Log.i("Ciclo", "Activity : Metodo onCreate() Finalizado.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo", "Activity: Metodo onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo", "Activity: Metodo onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo", "Activity: Metodo onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo", "Activity: Metodo onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Ciclo", "Activity: Metodo onSavedInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo", "Activity: Metodo onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo", "Activity: Metodo onDestroy()");
    }
}

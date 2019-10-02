package com.example.recyclerviewlistener.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewlistener.R;
import com.example.recyclerviewlistener.modelo.Animal;

import org.w3c.dom.Text;

import static com.example.recyclerviewlistener.view.MainActivity.ANIMAL_KEY;

//Implementação da classe para exibir as informações que estão vindo da outra tela
public class DetalheAnimalActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView txtNome;
    private TextView txtDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_animal);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null){

            Animal animal = getIntent().getExtras().getParcelable(ANIMAL_KEY);

            Drawable drawable = getResources().getDrawable(animal.getImagem());
            imageView.setImageDrawable(drawable);
            txtNome.setText(animal.getNome());
            txtDetalhe.setText(animal.getDetalhe());
        }

    }

    private void initViews(){
        imageView = findViewById(R.id.imagDetalhe);
        txtNome = findViewById(R.id.txtNome);
        txtDetalhe = findViewById(R.id.txtDetalhe);
    }
}

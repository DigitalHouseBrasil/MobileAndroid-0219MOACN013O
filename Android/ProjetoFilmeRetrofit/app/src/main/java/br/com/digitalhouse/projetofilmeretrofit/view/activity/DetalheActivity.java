package br.com.digitalhouse.projetofilmeretrofit.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import br.com.digitalhouse.projetofilmeretrofit.R;
import br.com.digitalhouse.projetofilmeretrofit.model.Filme;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        ImageView imageViewDetalhe = findViewById(R.id.imagemDetalhe);

        if (getIntent() != null){
            Filme filme = getIntent().getParcelableExtra("Filme");
            Toast.makeText(this, "Filme "+filme.getTitle(), Toast.LENGTH_LONG ).show();

            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+ filme.getPosterPath()).into(imageViewDetalhe);


        }
    }
}

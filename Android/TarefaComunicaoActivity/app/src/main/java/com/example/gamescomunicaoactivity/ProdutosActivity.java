package com.example.gamescomunicaoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.gamescomunicaoactivity.CadastroActivity.CONTADOR_KEY;
import static com.example.gamescomunicaoactivity.CadastroActivity.PRODUTO_KEY;
import static com.example.gamescomunicaoactivity.CadastroActivity.VALOR_KEY;

public class ProdutosActivity extends AppCompatActivity {

    private TextView produto_um;
    private TextView produto_dois;
    private TextView produto_tres;
    private TextView valor_um;
    private TextView valor_dois;
    private TextView valor_tres;
    private TextView total;
    private TextView preco;
    private Button btn_voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        produto_um = findViewById(R.id.text_produto_um);
        produto_dois = findViewById(R.id.text_produto_dois);
        produto_tres = findViewById(R.id.text_produto_tres);
        valor_um = findViewById(R.id.text_valor_um);
        valor_dois = findViewById(R.id.text_valor_dois);
        valor_tres = findViewById(R.id.text_valor_tres);
        total = findViewById(R.id.text_view_total);
        preco = findViewById(R.id.text_view_preco);
        btn_voltar = findViewById(R.id.bton_voltar);

        getValor(getIntent());

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProdutosActivity.this, CadastroActivity.class));
            }
        });
    }

    private void getValor(Intent intent) {

        if (getIntent() != null && intent.getExtras() != null) {

            Bundle bundle = intent.getExtras();
            ArrayList<Produto> produtos = bundle.getParcelableArrayList(PRODUTO_KEY);

            for (int i = 0; i < produtos.size(); i++) {

                if (i == 0) {

                    produto_um.setText(produtos.get(i).getNome());
                    valor_um.setText(produtos.get(i).getValor());
                    Toast.makeText(getApplicationContext(), "Produto adicionado", Toast.LENGTH_LONG);

                } else if (i == 1) {

                    produto_dois.setText(produtos.get(i).getNome());
                    valor_dois.setText(produtos.get(i).getValor());
                    Toast.makeText(getApplicationContext(), "Produto adicionado", Toast.LENGTH_LONG);

                } else if (i == 2) {

                    produto_tres.setText(produtos.get(i).getNome());
                    valor_tres.setText(produtos.get(i).getValor());
                    Toast.makeText(getApplicationContext(), "Produto adicionado", Toast.LENGTH_LONG);

                } else {
                    Snackbar.make(total, "Só podemos cadastrar 3 produtos", Snackbar.LENGTH_LONG);
                }
            }

        } else {
            Toast.makeText(getApplicationContext(), "Deu ruim no Bundle", Toast.LENGTH_SHORT).show();
        }
    }
}
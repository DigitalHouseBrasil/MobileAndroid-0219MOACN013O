package com.example.gamescomunicaoactivity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.gamescomunicaoactivity.CadastroActivity.CONTADOR;
import static com.example.gamescomunicaoactivity.CadastroActivity.CONTADOR_KEY;
import static com.example.gamescomunicaoactivity.CadastroActivity.PRODUTO_KEY;
import static com.example.gamescomunicaoactivity.CadastroActivity.VALOR_KEY;
import static com.example.gamescomunicaoactivity.LoginActivity.NOME_KEY;

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
    public final static String CONT_KEY = "cont";



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


        final Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null  ) {

            Bundle bundle = intent.getExtras();

            Integer contador = bundle.getInt(CONTADOR_KEY);

            String produtoUm = bundle.getString(PRODUTO_KEY);
            String valorUm = bundle.getString(VALOR_KEY);

            String produtoDois = bundle.getString(PRODUTO_KEY);
            String valorDois = bundle.getString(VALOR_KEY);

            String produtoTres = bundle.getString(PRODUTO_KEY);
            String valorTres = bundle.getString(VALOR_KEY);


            if(contador == 0){
                //contador++;
                produto_um.setText(produtoUm);
                valor_um.setText(valorUm);
                CONTADOR++;
                Toast.makeText(getApplicationContext(), "Produto adicionado", Toast.LENGTH_LONG);

            }else if(contador == 1){
                //contador++;
                produto_dois.setText(produtoDois);
                valor_dois.setText(valorDois);
                CONTADOR++;
                Toast.makeText(getApplicationContext(), "Produto adicionado", Toast.LENGTH_LONG);

            }else if(contador == 2){
                //contador++;
                produto_tres.setText(produtoTres);
                valor_tres.setText(valorTres);
                CONTADOR++;
                Toast.makeText(getApplicationContext(), "Produto adicionado", Toast.LENGTH_LONG);

            } else {
                Snackbar.make(total, "Só podemos cadastrar 3 produtos", Snackbar.LENGTH_LONG);
            }

        } else {
            Toast.makeText(getApplicationContext(), "Deu ruim no Bundle", Toast.LENGTH_SHORT).show();
        }
            btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProdutosActivity.this, CadastroActivity.class);

                Bundle bundle = new Bundle();

                bundle.putInt(CONT_KEY, CONTADOR);

                intent.putExtras(bundle);

                startActivity(intent);


            }
        });
    }
}
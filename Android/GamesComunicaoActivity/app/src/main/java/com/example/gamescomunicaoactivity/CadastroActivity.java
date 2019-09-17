package com.example.gamescomunicaoactivity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.gamescomunicaoactivity.LoginActivity.NOME_KEY;
import static com.example.gamescomunicaoactivity.ProdutosActivity.CONT_KEY;

public class CadastroActivity extends AppCompatActivity {

    private TextView text_cont;
    private TextView text_name;
    private Button btn_enviar;
    private TextInputLayout text_input_produto;
    private TextInputLayout text_input_valor;
    public static final String PRODUTO_KEY = "produto";
    public static final String VALOR_KEY = "valor";
    public static final String CONTADOR_KEY = "contador";
    public static Integer CONTADOR = 0;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        text_name = findViewById(R.id.text_name_usuario);
        btn_enviar = findViewById(R.id.btn_enviar);
        text_input_produto = findViewById(R.id.text_name_produto);
        text_input_valor = findViewById(R.id.text_valor_produto);



        final Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null ){

            Bundle bundle = intent.getExtras();

            cont = bundle.getInt(CONT_KEY);
            String nome = bundle.getString(NOME_KEY);

            text_name.setText(nome);

        }

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String produto = text_input_produto.getEditText().getText().toString();
                String valor = text_input_valor.getEditText().getText().toString();

                if(!produto.isEmpty() && !valor.isEmpty()){

                    Intent intentCas = new Intent(CadastroActivity.this, ProdutosActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putString(PRODUTO_KEY, produto);
                    bundle.putString(VALOR_KEY, valor);


                    bundle.putInt(CONTADOR_KEY, CONTADOR);

                    intentCas.putExtras(bundle);

                    startActivity(intentCas);
                }else{
                    text_input_produto.setError("Preencha o nome do Produto!");
                    text_input_valor.setError("Preencha o valor do Produto!");
                }
            }
        });

    }
}
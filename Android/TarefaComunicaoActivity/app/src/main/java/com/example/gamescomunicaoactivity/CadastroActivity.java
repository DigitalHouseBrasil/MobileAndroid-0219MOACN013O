package com.example.gamescomunicaoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.gamescomunicaoactivity.LoginActivity.NOME_KEY;

public class CadastroActivity extends AppCompatActivity {

    private TextView text_name;
    private Button btn_enviar;
    private TextInputLayout text_input_produto;
    private TextInputLayout text_input_valor;
    public static final String PRODUTO_KEY = "produto";
    public static final String VALOR_KEY = "valor";
    public static final String CONTADOR_KEY = "contador";
    public ArrayList<Produto> produtos = new ArrayList<>();
    private FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initView();

        final Intent intent = getIntent();

        if (getIntent() != null && intent.getExtras() != null) {

            Bundle bundle = intent.getExtras();

            String nome = bundle.getString(NOME_KEY);

            text_name.setText(nome);
        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String produto = text_input_produto.getEditText().getText().toString();
                String valor = text_input_valor.getEditText().getText().toString();

                if (!produto.isEmpty() && !valor.isEmpty()) {

                    Produto novoProduto = new Produto(produto, valor);
                    addProductInList(novoProduto);

                    text_input_produto.getEditText().setText("");
                    text_input_valor.getEditText().setText("");

                } else {
                    text_input_produto.setError("Preencha o nome do Produto!");
                    text_input_valor.setError("Preencha o valor do Produto!");
                }
            }
        });


        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToActivty();
            }
        });

    }

    private void initView() {
        text_name = findViewById(R.id.text_name_usuario);
        btn_enviar = findViewById(R.id.btn_enviar);
        text_input_produto = findViewById(R.id.text_name_produto);
        text_input_valor = findViewById(R.id.text_valor_produto);
        btnAdd = findViewById(R.id.floatingActionButtonAdd);
    }

    private void addProductInList(Produto produto) {
        produtos.add(produto);
    }

    private void intentToActivty() {

        Intent intent = new Intent(CadastroActivity.this, ProdutosActivity.class);

        Bundle bundle = new Bundle();

        bundle.putParcelableArrayList(PRODUTO_KEY, produtos);

        intent.putExtras(bundle);

        startActivity(intent);
    }

}

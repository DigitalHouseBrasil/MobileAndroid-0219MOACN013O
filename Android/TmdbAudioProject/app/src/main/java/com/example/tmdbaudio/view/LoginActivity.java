package com.example.tmdbaudio.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tmdbaudio.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    //Passo 1: Declarar os atributos relacionados ao Google Login, como botão o objeto GoogleSignInCLient e a constante
    private SignInButton googleSignInButton;
    private GoogleSignInClient googleSignInClient;
    public static final String GOOGLE_ACCOUNT = "google_account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inicialização do botão
        googleSignInButton = findViewById(R.id.sign_in_button);

        //Ação que traz os dados Default do usuário selecionado na hora do login
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        //Atribuição paraa  o objeto o valor do login recebido
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        //Click do botão de login do google
        googleSignInButton.setOnClickListener(view -> {

            //Intent de logar
            Intent signInIntent = googleSignInClient.getSignInIntent();

            //chamada do método startActivityForResult passando a intent de login e um codigo de identificação para identificação da onde os dados estão vindo
            //na sobrescrita do método onActivityResult
            startActivityForResult(signInIntent, 101);

        });
    }

    //Sobrescrita do método onActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Verifica se o valor do resultCode é igual a constante RESULT_OK
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                //Caso o codigo seja 101 ele recupera a conta logada e passa para o método concluirLogin
                //Caso contrario pega a exceção
                case 101:
                    try {

                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount conta = task.getResult(ApiException.class);
                        concluirLogin(conta);

                    } catch (ApiException e) {

                        Log.i("LOG", "Error: " + e.getMessage());

                        Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }


    //Método que conclui o Login e envia o objeto com os dados do usuario logado para a tela MainActivity
    private void concluirLogin(GoogleSignInAccount googleSignInAccount) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(GOOGLE_ACCOUNT, googleSignInAccount);
        startActivity(intent);
        finish();
    }

    //A sobrescrita do onStart verifica se ja possuim um usuario logado se ja possuir um usuario logado ele já vai para a tela MainActivity
    //Senão ele mostra um toast dizendo que precisa de uma conta a ser logada
    @Override
    public void onStart() {
        super.onStart();

        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);

        if (alreadyloggedAccount != null) {

            Toast.makeText(this, "Você já está logado", Toast.LENGTH_SHORT).show();
            concluirLogin(alreadyloggedAccount);

        } else {
            Toast.makeText(this, "Entre em alguma conta", Toast.LENGTH_LONG).show();
        }
    }
}

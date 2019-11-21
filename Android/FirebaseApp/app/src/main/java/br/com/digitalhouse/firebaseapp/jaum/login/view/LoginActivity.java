package br.com.digitalhouse.firebaseapp.jaum.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.jaum.home.view.HomeActivity;
import br.com.digitalhouse.firebaseapp.jaum.register.view.RegisterActivity;
import br.com.digitalhouse.firebaseapp.jaum.util.AppUtil;

public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1001;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnLogin;
    private Button btnLoginFacebook;
    private SignInButton btnLoginGoogle;
    private TextView textViewGotoRegister;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        //TODO: Inicializar callback facebook
        callbackManager = CallbackManager.Factory.create();

        //Vai para tela de registro de usuário
        textViewGotoRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        //Fax o login com email e senha
        btnLogin.setOnClickListener(v -> loginEmail());

        // Login com Facebook
        btnLoginFacebook.setOnClickListener(v -> loginFacebook());

        // Login com Google
        btnLoginGoogle.setOnClickListener(v -> loginGoogle());

        AppUtil.printKeyHash(this);
    }

    private void initViews() {
        btnLogin = findViewById(R.id.btn_login);
        btnLoginFacebook = findViewById(R.id.btn_login_facebook);
        btnLoginGoogle = findViewById(R.id.btn_login_google);
        textInputLayoutEmail = findViewById(R.id.textinput_email);
        textInputLayoutPassword = findViewById(R.id.textinput_password);
        textViewGotoRegister = findViewById(R.id.textViewGotoRegister);
    }

    public void loginEmail() {

        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Campos não podem ser vazios :(", Toast.LENGTH_SHORT).show();
            return;
        }

        // tentamos fazer o login com o email e senha no firebase
        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        irParaHome(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    } else {
                        Snackbar.make(btnLogin, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                    }
                });
    }

    private void loginGoogle() {
        // TODO: Login Google
    }


    public void loginFacebook() {
        // TODO: Login facebook
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                irParaHome(loginResult.getAccessToken().getUserId());
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void irParaHome(String uiid) {
        AppUtil.salvarIdUsuario(getApplication().getApplicationContext(), uiid);
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
    }

    private void autenticacaoGoogle(GoogleSignInAccount account) {
        // TODO: autenticar com google e ir para home
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO: activeresult para callback facebook
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        // TODO: validar requestcode para google
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                autenticacaoGoogle(account);
            }
        }
    }
}

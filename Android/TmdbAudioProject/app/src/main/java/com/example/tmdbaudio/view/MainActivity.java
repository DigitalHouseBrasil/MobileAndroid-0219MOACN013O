package com.example.tmdbaudio.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmdbaudio.R;
import com.example.tmdbaudio.adapter.RecyclerViewAdapater;
import com.example.tmdbaudio.model.Album;
import com.example.tmdbaudio.viewmodel.AlbumViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.tmdbaudio.view.LoginActivity.GOOGLE_ACCOUNT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Album> albuns = new ArrayList<>();
    private AlbumViewModel viewModel;
    private ProgressBar progressBar;
    private RecyclerViewAdapater adapter;
    private SearchView searchView;
    private String bandName = "Aerosmith";
    private GoogleSignInClient googleSignInClient;
    private ImageView imgProfile;
    private TextView nameProfile;
    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //Ação que traz os dados Default do usuário selecionado na hora do login
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        //Atribuição paraa  o objeto o valor do login recebido
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        //Chamada do método que pega os dados do usuario e atribui para as views
        pegaOsDados();

        //Ação de logout da conta
        btnLogout.setOnClickListener(v ->
                googleSignInClient.signOut().addOnCompleteListener(task -> {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        viewModel.getAlbuns(bandName);

        viewModel.getAlbumLiveData().observe(this, (List<Album> albuns) -> {
            if (albuns != null && !albuns.isEmpty()) {
                adapter.setUpdate(albuns);
            } else {
                Snackbar.make(searchView, "Album não encontrado", Snackbar.LENGTH_LONG);
                adapter.setUpdate(this.albuns);
            }

        });

        viewModel.getLoading().observe(this, (Boolean loading) -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        viewModel.getErrorAlbum().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                bandName = text;
                adapter.clear();
                viewModel.getAlbuns(bandName);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                if (text.length() > 3) {
                    bandName = text;
                    adapter.clear();
                    viewModel.getAlbuns(bandName);
                }
                return false;
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progress_bar);
        searchView = findViewById(R.id.searchView);
        adapter = new RecyclerViewAdapater(albuns);
        viewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);
        recyclerView.setAdapter(adapter);
        imgProfile = findViewById(R.id.imageProfile);
        nameProfile = findViewById(R.id.textViewNome);
        btnLogout = findViewById(R.id.buttonSair);
    }

    //Chamada do método que pega os dados do usuario e atribui para as views
    private void pegaOsDados() {
        GoogleSignInAccount googleSignInAccount = getIntent().getParcelableExtra(GOOGLE_ACCOUNT);
        Picasso.get().load(googleSignInAccount.getPhotoUrl()).centerInside().fit().into(imgProfile);
        nameProfile.setText(googleSignInAccount.getDisplayName());
    }
}

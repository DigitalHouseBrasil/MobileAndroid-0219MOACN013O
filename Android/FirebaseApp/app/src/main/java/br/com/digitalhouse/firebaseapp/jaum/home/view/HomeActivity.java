package br.com.digitalhouse.firebaseapp.jaum.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.firebase.ui.auth.AuthUI;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.jaum.adapters.RecyclerViewAdapter;
import br.com.digitalhouse.firebaseapp.jaum.favorites.view.FavoritesActivity;
import br.com.digitalhouse.firebaseapp.jaum.home.viewmodel.HomeViewModel;
import br.com.digitalhouse.firebaseapp.jaum.interfaces.FavoriteItemClick;
import br.com.digitalhouse.firebaseapp.jaum.interfaces.RecyclerViewClick;
import br.com.digitalhouse.firebaseapp.jaum.login.view.LoginActivity;
import br.com.digitalhouse.firebaseapp.jaum.login2.Login2Activity;
import br.com.digitalhouse.firebaseapp.jaum.model.Result;

public class HomeActivity extends AppCompatActivity implements RecyclerViewClick, FavoriteItemClick {

    private RecyclerView recyclerView;
    private List<Result> results = new ArrayList<>();
    private HomeViewModel viewModel;
    private ProgressBar progressBar;
    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        //recyclerView em modo Grid
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        //setando a nova lista para o adapter do recyclerView
        viewModel.buscarFilmes();
        viewModel.filmesLiveData.observe(this, results -> adapter.setResult(results));

        //mudando a visibilidade da barra de progresso de acordo com o retorno do isLoading
        viewModel.isLoading.observe(this, (Boolean loading) -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        viewModel.favoriteAdded.observe(this, result -> {
            if (result != null) {
                Snackbar.make(recyclerView, result.getTitle() + " Adicionado as favoritos", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    // Inicializa as Views
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewAdapter(results, this, this);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public void clickListener(Result result) {
        Toast.makeText(this, "ID " + result.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void removeFavoriteClickListener(Result result) {

    }

    @Override
    public void addFavoriteClickListener(Result result) {
        viewModel.salvarFavorito(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favoritos) {
            startActivity(new Intent(HomeActivity.this, FavoritesActivity.class));
            return true;
        }

        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        // TODO: fazer logout

        AuthUI.getInstance().signOut(this)
                .addOnCompleteListener(task -> {
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                });
        LoginManager.getInstance().logOut();
    }
}

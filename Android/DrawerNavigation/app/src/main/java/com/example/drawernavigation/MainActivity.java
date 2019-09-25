package com.example.drawernavigation;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    //Cria um atributo do tipo DrawerLayout
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cria uma nova instancia da toolbar e inicializa
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Inicializa o drawer
        drawer = findViewById(R.id.drawer_layout);

        //Cria uma nova instância do NavigationView e inicializa
        NavigationView navigationView = findViewById(R.id.nav_view);

        //O ActionBarDraweToggle configura o icone para abrir e fechar
        //E recebe como parametro: activity, uma instancia do drawer para vincular a actionBar da activity,
        //uma instância da Toolbar para vincular o DrawerLayout
        //e as Strings para abertura e fechamento (acessibilidade)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        //invocamos o método addDrawerListener() do DrawerLayout para conectar o ActionBarDrawerToggle no próprio DrawerLayout.
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Passa cada ID de menu como um conjunto de IDs, pois cada menu deve ser considerado como destino de nível superior.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        //Ação de clique nos itens do menu do drawerLayout e replace dos respectivos fragmentos
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Criação de uma variavel que vai receber o id do item selecionado
                int id = menuItem.getItemId();

                //Verifica se o id recebido é igual ao do layout e realiza uma ação
                if (id == R.id.nav_home){

                    //Faço o replace do fragmento de Home quando clicar no botão de Home
                    replaceFragment(new HomeFragment());

                }else if (id == R.id.nav_gallery){

                    //Faço o replace do fragmento de Galeria quando clicar no botão de Galeria
                    replaceFragment(new GaleriaFragment());

                }

                //chama a ação de close do drawerLayout e mover a gaveta para direita
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    //Sobrescrita do método da ação de voltar que verifica se a NavigationView está aberta e o botão voltar for
    //precionado fecha apenas o menu ao invés da Activity
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    //Inflar o menu superior e isso adiciona itens à barra de ação, se estiver presente.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Criação de uma variavel que vai receber o id do item selecionado
        int id = item.getItemId();

        //Verifica se o id recebido é igual ao do layout e realiza uma ação
        if (id == R.id.action_settings) {

            //Mostra um Toast
            Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Método que recebe um Fragmento e recarrega na tela
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}

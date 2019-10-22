package br.com.digitalhouse.appmytasks.views.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.views.fragments.HomeFragment;
import br.com.digitalhouse.appmytasks.views.fragments.NovaTarefaFragment;
import br.com.digitalhouse.appmytasks.views.fragments.TodasTarefasFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //TODO: recarregar o fragmento inicial da aplicação

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_add, R.id.navigation_list)
                .build();

        navView.setOnNavigationItemSelectedListener(menuItem -> {

            int id = menuItem.getItemId();

            if (id == R.id.navigation_home) {

                //TODO: recarregar o fragmento correspondente ao id

            } else if (id == R.id.navigation_add) {

                //TODO: recarregar o fragmento correspondente ao id

            } else if (id == R.id.navigation_list) {

                //TODO: recarregar o fragmento correspondente ao id
            }

            return true;
        });

    }

    //TODO: Desenvolver o método que recarrega os fragmentos

}

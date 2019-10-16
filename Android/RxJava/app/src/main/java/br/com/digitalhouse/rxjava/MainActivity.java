package br.com.digitalhouse.rxjava;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.rxjava.adapters.UsuarioRecyclerViewAdapter;
import br.com.digitalhouse.rxjava.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private List<Usuario> usuarios = new ArrayList<>();
    private UsuarioRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new UsuarioRecyclerViewAdapter(getUsuarios());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Você clicou no botão", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private List<Usuario> getUsuarios() {
        usuarios.add(new Usuario("Tairo", 31));
        usuarios.add(new Usuario("Jéssica", 17));
        usuarios.add(new Usuario("Jõao", 16));
        usuarios.add(new Usuario("Tadashi", 32));
        usuarios.add(new Usuario("Ana", 29));
        return usuarios;
    }
}

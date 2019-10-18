package br.com.digitalhouse.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.digitalhouse.rxjava.adapters.UsuarioRecyclerViewAdapter;
import br.com.digitalhouse.rxjava.model.Usuario;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private UsuarioRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new UsuarioRecyclerViewAdapter(new ArrayList<Usuario>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(view -> Snackbar.make(view, "Você clicou no botão", Snackbar.LENGTH_SHORT).show());

        // Streams
        // -- Java 8
        // -- Labdas e Streams

        // Theads
        // -- O que é
        // -- Thread de trabalho
        // -- Main Thread
        // -- runOnUiThread

        // RxJava
        // -- Observable
        // -- Operator (map, filter, flatmap)
        // -- Observer (subscribe)
        // ---- Cold/Lazy Observer
        // ---- Observable.just
        // ---- Observable.range
        // ---- Observable.fromIterable
        // ---- Observable.create


        Observable.range(0, 100)
                .map(numero -> numero * 2)
                .filter(numero -> numero == 4)
                .subscribe(integer -> {
                    System.out.println(integer);
                },throwable -> {
                    System.out.println("Error:"  + throwable.getMessage());
                });

        Observable.fromIterable(Arrays.asList("Tairo", "João"))
                .filter(nome -> nome.equals("Tairo"))
                .subscribe(n -> {
                    System.out.println(n);
                },throwable -> {
                    System.out.println("Error:"  + throwable.getMessage());
                });


        Observable.just("Tairo")
                .subscribe(n -> {
                    System.out.println(n);
                },throwable -> {
                    System.out.println("Error:"  + throwable.getMessage());
                });

        Observable<String> stringObservable = Observable.create(emitter -> {
            emitter.onNext("Tairo");
            emitter.onNext("João");
            emitter.onComplete();
        });

        stringObservable
                .map(nome-> {
                    if (nome.equals("João")){
                        nome = "Jessica";
                    }
                    return nome;
                })
                .filter(nome -> nome.equals("Jessica"))
                .subscribe(s -> {
                    // sucesso
                }, throwable -> {
                    //erro
                },() -> {
                    // completou
                });

        getUsuarios()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    // loading = true
                })
                .doAfterTerminate(() -> {
                    // loading = false
                })
                .subscribe(usuarios -> {
                    // Sucesso
                    adapter.update(usuarios);
                }, throwable -> {
                    // Erro
                    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private Observable<List<Usuario>> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Tairo", 15));
        usuarios.add(new Usuario("Jésica", 18));
        usuarios.add(new Usuario("João", 13));
        usuarios.add(new Usuario("César", 18));
        usuarios.add(new Usuario("Edney", 27));
        usuarios.add(new Usuario("Tairo", 15));
        usuarios.add(new Usuario("Tairo", 15));
        usuarios.add(new Usuario("Tairo", 15));
        usuarios.add(new Usuario("Tairo", 15));

        return  Observable.just(usuarios);
    }
}

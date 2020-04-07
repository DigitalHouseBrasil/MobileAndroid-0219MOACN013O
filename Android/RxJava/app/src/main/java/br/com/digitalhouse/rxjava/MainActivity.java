package br.com.digitalhouse.rxjava;

import android.os.Bundle;
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

        fab.setOnClickListener(view ->
                new Thread(() -> {

                }).start()
        );


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


        // Observable é um objeto que trabalha com emissão de eventos, ou seja,
        // ele emite estados em que se encontra, para que estes estados possam ser observados por outros elementos,
        // Ex: o subscribe

        // Criando um observable e fazendo o subscribe
        Observable.range(0, 100) // Emite uma sequencia de inteiros em um range especificado.
                .map(numero -> numero * 2) // mapeia cada evento emitido multiplicando seu valor por 2
                .filter(numero -> numero % 2 == 0) // filtra os eventos que tiverem valor par
                .subscribe(numero -> {
                    System.out.println(numero); // imprime no console o valor do evento que foi observado
                });


        Observable.just(1, 2) // emite 2 eventos
                .subscribe(System.out::println);

        // Emitindo eventos de erro
        Observable.error(new NullPointerException("Não pode ser nulo"));
        //.subscribe(System.out::println);

        // Emitindo eventos apartir de uma lista, e filtrando o nome
        Observable.fromIterable(Arrays.asList("Tairo", "Jessica", "João"))
                .filter(s -> s.equals("Tairo"))
                .map(s -> "Nome: " + s)
                .subscribe(System.out::println);

        // Cold/Lazy observable -> não emitem eventos enquanto não tiverem atrelado a o um subscriber
        // Ou seja se não tiver niguem observando eles, eles não fazem nada.

        // Hot observable emite os eventos assim qeu é criado
        Observable.fromIterable(Arrays.asList("Tairo", "Jessica", "Tadashi"))
                .filter(s -> s.equals("Tairo"))
                .map(s -> "Nome: " + s);


        // Forma mas clara e dinamica de criar Observables completos é usando o create
        Observable<Integer> integerObservable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            //emitter.onError(new Exception("Deu ruim !"));
            //emitter.onComplete();

            // buscar na base de dados e emintir cada item no onNext
            // Aqui poderiamos colocar try/catch e colocar um aexceção no onError
            // e depois chamar o onConplete quando acabassemos
        });


        // Subscribe apenas com onNext
        integerObservable.subscribe(integer -> {
            System.out.println(integer);
        });

        // Subscribe apenas com onNext e onError
        integerObservable.subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });

        // Subscribe apenas com onNext, onError e onComplete
        integerObservable.subscribe(integer -> {
            System.out.println(integer);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("Completou, não emite mais eventos");
        });


        /// OPERADORES -> formas de interceptar os eventos emitidos
        // filter -> filtra os eventos baseado em um condição
        // skip -> pula eventos
        // map -> maeia cada evento, podendo transformar seu valor
        // flatmap

        // Flatmap usado quando quero depois da amissão de um evento quisermos retornar um novo observable
        Observable<String> stringObservable = Observable.just("Aqui é um teste com flatmap");
        Observable.just(10)
                .flatMap(numero -> {
                    System.out.println("Nostrando o número: " + numero);
                    return stringObservable;
                })
                .subscribe(System.out::println);

        // So são executados quando há um subscribre


        // Schedulers
        Observable.just(10)
                .subscribeOn(Schedulers.io())
                .flatMap(numero -> {
                    System.out.println("Thread:" + Thread.currentThread().getName());
                    return stringObservable;
                })
                .subscribeOn(Schedulers.newThread())
                .subscribe(s -> {
                    System.out.println("Texto do numero: " + s);
                });


        //Aqui buscamos nossos usuários em um método qeu retorna um Observable com um lista de Usuario
        getUsuarios()
                .subscribeOn(Schedulers.io()) // subscribeOn, indica em que Thread será realizado o trabalho
                .observeOn(AndroidSchedulers.mainThread()) //observeOn. indica em Thread será mostrado os dados apos serem buscados/processados
                .doOnSubscribe(disposable -> { // doOnSubscribe, acontece sempre que o observable começa a emitor os eventos
                    // loading = true
                })
                .doAfterTerminate(() -> { // doAfterTerminate, acontece sempre que o Observable acabou de emitir os eventos
                    // loading = false
                })
                .subscribe(usuarios -> {
                    // Sucesso, recebe os evento emitidos pelo Observable
                    adapter.update(usuarios);
                }, throwable -> {
                    // Erro
                    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                }, () -> {
                    // Complete, completou sem erro
                });
    }

    private Observable<List<Usuario>> getUsuarios() {
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

        return Observable.just(usuarios);
    }
}

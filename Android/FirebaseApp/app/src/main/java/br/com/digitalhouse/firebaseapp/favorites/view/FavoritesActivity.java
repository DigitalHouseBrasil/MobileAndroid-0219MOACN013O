package br.com.digitalhouse.firebaseapp.favorites.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.adapters.FavoritesViewAdapter;
import br.com.digitalhouse.firebaseapp.interfaces.FavoriteItemClick;
import br.com.digitalhouse.firebaseapp.model.Result;
import br.com.digitalhouse.firebaseapp.util.AppUtil;

public class FavoritesActivity extends AppCompatActivity implements FavoriteItemClick {
    private RecyclerView recyclerView;
    private FavoritesViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new FavoritesViewAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);
        carregarFavoritos();
    }

    private void carregarFavoritos() {
        // Pegamos a instancia do firebase, objeto necessario para salvar no banco de dados
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // pegamos a referencia para onde no firebase queremos salvar nossos dados
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(this) + "/favorites");


        // Adicionamos o loistener par pegar os resultados do firebase
        reference.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Lista vazia pra pegar os resultados do firebase
                List<Result> results = new ArrayList<>();

                // Quando retornar algo do firebase percorremos os dados e colocamos na lista
                for (DataSnapshot resultSnapshot : dataSnapshot.getChildren()) {
                    Result result = resultSnapshot.getValue(Result.class);
                    results.add(result);
                }


                // por fim atualizamos o adpter com os favoritos resgatados do firebase
                adapter.update(results);
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void addFavoriteClickListener(Result result) {

    }

    @Override
    public void removeFavoriteClickListener(Result result) {

        // Pegamos a instancia do firebase, objeto necessario para salvar no banco de dados
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // pegamos a referencia para onde no firebase queremos salvar nossos dados
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(this) + "/favorites");

        // Adicionamos o listener par pegar os resultados do firebase
        reference.orderByChild("id").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Quando retornar algo do firebase percorremos os dados e colocamos na lista
                for (DataSnapshot resultSnapshot : dataSnapshot.getChildren()) {
                    Result resultFirebase = resultSnapshot.getValue(Result.class);

                    // Se acho o mesmo id removemos o item
                    if (result.getId().equals(resultFirebase.getId())) {
                        resultSnapshot.getRef().removeValue();
                        adapter.removeItem(result);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

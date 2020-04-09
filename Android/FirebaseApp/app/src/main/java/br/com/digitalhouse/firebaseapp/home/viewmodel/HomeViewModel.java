package br.com.digitalhouse.firebaseapp.home.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import br.com.digitalhouse.firebaseapp.model.Result;
import br.com.digitalhouse.firebaseapp.util.AppUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static br.com.digitalhouse.firebaseapp.network.RetrofitService.API_KEY;
import static br.com.digitalhouse.firebaseapp.network.RetrofitService.getApiService;

public class HomeViewModel extends AndroidViewModel {
    public MutableLiveData<List<Result>> filmesLiveData = new MutableLiveData<>();
    public MutableLiveData<Result> favoriteAdded = new MutableLiveData<>();
    public MutableLiveData<Throwable> resultLiveDataError = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void buscarFilmes() {

        disposable.add(
                getApiService().buscarFilmes(API_KEY, "PT-BR")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe((Disposable disposable) -> isLoading.setValue(true))
                        .doOnTerminate(() -> isLoading.setValue(false))
                        .subscribe(movieResponse ->
                                {
                                    filmesLiveData.setValue(movieResponse.getResults());
                                }
                                , throwable -> {
                                    //Se deu algum erro na requisição mostramos a mensagem de erro e carregamos o dados da base de dados
                                    resultLiveDataError.setValue(throwable);
                                })
        );
    }


    public void salvarFavorito(Result result) {
        // Pegamos a instancia do firebase, objeto necessario para salvar no banco de dados
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // pegamos a referencia para onde no firebase queremos salvar nossos dados
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(getApplication())+"/favorites");

        // criamos uma chave unica para o item, assim não haverá conflitos
        String key = reference.push().getKey();

        // setamos o item no caminho da chave criada ex: favorites/kfdhsifyadfhidf/filme
        reference.child(key).setValue(result);

        // Adicionnamos um listener pra sabermos se o item foi salvo no firebase
        reference.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Result result1 = dataSnapshot.getValue(Result.class);

                // mostamos qe foi salvo nos favoritos
                favoriteAdded.setValue(result1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Falhou ao ler valor da base do firebase
                resultLiveDataError.setValue(error.toException());
                Log.e(TAG, "Failed to read movie", error.toException());
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

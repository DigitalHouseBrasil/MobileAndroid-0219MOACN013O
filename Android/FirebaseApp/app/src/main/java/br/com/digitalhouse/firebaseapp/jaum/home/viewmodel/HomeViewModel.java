package br.com.digitalhouse.firebaseapp.jaum.home.viewmodel;

import android.app.Application;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.firebaseapp.jaum.model.Result;
import br.com.digitalhouse.firebaseapp.jaum.util.AppUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.firebaseapp.jaum.network.RetrofitService.API_KEY;
import static br.com.digitalhouse.firebaseapp.jaum.network.RetrofitService.getApiService;

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

    // TODO: Salvar filme no firebase database
    public void salvarFavorito(Result result) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(getApplication())+"/favorites");
        String key = reference.push().getKey();
        reference.child(key).setValue(result);

        reference.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Result result1 = dataSnapshot.getValue(Result.class);
                favoriteAdded.setValue(result1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                resultLiveDataError.setValue(databaseError.toException());
            }
        });

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

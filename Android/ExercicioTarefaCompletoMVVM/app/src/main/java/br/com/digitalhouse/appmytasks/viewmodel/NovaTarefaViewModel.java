package br.com.digitalhouse.appmytasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.appmytasks.model.data.Database;
import br.com.digitalhouse.appmytasks.model.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;

public class NovaTarefaViewModel extends AndroidViewModel {
    ///Atributo do tipo MutableLiveDate, lembrando que esse tipo de dado permite leitura e escrita de dados
    private MutableLiveData<Tarefa> tarefa = new MutableLiveData<>();

    //Inicialização do dao
    private TarefaDao tarefaDao = Database.getDatabase(getApplication()).tarefaDao();

    public NovaTarefaViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Tarefa> retornaTarefa() {
        return this.tarefa;
    }

    public void insereTarefa(Tarefa tarefa){
        new Thread(() -> {
            if (tarefa != null){
                tarefaDao.insert(tarefa);
            }
        }).start();

        this.tarefa.setValue(tarefa);
    }
}

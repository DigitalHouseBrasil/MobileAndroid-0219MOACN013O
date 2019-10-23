package br.com.digitalhouse.appmytasks.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.digitalhouse.appmytasks.model.Tarefa;
import io.reactivex.Observable;

@Dao
public interface TarefaDao {

    @Insert
    void insert(Tarefa tarefa);

    @Query("SELECT * FROM tarefas")
    Observable<List<Tarefa>> todasTarefas();

    @Query("SELECT * FROM tarefas ORDER BY id DESC LIMIT 5")
    Observable<List<Tarefa>> tarefasRecentes();

}

package br.com.digitalhouse.mercadolivreapp.digitalhouse.data.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Result;
import io.reactivex.Flowable;

@Dao
public interface ResultsDao {

    /**No método de insert temos o onConflict
     * onConflict: é um conjunto de estratégias de tratamento de conflitos, nesse caso estamos usando o REPLACE
     * ou seja o OnConflict irá substituir os dados antigos pelos novos e continuar a transação.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Result> results);

    @Query("Delete from result")
    void deleteAll();

    //Método que retorna uma consulta do banco com um limite de 30 itens
    @Query("Select * from result limit 30")
    Flowable<List<Result>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE
}

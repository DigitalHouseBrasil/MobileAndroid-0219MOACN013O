package br.com.digitalhouse.mercadolivreapp.digitalhouse.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Result;

/**
 * Classe DatabaseRoom que cria a conexão e a criação da base de dados local
 * nessa classe declaramos as entidades ou seja as classes que irão ser convertidas em tabelas,
 * a versão do nosso banco de ddados e o exportSchema
 * além disso se no projeto existe a classe converters para conversão de dados
 * utilizamos a anotação @TypeConverters para dizermos ao banco quem irá converter
 * os dados dentro do projeto.
 * A utilização da classe converters e da anotação @TypeConverters é opcional
 */
@Database(entities = {Result.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class) // Adicionamos os conversores
public abstract class DatabaseRoom extends RoomDatabase {

    // Criamos o DAO que será retornado
    public abstract ResultsDao resultsDAO();

    private static volatile DatabaseRoom INSTANCE;

    public static DatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseRoom.class, "mercadolivre_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

package br.com.digitalhouse.appmytasks.model.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;

@androidx.room.Database(entities = {Tarefa.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract TarefaDao tarefaDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "tarefas_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

package com.example.androidroomproject.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidroomproject.model.Produto;

//A anotação @Database determina quais são as classes anotadas como entindades, qual a versão do BD e
//se o schema do bd será exportado ou nao
@androidx.room.Database(entities = {Produto.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract ProdutoDao produtoDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "produtos_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

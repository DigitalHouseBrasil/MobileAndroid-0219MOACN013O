package br.com.digitalhouse.appmytasks.model.data;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converter {

    //Exemplo de método que pega um dado do tipo long e converte em Date
    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    //Exemplo de método que pega um dado do tipo Date e converte em long
    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }
}

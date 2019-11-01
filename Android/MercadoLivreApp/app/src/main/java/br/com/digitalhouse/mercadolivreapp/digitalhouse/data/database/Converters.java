package br.com.digitalhouse.mercadolivreapp.digitalhouse.data.database;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Address;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Attribute;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Installments;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Reviews;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Seller;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.SellerAddress;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Shipping;

/**Classe com os converters para alguns tipos de dados
 * lembrando que a classe serve para convertermos tipos de dados
 * como por exemplo converter um dado do tipo Long pata Date
 * e um dado do tipo Date para long
 * a classe converter também deve ser declarada na classe Database
 */
public class Converters {
    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }

    /// Type converter para uam lista de String
    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    @TypeConverter
    public Address fromAddress(String value) {
        Type listType = (Type) new TypeToken<Address>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromAddress(Address list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public List<Attribute> fromListAttribute(String value) {
        Type listType = (Type) new TypeToken<List<Attribute>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListAttribute(List<Attribute> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Object fromObject(String value) {
        Type listType = (Type) new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromObject(Object list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    @TypeConverter
    public Installments fromInstallments(String value) {
        Type listType = (Type) new TypeToken<Installments>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromInstallments(Installments list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Reviews fromReviews(String value) {
        Type listType = (Type) new TypeToken<Reviews>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromReviews(Reviews list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Seller fromSeller(String value) {
        Type listType = (Type) new TypeToken<Seller>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromSeller(Seller list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    @TypeConverter
    public SellerAddress fromSellerAddress(String value) {
        Type listType = (Type) new TypeToken<SellerAddress>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromSellerAddress(SellerAddress list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public Shipping fromShipping(String value) {
        Type listType = (Type) new TypeToken<Shipping>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromShipping(Shipping list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}

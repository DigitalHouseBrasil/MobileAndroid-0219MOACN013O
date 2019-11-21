package br.com.digitalhouse.firebaseapp.jaum.interfaces;

import br.com.digitalhouse.firebaseapp.jaum.model.Result;

public interface FavoriteItemClick {
    void addFavoriteClickListener(Result result);
    void removeFavoriteClickListener(Result result);
}

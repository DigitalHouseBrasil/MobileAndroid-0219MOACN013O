package br.com.digitalhouse.firebaseapp.interfaces;

import br.com.digitalhouse.firebaseapp.model.Result;

public interface FavoriteItemClick {

    void addFavoriteClickListener(Result result);
    void removeFavoriteClickListener(Result result);
}

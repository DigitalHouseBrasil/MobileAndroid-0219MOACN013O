package br.com.digitalhouse.json.model;

import java.util.List;

public class NoticiaResposta {
    private List<Noticia> noticias;

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}

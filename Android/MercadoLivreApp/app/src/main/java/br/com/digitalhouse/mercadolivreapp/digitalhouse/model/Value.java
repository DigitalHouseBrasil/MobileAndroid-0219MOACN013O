
package br.com.digitalhouse.mercadolivreapp.digitalhouse.model;

import com.google.gson.annotations.Expose;


public class Value {

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Long results;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getResults() {
        return results;
    }

    public void setResults(Long results) {
        this.results = results;
    }

}

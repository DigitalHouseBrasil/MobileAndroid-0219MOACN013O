
package br.com.digitalhouse.mercadolivreapp.digitalhouse.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Paging {

    @Expose
    private Long limit;
    @Expose
    private Long offset;
    @SerializedName("primary_results")
    private Long primaryResults;
    @Expose
    private Long total;

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getPrimaryResults() {
        return primaryResults;
    }

    public void setPrimaryResults(Long primaryResults) {
        this.primaryResults = primaryResults;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}

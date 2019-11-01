
package br.com.digitalhouse.mercadolivreapp.digitalhouse.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Installments {

    @Expose
    private Double amount;
    @SerializedName("currency_id")
    private String currencyId;
    @Expose
    private Long quantity;
    @Expose
    private Double rate;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}

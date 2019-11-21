
package br.com.digitalhouse.firebaseapp.jaum.model;


import com.google.gson.annotations.Expose;

public class Dates {

    @Expose
    private String maximum;
    @Expose
    private String minimum;

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

}

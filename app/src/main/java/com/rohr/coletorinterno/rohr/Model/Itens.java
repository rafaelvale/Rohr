package com.rohr.coletorinterno.rohr.Model;

import android.app.Activity;

import com.rohr.coletorinterno.rohr.ConfereItens;

import java.io.Serializable;

/**
 * Created by rafael.marques on 25/07/2016.
 */
public class Itens implements Serializable {

    private Integer id;
    private String description;
    private String foreignKey;
    private String peso;

    public Itens(int id, String description, String foreignkey, String peso) {
        this.id = id;
        this.description = description;
        this.foreignKey = foreignkey;
        this.peso = peso;
    }
    public Itens(){

    }

    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}

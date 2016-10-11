package com.rohr.coletorinterno.rohr.Model;

import android.app.Activity;

import com.rohr.coletorinterno.rohr.ConfereItens;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by rafael.marques on 25/07/2016.
 */
public class ItemRemessaLocacao extends Itens implements Serializable {


    private Integer idItem;
    private String description;
    private String foreignKey;
    private Integer workOrderId;
    private Float qtdeItens;
    private Float totalFaltante;
    private Activity activity;
    private Itens itens;


    public ItemRemessaLocacao(Integer idItem, Integer workOrderId, Float qtdeItens, Float totalFaltante) {
        super();

        this.idItem = idItem;
        this.workOrderId = workOrderId;
        this.qtdeItens = qtdeItens;
        this.totalFaltante = totalFaltante;

    }

    public ItemRemessaLocacao(){

    }

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getForeignKey() {
        return foreignKey;
    }

    @Override
    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Float getQtdeItens() {
        return qtdeItens;
    }

    public void setQtdeItens(Float qtdeItens) {
        this.qtdeItens = qtdeItens;
    }

    public Float getTotalFaltante() {
        return totalFaltante;
    }

    public void setTotalFaltante(Float totalFaltante) {
        this.totalFaltante = totalFaltante;
    }
}

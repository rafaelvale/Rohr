package com.rohr.coletorinterno.rohr.Model;

import java.io.Serializable;

/**
 * Created by rafael.marques on 06/09/2016.
 */
public class ItemRetornoLocacao extends Itens implements Serializable{


    private Integer WorkOrderId;
    private Integer idItem;
    private Itens itens;
    private String Description;
    private String foreignKey;

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String getForeignKey() {
        return foreignKey;
    }

    @Override
    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public ItemRetornoLocacao(int workOrderId, int idItem) {
        super();

        this.WorkOrderId = workOrderId;
        this.idItem = idItem;

    }

    public ItemRetornoLocacao(){

    }


    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Itens getItens() {
        return itens;
    }

    public void setItens(Itens itens) {
        this.itens = itens;
    }

    public Integer getWorkOrderId() {
        return WorkOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        WorkOrderId = workOrderId;
    }


}

package com.rohr.coletorinterno.rohr.Model;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rafael.marques on 25/07/2016.
 */
public class WorkOrdemConferente extends Conferente implements Serializable {

    private Conferente conferente;
    private Integer workOrderId;
    private Integer idConferente;
    private String description;
    private Integer nroOrdem;
    private String placaVeiculo;
    private String obra;
    private String cliente;
    private String WorkOrderTypeId;


    private Activity activity;


    public WorkOrdemConferente(int workOrderid, int idConferente, String description, int nroOrdem, String placaVeiculo, String obra, String cliente, String workOrderTypeId) {
        this.workOrderId = workOrderid;
        this.idConferente = idConferente;
        this.description = description;
        this.nroOrdem = nroOrdem;
        this.placaVeiculo = placaVeiculo;
        this.obra = obra;
        this.cliente = cliente;
        this.WorkOrderTypeId = workOrderTypeId;

    }

    public WorkOrdemConferente(){

    }


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    public Integer getIdConferente() { return idConferente; }

    public void setIdConferente(Integer idConferente) {this.idConferente = idConferente; }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Integer getNroOrdem() {
        return nroOrdem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkOrderTypeId() {
        return WorkOrderTypeId;
    }

    public void setWorkOrderTypeId(String workOrderTypeId) {
        WorkOrderTypeId = workOrderTypeId;
    }

    public void setNroOrdem(Integer nroOrdem) {
        this.nroOrdem = nroOrdem;
    }

    public Conferente getConferente() {
        return conferente;
    }

    public void setConferente(Conferente conferente) {
        this.conferente = conferente;
    }
}

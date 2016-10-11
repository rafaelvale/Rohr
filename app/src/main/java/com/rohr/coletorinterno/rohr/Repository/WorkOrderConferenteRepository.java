package com.rohr.coletorinterno.rohr.Repository;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.rohr.coletorinterno.rohr.Model.Conferente;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;
import com.rohr.coletorinterno.rohr.Uteis.DataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 13/09/2016.
 */
public class WorkOrderConferenteRepository {

    DataBase dataBase;

    public List<WorkOrdemConferente> SelecionaWorkOrder(){

        List<WorkOrdemConferente> works = new ArrayList<>();

        WorkOrdemConferente workOrdemConferente1 = new WorkOrdemConferente();

        workOrdemConferente1.setWorkOrderId(16666);
        workOrdemConferente1.setPlacaVeiculo("BWG4583");
        workOrdemConferente1.setIdConferente(1009474);
        workOrdemConferente1.setObra("02 021761 METRO LINHA 5 LILAS");
        workOrdemConferente1.setCliente("MENDES JUNIOR TRADING E ENGENHARIA S A");
        workOrdemConferente1.setNroOrdem(24426);
        workOrdemConferente1.setWorkOrderTypeId("DESCARGA");

        works.add(workOrdemConferente1);

        WorkOrdemConferente workOrdemConferente2 = new WorkOrdemConferente();

        workOrdemConferente2.setWorkOrderId(166674);
        workOrdemConferente2.setPlacaVeiculo("ADE5065");
        workOrdemConferente2.setIdConferente(1009474);
        workOrdemConferente2.setCliente("AFONSO FRANCA ENGENHARIA E COMERCIO LTDA");
        workOrdemConferente2.setObra("02 021940 Fibria - Forno de Cal 1");
        workOrdemConferente2.setNroOrdem(24433);
        workOrdemConferente2.setWorkOrderTypeId("CARGA");

        works.add(workOrdemConferente2);



        return works;


    }


    public WorkOrderConferenteRepository(Context context) {

        dataBase = new DataBase(context);
    }

    /**Atualizar um registro existente na base**/
    public void AtualizarWorkOrdem(WorkOrdemConferente workOrdemConferente){

    }

    /**Consulta uma OS cadastrada na base**/
    public List<WorkOrdemConferente> PuxaWorkOrdem(int codigo) {

        List<WorkOrdemConferente> ListWorkOrdemConferente = new ArrayList<>();

        Cursor cursor = dataBase.GetBuscaDataBase().query("workOrdensConferente",null, "idConferente = ?", new String[]{String.valueOf(codigo)}, null, null, null);

        cursor.moveToFirst();

        WorkOrdemConferente workOrdemConferente;


        while(!cursor.isAfterLast()) {

            workOrdemConferente = new WorkOrdemConferente();


            Log.d("IdListView", cursor.getString(cursor.getColumnIndex("IdConferente")));
            Log.d("PlacaVeiculoListView", cursor.getString(cursor.getColumnIndex("placaVeiculo")));
            Log.d("ObraListView", cursor.getString(cursor.getColumnIndex("obra")));
            Log.d("WorkOrderIdListView", cursor.getString(cursor.getColumnIndex("workOrderId")));


            workOrdemConferente.setPlacaVeiculo(cursor.getString(cursor.getColumnIndex("placaVeiculo")));
            workOrdemConferente.setObra(cursor.getString(cursor.getColumnIndex("obra")));
            workOrdemConferente.setCliente(cursor.getString(cursor.getColumnIndex("cliente")));
            workOrdemConferente.setWorkOrderTypeId(cursor.getString(cursor.getColumnIndex("workOrderTypeId")));
            workOrdemConferente.setNroOrdem(cursor.getInt(cursor.getColumnIndex("nroOrdem")));
            workOrdemConferente.setWorkOrderId(cursor.getInt(cursor.getColumnIndex("workOrderId")));


            ListWorkOrdemConferente.add(workOrdemConferente);


            cursor.moveToNext();
        }

        return ListWorkOrdemConferente;
    }

}

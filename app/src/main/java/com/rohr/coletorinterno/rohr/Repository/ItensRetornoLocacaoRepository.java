package com.rohr.coletorinterno.rohr.Repository;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.ItemRetornoLocacao;
import com.rohr.coletorinterno.rohr.Model.Itens;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;
import com.rohr.coletorinterno.rohr.Uteis.DataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 13/09/2016.
 */
public class ItensRetornoLocacaoRepository {


    DataBase dataBase;

    public List<ItemRetornoLocacao> SelecionaitemRetorno(){

        List<ItemRetornoLocacao> itemRetorno = new ArrayList<>();

        ItemRetornoLocacao itemRetornoLocacao1 = new ItemRetornoLocacao();

        itemRetornoLocacao1.setWorkOrderId(16666);
        itemRetornoLocacao1.setIdItem(55653);
        itemRetornoLocacao1.setForeignKey("FFAGEV30");
        itemRetornoLocacao1.setDescription("FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA");


        itemRetorno.add(itemRetornoLocacao1);


        ItemRetornoLocacao itemRetornoLocacao2 = new ItemRetornoLocacao();

        itemRetornoLocacao2.setWorkOrderId(16666);
        itemRetornoLocacao2.setIdItem(55655);
        itemRetornoLocacao2.setForeignKey("FFALINES");
        itemRetornoLocacao2.setDescription("FFALINES - ALINHADOR ESTRIBO - FFA");

        itemRetorno.add(itemRetornoLocacao2);


        ItemRetornoLocacao itemRetornoLocacao3 = new ItemRetornoLocacao();

        itemRetornoLocacao3.setWorkOrderId(16666);
        itemRetornoLocacao3.setIdItem(55721);
        itemRetornoLocacao3.setForeignKey("FFCANPIL");
        itemRetornoLocacao3.setDescription("FFCANPIL - CANTONEIRA FIXA P/ PILAR - FFA");

        itemRetorno.add(itemRetornoLocacao3);


        ItemRetornoLocacao itemRetornoLocacao4 = new ItemRetornoLocacao();

        itemRetornoLocacao4.setWorkOrderId(16666);
        itemRetornoLocacao4.setIdItem(55646);
        itemRetornoLocacao4.setForeignKey("FFCUNPIN");
        itemRetornoLocacao4.setDescription("FFCUNPIN - CUNHA P/ PINO - FFA");

        itemRetorno.add(itemRetornoLocacao4);


        ItemRetornoLocacao itemRetornoLocacao5 = new ItemRetornoLocacao();

        itemRetornoLocacao5.setWorkOrderId(16666);
        itemRetornoLocacao5.setIdItem(55660);
        itemRetornoLocacao5.setForeignKey("FFAGEV30");
        itemRetornoLocacao5.setDescription("FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA");

        itemRetorno.add(itemRetornoLocacao5);


        ItemRetornoLocacao itemRetornoLocacao6 = new ItemRetornoLocacao();

        itemRetornoLocacao6.setWorkOrderId(16666);
        itemRetornoLocacao6.setIdItem(55639);
        itemRetornoLocacao6.setForeignKey("FFESC2-4");
        itemRetornoLocacao6.setDescription("FFESC2-4 - ESCORA H= 2,5 - 4,5 M - FFA");

        itemRetorno.add(itemRetornoLocacao6);


        ItemRetornoLocacao itemRetornoLocacao7 = new ItemRetornoLocacao();

        itemRetornoLocacao7.setWorkOrderId(16666);
        itemRetornoLocacao7.setIdItem(55659);
        itemRetornoLocacao7.setForeignKey("FFAGEV30");
        itemRetornoLocacao7.setDescription("FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA");

        itemRetorno.add(itemRetornoLocacao7);


        ItemRetornoLocacao itemRetornoLocacao8 = new ItemRetornoLocacao();

        itemRetornoLocacao8.setWorkOrderId(16666);
        itemRetornoLocacao8.setIdItem(55638);
        itemRetornoLocacao8.setForeignKey("FFESC4-6");
        itemRetornoLocacao8.setDescription("FFESC4-6 - ESCORA H= 4 - 6.5 M - FFA");

        itemRetorno.add(itemRetornoLocacao8);


        ItemRetornoLocacao itemRetornoLocacao9 = new ItemRetornoLocacao();

        itemRetornoLocacao9.setWorkOrderId(16666);
        itemRetornoLocacao9.setIdItem(55637);
        itemRetornoLocacao9.setForeignKey("FFGRAUNI");
        itemRetornoLocacao9.setDescription("FFGRAUNI - GRAMPO UNIVERSAL - FFA");

        itemRetorno.add(itemRetornoLocacao9);


        ItemRetornoLocacao itemRetornoLocacao10 = new ItemRetornoLocacao();

        itemRetornoLocacao10.setWorkOrderId(16666);
        itemRetornoLocacao10.setIdItem(55640);
        itemRetornoLocacao10.setForeignKey("FFMONAND");
        itemRetornoLocacao10.setDescription("FFMONAND - MONTANTE P/ ANDAIME DE TRABALHO - FFA");

        itemRetorno.add(itemRetornoLocacao10);


        ItemRetornoLocacao itemRetornoLocacao11 = new ItemRetornoLocacao();

        itemRetornoLocacao11.setWorkOrderId(16666);
        itemRetornoLocacao11.setIdItem(55612);
        itemRetornoLocacao11.setForeignKey("FFAGEV30");
        itemRetornoLocacao11.setDescription("FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA");

        itemRetorno.add(itemRetornoLocacao11);


        ItemRetornoLocacao itemRetornoLocacao12 = new ItemRetornoLocacao();

        itemRetornoLocacao12.setWorkOrderId(16666);
        itemRetornoLocacao12.setIdItem(55615);
        itemRetornoLocacao12.setForeignKey("FFP15030");
        itemRetornoLocacao12.setDescription("FFP15030 - PAINEL MANUAL DE 150 X 30 CM - FFA");

        itemRetorno.add(itemRetornoLocacao12);


        ItemRetornoLocacao itemRetornoLocacao13 = new ItemRetornoLocacao();

        itemRetornoLocacao13.setWorkOrderId(16666);
        itemRetornoLocacao13.setIdItem(55616);
        itemRetornoLocacao13.setForeignKey("FFP15055");
        itemRetornoLocacao13.setDescription("FFP15055 - PAINEL MANUAL DE 150 X 55 CM - FFA");

        itemRetorno.add(itemRetornoLocacao13);


        ItemRetornoLocacao itemRetornoLocacao15 = new ItemRetornoLocacao();

        itemRetornoLocacao15.setWorkOrderId(16666);
        itemRetornoLocacao15.setIdItem(55618);
        itemRetornoLocacao15.setForeignKey("FFP15070");
        itemRetornoLocacao15.setDescription("FFP15070 - PAINEL MANUAL DE 150 X 70 CM - FFA");

        itemRetorno.add(itemRetornoLocacao15);


        ItemRetornoLocacao itemRetornoLocacao16 = new ItemRetornoLocacao();

        itemRetornoLocacao16.setWorkOrderId(16666);
        itemRetornoLocacao16.setIdItem(55620);
        itemRetornoLocacao16.setForeignKey("FFP15080");
        itemRetornoLocacao16.setDescription("FFP15080 - PAINEL MANUAL DE 150 X 80 CM - FFA");

        itemRetorno.add(itemRetornoLocacao16);


        ItemRetornoLocacao itemRetornoLocacao17 = new ItemRetornoLocacao();

        itemRetornoLocacao17.setWorkOrderId(16666);
        itemRetornoLocacao17.setIdItem(55621);
        itemRetornoLocacao17.setForeignKey("FFP15090");
        itemRetornoLocacao17.setDescription("FFP15090 - PAINEL MANUAL DE 150 X 90 CM - FFA");

        itemRetorno.add(itemRetornoLocacao17);


        ItemRetornoLocacao itemRetornoLocacao18 = new ItemRetornoLocacao();

        itemRetornoLocacao18.setWorkOrderId(16666);
        itemRetornoLocacao18.setIdItem(55623);
        itemRetornoLocacao18.setForeignKey("FFP15120");
        itemRetornoLocacao18.setDescription("FFP15120 - PAINEL MANUAL DE 150 X 120 CM - FFA");

        itemRetorno.add(itemRetornoLocacao18);




        return itemRetorno;


    }



    public ItensRetornoLocacaoRepository(Context context) {

        dataBase = new DataBase(context);
    }

    /**Atualizar um registro existente na base**/
    public void AtualizarItensRetorno (ItemRetornoLocacao itemRetornoLocacao){

    }

    public List<ItemRetornoLocacao> buscaIdItem(int codigo){

        List<ItemRetornoLocacao> listRetorno = new ArrayList<>();

        Cursor cursor = dataBase.GetBuscaDataBase().query("itensRetornoLocacao", null, "workOrderId = ?", new String[]{String.valueOf(codigo)} , null, null, null);

        cursor.moveToFirst();
        ItemRetornoLocacao itemRetornoLocacao;


        while (!cursor.isAfterLast()){

            itemRetornoLocacao = new ItemRetornoLocacao();

            Log.d("IDITEMPARAITENS", cursor.getString(cursor.getColumnIndex("idItem")));
            Log.d("foreignkeyPARAITENS", cursor.getString(cursor.getColumnIndex("foreignkey")));
            Log.d("descriptionPARAITENS", cursor.getString(cursor.getColumnIndex("description")));


            itemRetornoLocacao.setForeignKey(cursor.getString(cursor.getColumnIndex("foreignkey")));
            itemRetornoLocacao.setDescription(cursor.getString(cursor.getColumnIndex("description")));



            listRetorno.add(itemRetornoLocacao);

            cursor.moveToNext();
        }

        return listRetorno;
    }

}

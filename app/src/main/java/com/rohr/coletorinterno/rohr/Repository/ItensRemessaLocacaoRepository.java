package com.rohr.coletorinterno.rohr.Repository;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.ItemRetornoLocacao;
import com.rohr.coletorinterno.rohr.Uteis.DataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 13/09/2016.
 */
public class ItensRemessaLocacaoRepository {

    DataBase dataBase;


    public List<ItemRemessaLocacao> SelecionaitemRemessa() {


        List<ItemRemessaLocacao> itemRemessa = new ArrayList<>();

        ItemRemessaLocacao itemRemessaLocacao1 = new ItemRemessaLocacao();

        itemRemessaLocacao1.setWorkOrderId(166674);
        itemRemessaLocacao1.setDescription("ETT150G - TRAPEZIO H= 1,00 X L= 1,50 M");
        itemRemessaLocacao1.setForeignKey("ETT150G");
        itemRemessaLocacao1.setQtdeItens(200f);
        itemRemessaLocacao1.setTotalFaltante(0f);

        itemRemessa.add(itemRemessaLocacao1);

        ItemRemessaLocacao itemRemessaLocacao2 = new ItemRemessaLocacao();

        itemRemessaLocacao2.setWorkOrderId(166674);
        itemRemessaLocacao2.setDescription("VI07300 - VIGA METALICA - H= 0,075 X  L= 3,00 M");
        itemRemessaLocacao2.setForeignKey("VI07300");
        itemRemessaLocacao2.setQtdeItens(32.0f);
        itemRemessaLocacao2.setTotalFaltante(0f);

        itemRemessa.add(itemRemessaLocacao2);

        ItemRemessaLocacao itemRemessaLocacao3 = new ItemRemessaLocacao();

        itemRemessaLocacao3.setWorkOrderId(166674);

        itemRemessaLocacao3.setDescription("VI07200 - VIGA METALICA - H= 0,075 X  L= 2,00 M");
        itemRemessaLocacao3.setForeignKey("VI07200");
        itemRemessaLocacao3.setQtdeItens(550.0f);
        itemRemessaLocacao3.setTotalFaltante(0f);

        itemRemessa.add(itemRemessaLocacao3);

        return itemRemessa;


    }

    public ItensRemessaLocacaoRepository(Context context) {

        dataBase = new DataBase(context);
    }

    /**Atualizar um registro existente na base**/
    public void AtualizarItensRemessa(ItemRemessaLocacao itemRemessaLocacao){
    }

    /**Consulta uma carga na Base**/

    public List<ItemRemessaLocacao> buscaIdItem(int codigo){

        List<ItemRemessaLocacao> listRemessa = new ArrayList<>();

        Cursor cursor = dataBase.GetBuscaDataBase().query("itemRemessaLocacao", null, "workOrderId = ?", new String[]{String.valueOf(codigo)}, null, null, null);


        cursor.moveToFirst();
        ItemRemessaLocacao itemRemessaLocacao;

        while(cursor.moveToNext()) {

            itemRemessaLocacao = new ItemRemessaLocacao();


            itemRemessaLocacao.setIdItem(cursor.getInt(cursor.getColumnIndex("idItem")));
            itemRemessaLocacao.setDescription(cursor.getString(cursor.getColumnIndex("description")));
            itemRemessaLocacao.setForeignKey(cursor.getString(cursor.getColumnIndex("foreignkey")));
            itemRemessaLocacao.setQtdeItens(cursor.getFloat(cursor.getColumnIndex("qtdeItens")));
            itemRemessaLocacao.setTotalFaltante(cursor.getFloat(cursor.getColumnIndex("totalFaltante")));


            listRemessa.add(itemRemessaLocacao);

        }
        return listRemessa;
    }

}

package com.rohr.coletorinterno.rohr.Repository;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.rohr.coletorinterno.rohr.Model.Conferente;
//import com.rohr.coletorinterno.rohr.Uteis.DataBase;
import com.rohr.coletorinterno.rohr.WebService.WSGetConferentes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 13/09/2016.
 */
//public class ConferentesRepository {
//
//    //DataBase dataBase;
//    WSGetConferentes wsGetConferentes;

    //public ConferentesRepository(Context context) {
//        dataBase = new DataBase(context);
//    }
//
//       /**Atualizar um registro existente na base**/
//    public void AtualizarConferente(Conferente conferente){
//
//
//        wsGetConferentes.WSGetConferentes();
//    }

    /**Consulta uma pessoa cadastrada pelo title**/

//    public Conferente validarLogin(String id){
//
//        Cursor cursor = dataBase.GetBuscaDataBase().query("conferentes", null, "title = ?", new String[]{String.valueOf(id)} , null, null, null);
//
//        Conferente conferente = new Conferente();
//
//        while (cursor.moveToNext()) {
//            Log.d("RepositorioFirstname", cursor.getString(cursor.getColumnIndex("firstname")));
//            Log.d("RepositorioIdConferente", cursor.getString(cursor.getColumnIndex("id")));
//
//            conferente.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            conferente.setFirstName(cursor.getString(cursor.getColumnIndex("firstname")));
//            conferente.setLastName(cursor.getString(cursor.getColumnIndex("lastname")));
//            conferente.setTitle(cursor.getString(cursor.getColumnIndex("title")));
//            conferente.setNotes(cursor.getString(cursor.getColumnIndex("notes")));
//            conferente.setCargo(cursor.getInt(cursor.getColumnIndex("cargo")));
//        }
//        return conferente;
//    }
//}

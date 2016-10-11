package com.rohr.coletorinterno.rohr.Uteis;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.rohr.coletorinterno.rohr.Model.Conferente;
import com.rohr.coletorinterno.rohr.Model.Itens;
import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.ItemRetornoLocacao;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 16/09/2016.
 */
public class DataBase extends SQLiteOpenHelper {


    private static String DB_PATH = "";
    private static String DB_NAME = "coletor";
    private static String TABLE_CONFERENTES = "conferentes";
    private static String TABLE_ITENS = "itens";
    private static String TABLE_REMESSA = "itensRemessaLocacao";
    private static String TABLE_RETORNO = "itensRetornoLocacao";
    private static String TABLE_WORKORDENSCONFERENTES = "workOrdensConferente";

    private final Context context;
    private SQLiteDatabase db;




    public DataBase(Context context) {
        super(context, DB_NAME, null, 3);

        if(Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
           else{
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.context = context;


    }


    public void create() throws IOException{
        boolean dbExist = checkDataBase();
        if(dbExist){
        }else{
            this.getReadableDatabase();
            try{
                copyDataBase();
            }catch (IOException e){
                throw new Error ("Erro ao Copiar Banco de Dados");
            }
        }
    }


    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try{
            String path = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }


    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;

        OutputStream myOutPut = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0){
            myOutPut.write(buffer, 0, length);
        }
        myOutPut.flush();
        myOutPut.close();
        myInput.close();
    }

    public boolean Open(){
        try{
            String myPath = DB_PATH + DB_NAME;
            db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            return true;
        }catch (SQLException sqle){
            db = null;
            return false;
        }
    }

    @Override
    public synchronized void close(){
        if(db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Conferente> getconferentes(){
        List<Conferente> conferentes = new ArrayList<>();

        try {
            String query = "SELECT * FROM "+ TABLE_CONFERENTES;
            SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()){
                int id = Integer.parseInt(cursor.getString(0));
                String firstname = cursor.getString(1);
                String lastname = cursor.getString(2);
                String title = cursor.getString(3);
                String notes = cursor.getString(4);
                int cargo = Integer.parseInt(cursor.getString(5));

                Conferente getConferentes = new Conferente(id, firstname, lastname, notes, title, cargo);
                conferentes.add(getConferentes);
            }
        }catch (Exception e ){
            Log.d("DB", e.getMessage());
        }
        return conferentes;
    }
    public List<Itens> getItens(){
        List<Itens> itens = new ArrayList<>();

        try {
            String query = "SELECT * FROM " + TABLE_ITENS;
            SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
            Cursor cursor = db.rawQuery(query, null);

            while(cursor.moveToNext()){

                int id = Integer.parseInt(cursor.getString(0));
                String description = cursor.getString(1);
                String foreignkey = cursor.getString(2);
                String peso = cursor.getString(3);

                Itens getItensModel = new Itens(id, description, foreignkey, peso);

                itens.add(getItensModel);
            }
        }catch (Exception e){
            Log.d("DB", e.getMessage());
        }
        return itens;
    }

    public List<ItemRemessaLocacao> getItensRemessa(){


        List<ItemRemessaLocacao> itensRemessa = new ArrayList<>();

        try {
            String query = "SELECT * FROM " + TABLE_REMESSA;
            SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()){

                int idItem = Integer.parseInt(cursor.getString(0));
                int workOrderId = Integer.parseInt(cursor.getString(1));
                float qtdeItens = Float.valueOf(cursor.getString(2));
                float totalFaltante = Float.valueOf(cursor.getString(3));

                ItemRemessaLocacao getItensRemessaLocacao = new ItemRemessaLocacao(idItem, workOrderId, qtdeItens, totalFaltante);

                itensRemessa.add(getItensRemessaLocacao);
            }
        }catch (Exception e ){
            Log.d("DB", e.getMessage());
        }
        return itensRemessa;
    }

    public List<ItemRetornoLocacao> getItensRetornoLocacao(){
        List<ItemRetornoLocacao> itensRetorno = new ArrayList<>();

        try {
            String query = "SELECT * FROM " + TABLE_RETORNO;
            SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()){
                int idItem = Integer.parseInt(cursor.getString(0));
                int workOrderId = Integer.parseInt(cursor.getString(1));

                ItemRetornoLocacao getItensRetorno = new ItemRetornoLocacao(workOrderId,idItem);

                itensRetorno.add(getItensRetorno);

            }
        }catch (Exception e){
            Log.d("DB", e.getMessage());
        }
        return itensRetorno;
    }
    public List<WorkOrdemConferente> getWorkOrdens(){
        List<WorkOrdemConferente> workOrdensConferente = new ArrayList<>();

        try {
            String query = "SELECT * FROM "+ TABLE_WORKORDENSCONFERENTES;
            SQLiteDatabase db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()){
                int workOrderid = Integer.parseInt(cursor.getString(0));
                int idConferente = Integer.parseInt(cursor.getString(1));
                String description = cursor.getString(2);
                int nroOrdem = Integer.parseInt(cursor.getString(3));
                String placaVeiculo = cursor.getString(4);
                String obra = cursor.getString(5);
                String cliente = cursor.getString(6);
                String workOrderTypeId = cursor.getString(7);

                WorkOrdemConferente getWorkOrdensConferentes = new WorkOrdemConferente(workOrderid, idConferente, description, nroOrdem, placaVeiculo, obra, cliente, workOrderTypeId);

                workOrdensConferente.add(getWorkOrdensConferentes);
            }
        }catch (Exception e){
            Log.d("DB", e.getMessage());
        }
        return workOrdensConferente;
    }


    /**Metodo para executar a rotina no banco de dados**/
    public SQLiteDatabase GetConexaoDataBase(){
        return this.getWritableDatabase();
    }
    public SQLiteDatabase GetBuscaDataBase(){

        return this.getReadableDatabase();
    }



}

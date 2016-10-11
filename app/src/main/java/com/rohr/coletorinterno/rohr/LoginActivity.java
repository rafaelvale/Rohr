package com.rohr.coletorinterno.rohr;


import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rohr.coletorinterno.rohr.LoginBO.LoginBO;
import com.rohr.coletorinterno.rohr.Model.Conferente;
import com.rohr.coletorinterno.rohr.Model.Itens;
import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.ItemRetornoLocacao;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;
//import com.rohr.coletorinterno.rohr.Repository.ConferentesRepository;
//import com.rohr.coletorinterno.rohr.Uteis.DataBase;
import com.rohr.coletorinterno.rohr.Uteis.LinhaOrdemAdapter;
import com.rohr.coletorinterno.rohr.WebService.WSGetConferentes;
import com.rohr.coletorinterno.rohr.WebService.WSGetWorkOrdensConferente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends AppCompatActivity {


    EditText EdtTitle;
    Button btnLogin;
    public LoginBO loginBO;
    public List<Conferente> conferentes;
    public List<Itens> itens;
    public List<ItemRemessaLocacao> itensRemessa;
    public List<ItemRetornoLocacao> itensRetorno;
    public List<WorkOrdemConferente> workOrdensConferente;




    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    private TextView formatTxt, contentTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginBO = new LoginBO(this);

        EdtTitle = (EditText) findViewById(R.id.Title);
        contentTxt = (TextView) findViewById(R.id.scan_content);
        btnLogin = (Button) findViewById(R.id.btnLogin);

//
//        conferentes = getconferentes();
//        itens = getItens();
//        itensRemessa = getItensRemessa();
//        itensRetorno = getItensRetornoLocacao();
//        workOrdensConferente = getWorkOrdens();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Title = EdtTitle.getText().toString();


                Conferente conferente = new Conferente();
                conferente.setActivity(LoginActivity.this);
                conferente.setEdtTitle(EdtTitle);
                conferente.setTitle(Title);
//
//                ConferentesRepository conferentesRepository = new ConferentesRepository(LoginActivity.this);
//                conferente = conferentesRepository.validarLogin(Title);
                boolean isValido = loginBO.validarCamposLogin(conferente);
                if (isValido) {
                    Intent UsuarioLogado = new Intent(LoginActivity.this, PrincipalActivity.class);
                    startActivity(UsuarioLogado);

                    Toast.makeText(getApplicationContext(), "Bem Vindo, Virgilio", Toast.LENGTH_SHORT).show();

//                    UsuarioLogado.putExtra("firstname", conferente.getFirstName());
//                    UsuarioLogado.putExtra("id", conferente.getId());
//                    startActivity(UsuarioLogado);
                }

            }
        });

        WSGetWorkOrdensConferente wsGetWorkOrdensConferente = new WSGetWorkOrdensConferente();

        Boolean workOrdemConferentes = wsGetWorkOrdensConferente.WSGetWorkOrdensConferente(1009474);

        wsGetWorkOrdensConferente.WSGetWorkOrdensConferente(1009474);

        Log.d("WSWORKORDERCONFERENTE", String.valueOf(workOrdemConferentes));
    }


//    private List<Conferente> getconferentes(){
//        List<Conferente> conferentes = new ArrayList<>();
//
//        DataBase db = new DataBase(getApplicationContext());
//        try {
//            db.create();
//        } catch (IOException ioe) {
//            throw new Error("Impossivel Criar Banco de dados");
//        }
//
//        if (db.Open()) {
//            conferentes = db.getconferentes();
//        }
//
//        return conferentes;
//    }
//    private List<Itens> getItens(){
//        List<Itens> itens = new ArrayList<>();
//
//        DataBase db = new DataBase(getApplicationContext());
//
//        try {
//            db.create();
//        } catch (IOException ioe) {
//            throw new Error("Impossivel Criar Banco de dados");
//        }
//
//        if (db.Open()) {
//            itens = db.getItens();
//        }
//
//        return itens;
//    }
//    private List<ItemRemessaLocacao> getItensRemessa() {
//
//        List<ItemRemessaLocacao> RemessaLocacao = new ArrayList<>();
//
//        DataBase db = new DataBase(getApplicationContext());
//
//        try {
//            db.create();
//        } catch (IOException ioe) {
//            throw new Error("Impossivel Criar Banco de dados");
//        }
//
//        if(db.Open()){
//            RemessaLocacao = db.getItensRemessa();
//        }
//
//
//        return RemessaLocacao;
//
//    }
//    private List<ItemRetornoLocacao> getItensRetornoLocacao(){
//        List<ItemRetornoLocacao> itensRetorno = new ArrayList<>();;
//
//        DataBase db = new DataBase(getApplicationContext());
//
//        try {
//            db.create();
//        } catch (IOException ioe) {
//            throw new Error("Impossivel Criar Banco de dados");
//        }
//
//        if (db.Open()) {
//            itensRetorno = db.getItensRetornoLocacao();
//        }
//
//        return itensRetorno;
//    }
//    private List<WorkOrdemConferente> getWorkOrdens(){
//        List<WorkOrdemConferente> workOrdensConferente = new ArrayList<>();
//
//        DataBase db = new DataBase(getApplicationContext());
//
//        try {
//            db.create();
//        } catch (IOException ioe) {
//            throw new Error("Impossivel Criar Banco de dados");
//        }
//
//        if (db.Open()) {
//            workOrdensConferente = db.getWorkOrdens();
//        }
//
//        return workOrdensConferente;
//    }


    //Codigo de barras
    public void scanBar(View v) {
        try {
            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            showDialog(LoginActivity.this,"No Scanner Found", "Download a scanner code activity?","Yes", "No").show();
        }
    }



    //alert dialog for downloadDialog
    private static AlertDialog showDialog(final AppCompatActivity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:” + “com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }

    //on ActivityResult method
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                //get the extras that are returned from the intent
                String contents = intent.getStringExtra("SCAN_RESULT ");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT ");
                formatTxt.setText("FORMAT: " + format);
                contentTxt.setText("CONTENT: " + contents);
                Toast toast = Toast.makeText(this, "Leitura" + contents + "Formato:" + format, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }


}

package com.rohr.coletorinterno.rohr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rohr.coletorinterno.rohr.Model.Conferente;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;
//import com.rohr.coletorinterno.rohr.Repository.WorkOrderConferenteRepository;
import com.rohr.coletorinterno.rohr.Repository.WorkOrderConferenteRepository;
import com.rohr.coletorinterno.rohr.Uteis.LinhaOrdemAdapter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    TextView dataAtual;
    TextView firstName;
    ListView ListViewOrdens;


    private LinhaOrdemAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        dataAtual = (TextView) findViewById(R.id.dataAtual);
        firstName = (TextView) findViewById(R.id.FirstName);
        ListViewOrdens = (ListView) findViewById(R.id.listViewPessoas);


        String currentDateTimeString = DateFormat.getDateInstance().format((new Date()));
        dataAtual.setText(String.valueOf(currentDateTimeString));

        firstName.setText("Virgilio");

        WorkOrderConferenteRepository workOrderConferenteRepository = new WorkOrderConferenteRepository(this);
        final List<WorkOrdemConferente> works = workOrderConferenteRepository.SelecionaWorkOrder();

        ListViewOrdens.setAdapter(new LinhaOrdemAdapter(this, works));


        ListViewOrdens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(String.valueOf(works.get(position).getWorkOrderTypeId()) == "CARGA") {
                    Intent intent = new Intent(PrincipalActivity.this, ConfereItens.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(PrincipalActivity.this, DescargaItens.class);
                    startActivity(intent);
                }
            }
        });


//        Intent TelaLogin = getIntent();
//
//        final String Nome = TelaLogin.getStringExtra("firstname");
//        int idConferente = getIntent().getExtras().getInt("id");
//
////        firstName.setText(Nome);
////        String resultado = "Bem vindo, "+ Nome ;
//
//        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
//
//        Log.d("IDNATELAPASSADA", String.valueOf(idConferente));
//        Log.d("FIRSTNAMENATELAPASSADA", Nome);
//
//        final WorkOrdemConferente workOrdemConferente = new WorkOrdemConferente();
//        workOrdemConferente.setActivity(PrincipalActivity.this);
//        workOrdemConferente.setIdConferente(idConferente);
//
//        Conferente conferente = new Conferente();
//        conferente.setFirstName(Nome);

//        WorkOrderConferenteRepository workOrderConferenteRepository = new WorkOrderConferenteRepository(PrincipalActivity.this);
//        final List<WorkOrdemConferente>  listWorkOrdem = workOrderConferenteRepository.PuxaWorkOrdem(idConferente);
//
//
//        adapter = new LinhaOrdemAdapter(this, listWorkOrdem);
//
//        ListViewOrdens.setAdapter(adapter);
//
//
//            ListViewOrdens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                    if(String.valueOf(listWorkOrdem.get(position).getWorkOrderTypeId()) == "3") {
//
//                        Intent intent = new Intent(PrincipalActivity.this, ConfereItens.class);
//                        intent.putExtra("firstname", Nome);
//                        intent.putExtra("Placa", listWorkOrdem.get(position).getPlacaVeiculo());
//                        intent.putExtra("OS", String.valueOf(listWorkOrdem.get(position).getNroOrdem()));
//                        intent.putExtra("workOrderId", String.valueOf(listWorkOrdem.get(position).getWorkOrderId()));
//                        startActivity(intent);
//                    }else{
//
//                        Intent intent = new Intent(PrincipalActivity.this, DescargaItens.class);
//                        intent.putExtra("firstname", Nome);
//                        intent.putExtra("Placa", listWorkOrdem.get(position).getPlacaVeiculo());
//                        intent.putExtra("OS", String.valueOf(listWorkOrdem.get(position).getNroOrdem()));
//                        intent.putExtra("workOrderId", String.valueOf(listWorkOrdem.get(position).getWorkOrderId()));
//                        startActivity(intent);
//
//                    }
//
//                }
//            });
    }

    //botão voltar desativado
    @Override
    public void onBackPressed() {

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

        switch (item.getItemId()) {
            case android.R.id.home:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(PrincipalActivity.this);
                alertDialog.setTitle("Sair do seu Login?");
                alertDialog.setMessage("Você realmente deseja fazer o Logout?");

                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "Usuário deslogado...", Toast.LENGTH_LONG).show();

                    }
                });
                alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Ok,vamos ao trabalho...", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                alertDialog.show();


                break;
            default:
                break;
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

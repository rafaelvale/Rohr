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

import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.Itens;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;
//import com.rohr.coletorinterno.rohr.Repository.ItensRemessaLocacaoRepository;
//import com.rohr.coletorinterno.rohr.Repository.ItensRepository;
//import com.rohr.coletorinterno.rohr.Repository.ItensRetornoLocacaoRepository;
import com.rohr.coletorinterno.rohr.Repository.ItensRemessaLocacaoRepository;
import com.rohr.coletorinterno.rohr.Uteis.LinhaItensAdapter;

import java.util.List;


public class ConfereItens extends AppCompatActivity{


    Button btnAlterarItem;
    Button btnEncerraCarga;
    TextView Placa;
    TextView Os;
    TextView FirstName;
    ListView ListViewItens;

    private LinhaItensAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confere_itens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btnAlterarItem = (Button)findViewById(R.id.btn_altera_item);
        btnEncerraCarga = (Button)findViewById(R.id.BtnEncerraCarga);
        Placa = (TextView) findViewById(R.id.Placa);
        Os = (TextView) findViewById(R.id.OS);
        ListViewItens = (ListView) findViewById(R.id.listViewItens);
        FirstName = (TextView)findViewById(R.id.FirstName);

        Intent TelaConferencia = getIntent();

//        String Nome = TelaConferencia.getStringExtra("firstname");
//        String PlacaVeiculo = TelaConferencia.getStringExtra("Placa");
//        String os = TelaConferencia.getStringExtra("OS");
//        String workOderId = TelaConferencia.getStringExtra("workOrderId");

        FirstName.setText("VIRGILIO");
        Os.setText("24433");
        Placa.setText("ADE5065");

        ItemRemessaLocacao itemRemessaLocacao = new ItemRemessaLocacao();
        itemRemessaLocacao.setActivity(ConfereItens.this);
        itemRemessaLocacao.setWorkOrderId(Integer.valueOf("166674"));

        ItensRemessaLocacaoRepository itensRemessaLocacaoRepository = new ItensRemessaLocacaoRepository(ConfereItens.this);

        List<ItemRemessaLocacao> listItemRemessa = itensRemessaLocacaoRepository.SelecionaitemRemessa();

        ListViewItens.setAdapter(new LinhaItensAdapter(this, listItemRemessa));


//        adapter = new LinhaItensAdapter(this, listItemRemessa);

//        ListViewItens.setAdapter(adapter);

     }


    //botão voltar desativado
    @Override
    public void onBackPressed() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_confereitens, menu);
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

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ConfereItens.this);
                alertDialog.setTitle("Sair desta Ordem de Serviço?");
                alertDialog.setMessage("Você realmente deseja sair?");

                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(ConfereItens.this, PrincipalActivity.class);
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

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


    //botão com mudança de tela para alterar Item da OS
    public void alteracao(View view) {

        Intent intent = new Intent(this, AlteraItem.class);
        startActivity(intent);
    }
    //botao com mudança de tela para finalizar a carga/descarga
    public void FinalizarOS(View view) {

        Intent intent = new Intent(this, Conferencia.class);
        startActivity(intent);
    }

}

package com.rohr.coletorinterno.rohr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Repository.ItensRemessaLocacaoRepository;
import com.rohr.coletorinterno.rohr.Uteis.LinhaItensAdapter;

import java.io.FileOutputStream;
import java.util.List;

public class Conferencia extends AppCompatActivity {

    TextView Placa;
    TextView Os;
    TextView FirstName;
    EditText supervisor;
    Button btnEncerraCarga;
    ListView linhaItensConferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Placa = (TextView) findViewById(R.id.Placa);
        Os = (TextView) findViewById(R.id.OS);
        FirstName = (TextView) findViewById(R.id.FirstName);
        supervisor = (EditText) findViewById(R.id.txtSupervisor);
        btnEncerraCarga = (Button) findViewById(R.id.BtnEncerraCarga);
        linhaItensConferencia = (ListView) findViewById(R.id.Conferencia_itens);

        FirstName.setText("VIRGILIO");
        Os.setText("24433");
        Placa.setText("ADE5065");

        ItemRemessaLocacao itemRemessaLocacao = new ItemRemessaLocacao();
        itemRemessaLocacao.setActivity(Conferencia.this);
        itemRemessaLocacao.setWorkOrderId(Integer.valueOf("166674"));

        ItensRemessaLocacaoRepository itensRemessaLocacaoRepository = new ItensRemessaLocacaoRepository(Conferencia.this);

        List<ItemRemessaLocacao> listItemRemessa = itensRemessaLocacaoRepository.SelecionaitemRemessa();

        linhaItensConferencia.setAdapter(new LinhaItensAdapter(this, listItemRemessa));

    }

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


        switch (item.getItemId()){
            case android.R.id.home:

                Intent intent = new Intent(Conferencia.this, ConfereItens.class);
                startActivity(intent);

                finish();
                break;
            default:break;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

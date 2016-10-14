package com.rohr.coletorinterno.rohr;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.FloatRange;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.ItemRetornoLocacao;
import com.rohr.coletorinterno.rohr.Model.Itens;
//import com.rohr.coletorinterno.rohr.Repository.ItensRepository;
//import com.rohr.coletorinterno.rohr.Repository.ItensRetornoLocacaoRepository;
import com.rohr.coletorinterno.rohr.Repository.ItensRetornoLocacaoRepository;
import com.rohr.coletorinterno.rohr.Uteis.LinhaDescargaAdapter;
import com.rohr.coletorinterno.rohr.Uteis.LinhaItensAdapter;

import java.util.List;

public class DescargaItens extends AppCompatActivity {


    private ProgressDialog progressDialog;

    Button btnEncerraDescarga;
    Button btnInsereDescarga;
    Button btnConfirmaDescarga;
    EditText descBom;
    EditText descLimpeza;
    EditText descDanificado;
    EditText descInutilizado;
    TextView qtdeDescarga;
    TextView Placa;
    TextView Os;
    ListView ListViewDescarga;
    TextView FirstName;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_descarga_itens);
          Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);

          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          getSupportActionBar().setHomeButtonEnabled(true);

          btnConfirmaDescarga = (Button) findViewById(R.id.btnConfirmaDescarga);
          btnEncerraDescarga = (Button) findViewById(R.id.BtnEncerraDescarga);
          btnInsereDescarga = (Button) findViewById(R.id.btnInsereDescarga);
          descBom = (EditText) findViewById(R.id.descBom);
          descLimpeza = (EditText) findViewById(R.id.descLimpeza);
          descDanificado = (EditText) findViewById(R.id.descDanificado);
          descInutilizado = (EditText) findViewById(R.id.descInutilizado);
          Placa = (TextView) findViewById(R.id.Placa);
          Os = (TextView) findViewById(R.id.OS);
          FirstName = (TextView) findViewById(R.id.FirstName);


          Intent TelaConferencia = getIntent();
//
//        String Nome = TelaConferencia.getStringExtra("firstname");
//        String PlacaVeiculo = TelaConferencia.getStringExtra("Placa");
//        String os = TelaConferencia.getStringExtra("OS");
//        String workOderId = TelaConferencia.getStringExtra("workOrderId");

          FirstName.setText("VIRGILIO");
          Os.setText("24426");
          Placa.setText("BWG4583");

          ItemRetornoLocacao itemRetornoLocacao = new ItemRetornoLocacao();
          itemRetornoLocacao.setActivity(DescargaItens.this);
          itemRetornoLocacao.setWorkOrderId(Integer.valueOf("166666"));

          ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ITEMS);
          final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.lista_itens);

          textView.setAdapter(adapter);

          btnConfirmaDescarga.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  final Handler handle = new Handler(){
                      @Override
                      public void handleMessage(Message msg) {
                          super.handleMessage(msg);
                          progressDialog.incrementProgressBy(5);
                      }
                  };
                  progressDialog = new ProgressDialog(DescargaItens.this);
                  progressDialog.setMax(100);
                  progressDialog.setMessage("Descarregando Item...");
                  progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                  progressDialog.show();

                  new Thread(new Runnable() {
                      @Override
                      public void run() {
                          try {
                              while (progressDialog.getProgress() <= progressDialog.getMax()){
                                  Thread.sleep(100);
                                  handle.sendMessage(handle.obtainMessage());
                                  if(progressDialog.getProgress() == progressDialog.getMax()){
                                      progressDialog.dismiss();
                                  }
                              }
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }).start();

                  textView.getText().clear();
                  descBom.getText().clear();
                  descLimpeza.getText().clear();
                  descDanificado.getText().clear();
                  descInutilizado.getText().clear();
              }
          });

          ItensRetornoLocacaoRepository itensRetornoLocacaoRepository = new ItensRetornoLocacaoRepository(this);
          final List<ItemRetornoLocacao> itemRetorno = itensRetornoLocacaoRepository.SelecionaitemRetorno();

////        ItensRetornoLocacaoRepository itensRetornoLocacaoRepository = new ItensRetornoLocacaoRepository(DescargaItens.this);
////        List<ItemRetornoLocacao> listItemRetorno = itensRetornoLocacaoRepository.buscaIdItem(Integer.parseInt(workOderId));
//
//        Log.d("valorDescarga", String.valueOf(listItemRetorno));
//
//        adapter = new LinhaDescargaAdapter(this, listItemRetorno);
//        ListViewDescarga.setAdapter(adapter);
      }

    private static final String[] ITEMS = new String[]{

            "FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA",
            "FFALINES - ALINHADOR ESTRIBO - FFA",
            "FFCANPIL - CANTONEIRA FIXA P/ PILAR - FFA",
            "FFCUNPIN - CUNHA P/ PINO - FFA",
            "FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA",
            "FFESC2-4 - ESCORA H= 2,5 - 4,5 M - FFA",
            "FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA",
            "FFESC4-6 - ESCORA H= 4 - 6.5 M - FFA",
            "FFGRAUNI - GRAMPO UNIVERSAL - FFA",
            "FFMONAND - MONTANTE P/ ANDAIME DE TRABALHO - FFA",
            "FFAGEV30 - ANGULO EXTERNO VARIAVEL L= 300 - FFA",
            "FFP15030 - PAINEL MANUAL DE 150 X 30 CM - FFA",
            "FFP15055 - PAINEL MANUAL DE 150 X 55 CM - FFA",
            "FFP15070 - PAINEL MANUAL DE 150 X 70 CM - FFA",
            "FFP15080 - PAINEL MANUAL DE 150 X 80 CM - FFA",
            "FFP15090 - PAINEL MANUAL DE 150 X 90 CM - FFA",
            "FFP15120 - PAINEL MANUAL DE 150 X 120 CM - FFA"
    };


    @Override
    public void onBackPressed(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_descargaitens, menu);
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

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DescargaItens.this);
                alertDialog.setTitle("Sair desta Ordem de Serviço?");
                alertDialog.setMessage("Você realmente deseja sair?");

                alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(DescargaItens.this, PrincipalActivity.class);
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
    public void incluiItem (View view) {

        Intent intent = new Intent(this, IncluirItem.class);
        startActivity(intent);
    }
    //botao com mudança de tela para finalizar a carga/descarga
    public void FinalizarDescarga(View view) {

        Intent intent = new Intent(this, ConferenciaDescarga.class);
        startActivity(intent);
    }
}

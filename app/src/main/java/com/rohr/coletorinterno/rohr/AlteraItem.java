package com.rohr.coletorinterno.rohr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class AlteraItem extends AppCompatActivity implements View.OnClickListener {

    Button btn_altera_item;
    Button btn_item_incluso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btn_altera_item = (Button)findViewById(R.id.btn_altera_item);

        btn_altera_item.setOnClickListener(this);
    //implementação do autocomplete para digitação e visualização do item que será alterado na OS
        AutoCompleteTextView edtSubstitui = (AutoCompleteTextView)findViewById(R.id.item_substitui);
        AutoCompleteTextView edtIncluir = (AutoCompleteTextView)findViewById(R.id.item_incluso);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        adapter.add("KITA170");
        adapter.add("TU250");
        adapter.add("TU600");
        adapter.add("KITRV240");
        adapter.add("TU300");
        adapter.add("SYINMC19");
        adapter.add("SYINFIBG");
        adapter.add("SYINEE20");
        adapter.add("SYINEE08");
        adapter.add("SYINEE07");
        adapter.add("SYINSUPT");
        adapter.add("SYINCH23");
        adapter.add("SYINCH08");
        adapter.add("SYINCH07");
        adapter.add("MAT1100");
        adapter.add("SYINCH01");
        adapter.add("SYINCH00");
        adapter.add("SYINAVPT");
        adapter.add("SPEFPLAT");
        adapter.add("SPA40");
        adapter.add("SP7/8008");
        adapter.add("SP5/8005");
        adapter.add("SP2275RP");
        adapter.add("SP1/2010");
        adapter.add("SP11/409");
        adapter.add("SP10313");
        adapter.add("SCR3CX52");
        adapter.add("SCR3CX50");
        adapter.add("CE250150");
        adapter.add("CE70X200");
        adapter.add("CEBABACH");
        adapter.add("CEBABAVE");
        adapter.add("CEBABAXT");
        adapter.add("TUACOPER");
        adapter.add("TUABROME");
        adapter.add("COCA251");
        adapter.add("COCA254");
        adapter.add("COCAAZU");
        adapter.add("COTL2TON");
        adapter.add("FRMARRE4");
        adapter.add("COCAMAR");
        adapter.add("COCAOURO");
        adapter.add("COCAPRE");
        adapter.add("FRMARRE3");
        adapter.add("COCLSP");
        adapter.add("COCAVERD");
        adapter.add("FRCHF1/4");
        adapter.add("FRCHCH22");
        adapter.add("FRCBF347");
        adapter.add("FRCALL14");
        adapter.add("FRCALL12");
        adapter.add("FRCALL11");
        adapter.add("FRCALL09");
        adapter.add("COCSNMON");
        adapter.add("FRCALL07");
        adapter.add("FRCADE45");
        adapter.add("ETCRUZET");
        adapter.add("COCRUZCT");
        adapter.add("FRCADE40");
        adapter.add("COCX010");
        adapter.add("COTELLUS");
        adapter.add("COCX015");
        adapter.add("COCX025");
        adapter.add("COCX050");
        adapter.add("PLPOS102");
        adapter.add("COESM04D");
        adapter.add("COESM07D");
        adapter.add("COESM09D");
        adapter.add("FLESTALA");
        adapter.add("COESTROS");
        adapter.add("COFIMR05");
        adapter.add("FLESTFIX");
        adapter.add("COCAEROP");
        adapter.add("COGME");
        adapter.add("COGMFG");
        adapter.add("SYINROLC");
        adapter.add("COGMPFGA");
        adapter.add("COGMR05");
        adapter.add("COGMR10");
        adapter.add("COGRUNVI");
        adapter.add("COLAMH");
        adapter.add("COLINOLE");
        adapter.add("COLNAMA");
        adapter.add("COLNAZU");
        adapter.add("COLNBRA");
        adapter.add("COLNCIZ");
        adapter.add("COLO3X6");
        adapter.add("COP33030");
        adapter.add("COPAMOIT");
        adapter.add("COPATESC");
        adapter.add("COPATESD");
        adapter.add("COPATESE");
        adapter.add("CEBAVERT");
        adapter.add("SYINP180");
        adapter.add("COREFL");
        adapter.add("COSG100");
        adapter.add("COSG150");
        adapter.add("COSGRAV");
        adapter.add("TUPQLCOM");
        adapter.add("TUCTPORC");
        adapter.add("TUPACCOM");
        adapter.add("SZINM20E");
        adapter.add("SZINM19E");
        adapter.add("COTE100");
        adapter.add("COTE1142");
        adapter.add("COTE130");
        adapter.add("COTE150");
        adapter.add("COTE160");
        adapter.add("COTE180");
        adapter.add("COTE200");
        adapter.add("COTE230");
        adapter.add("COTE250");
        adapter.add("COTE260");
        adapter.add("COTE280");
        adapter.add("COTE300");
        adapter.add("COTE325");
        adapter.add("COTE350");
        adapter.add("COTE360");
        adapter.add("COTE400");
        adapter.add("COTE420");
        adapter.add("COTE450");
        adapter.add("COTE460");
        adapter.add("COTE500");
        adapter.add("COTE508");
        adapter.add("COTE550");
        adapter.add("COTE575");
        adapter.add("COTE600");
        adapter.add("COTE650");
        adapter.add("COTE680");
        adapter.add("COTE700");
        adapter.add("COTGALM");
        adapter.add("COTL100");
        adapter.add("COTL200");
        adapter.add("COTLTEL");
        adapter.add("TU010");
        adapter.add("TU015");
        adapter.add("TU020");
        adapter.add("TU025");
        adapter.add("TU030");
        adapter.add("TU035");
        adapter.add("TU040");
        adapter.add("TU045");
        adapter.add("COTU75U");
        adapter.add("COTUSOU");
        adapter.add("DIPN1010");
        adapter.add("DIPP0303");
        adapter.add("DIPP0707");
        adapter.add("DIPP1010");
        adapter.add("DIPP1515");
        adapter.add("DIPP2020");
        adapter.add("DIPP3030");
        adapter.add("DIPP4010");
        adapter.add("DIPP4040");
        adapter.add("ESFORC");
        adapter.add("ESSUSUP");
        adapter.add("ESTIPOA");
        adapter.add("ESTIPOB");
        adapter.add("ESTIPOC");
        adapter.add("ESUTBEA");
        adapter.add("ESUTBEB");
        adapter.add("ESUTBEC");
        adapter.add("ESUFETA");
        adapter.add("ESUFETB");
        adapter.add("ESUFETC");
        adapter.add("ESXCOPO");
        adapter.add("ESXPSTE");
        adapter.add("ETDH1010");
        adapter.add("ETDH1015");
        adapter.add("ETDH1515");
        adapter.add("ETFE2M");
        adapter.add("ETME");
        adapter.add("ETMFE");
        adapter.add("ETPBE");
        adapter.add("ETPTE");
        adapter.add("ETRTE");
        adapter.add("ETT100G");
        adapter.add("ETT100P");
        adapter.add("ETT150G");
        adapter.add("ETT150P");
        adapter.add("ETTRA100");
        adapter.add("ETTRA150");
        adapter.add("FAESCAD");
        adapter.add("FAM100");
        adapter.add("FAQL100");
        adapter.add("FAQL150");
        adapter.add("FAQL200");
        adapter.add("FAQL250");
        adapter.add("FAQL300");
        adapter.add("FAQV200");
        adapter.add("FASCARRE");
        adapter.add("FATA");
        adapter.add("FATL100");
        adapter.add("FATL150");
        adapter.add("FATL200");
        adapter.add("FATL250");
        adapter.add("FATL300");
        adapter.add("FLRLBALI");
        adapter.add("FLRLBS13");
        adapter.add("FLRLBS20");
        adapter.add("FLRLBS30");
        adapter.add("FLRLBS50");
        adapter.add("VI07300");
        adapter.add("VI07200");


        edtSubstitui.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);


        edtIncluir.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
    }

    //botão para efetivação da troca do material
    @Override
    public void onClick(View v) {

        Intent itemAlterado = new Intent(this, ConfereItens.class);
        startActivity(itemAlterado);

        Toast.makeText(getApplicationContext(), "Item alterado com sucesso!", Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alteraitem, menu);
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

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(AlteraItem.this);
        alertDialog.setTitle("Não terá novo item?");
        alertDialog.setMessage("Deseja sair sem salvar o novo item?");

        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(AlteraItem.this, ConfereItens.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Item não foi alterado!", Toast.LENGTH_LONG).show();

            }
        });
        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Ok, altere o item que deseja.", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialog.show();

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

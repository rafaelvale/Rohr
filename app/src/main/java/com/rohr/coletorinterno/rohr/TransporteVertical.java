package com.rohr.coletorinterno.rohr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TransporteVertical extends AppCompatActivity {


    TextView placa;
    TextView OS;
    TextView Firstname ;
    Button foto;
    Button btnFimQuesti ;
    ListView ListViewCheckList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_vertical);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }


}

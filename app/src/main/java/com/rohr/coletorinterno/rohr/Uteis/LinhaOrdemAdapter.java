package com.rohr.coletorinterno.rohr.Uteis;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.rohr.coletorinterno.rohr.ConfereItens;
import com.rohr.coletorinterno.rohr.DescargaItens;
import com.rohr.coletorinterno.rohr.Model.Conferente;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;
import com.rohr.coletorinterno.rohr.PrincipalActivity;
import com.rohr.coletorinterno.rohr.R;
import com.rohr.coletorinterno.rohr.Repository.WorkOrderConferenteRepository;
//import com.rohr.coletorinterno.rohr.Repository.ConferentesRepository;
//import com.rohr.coletorinterno.rohr.Repository.WorkOrderConferenteRepository;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 29/07/2016.
 */
public class LinhaOrdemAdapter extends BaseAdapter{

    private static LayoutInflater layoutInflater = null;
    List<WorkOrdemConferente> workOrdemConferentes = new ArrayList<>();

    WorkOrderConferenteRepository workOrderConferenteRepository;

    private PrincipalActivity principalActivity;

    public LinhaOrdemAdapter(PrincipalActivity principalActivity, List<WorkOrdemConferente> workOrdemConferentes){
        this.workOrdemConferentes = workOrdemConferentes;
        this.principalActivity = principalActivity;
        this.layoutInflater     = (LayoutInflater) this.principalActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.workOrderConferenteRepository = new WorkOrderConferenteRepository(principalActivity);
    }

    @Override
    public int getCount() {
        return workOrdemConferentes.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinhaLista = layoutInflater.inflate(R.layout.activity_linha_ordem, null);

        TextView TextViewPlaca = (TextView) viewLinhaLista.findViewById(R.id.textViewPlaca);
        TextView textViewNomeCliente = (TextView) viewLinhaLista.findViewById(R.id.textViewNomeCliente);
        TextView textViewNomeObra = (TextView) viewLinhaLista.findViewById(R.id.textViewNomeObra);
        TextView textViewOS = (TextView) viewLinhaLista.findViewById(R.id.textViewOS);
        TextView textViewTipoOs = (TextView) viewLinhaLista.findViewById(R.id.textViewTipoOs);


        TextViewPlaca.setText(String.valueOf(workOrdemConferentes.get(position).getPlacaVeiculo()));
        textViewNomeCliente.setText(String.valueOf(workOrdemConferentes.get(position).getCliente()));
        textViewNomeObra.setText(String.valueOf(workOrdemConferentes.get(position).getObra()));
        textViewOS.setText(String.valueOf(workOrdemConferentes.get(position).getNroOrdem()));
        textViewTipoOs.setText(String.valueOf(workOrdemConferentes.get(position).getWorkOrderTypeId()));

//        if(textViewTipoOs.getText().toString() == "3"){
//            textViewTipoOs.setText("CARGA");
//            btnEditar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intentRedirecionar = new Intent(principalActivity, ConfereItens.class);
//                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    principalActivity.startActivity(intentRedirecionar);
//                    principalActivity.finish();
//                }
//            });
//            TextViewPlaca.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intentRedirecionar = new Intent(principalActivity, ConfereItens.class);
//                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    principalActivity.startActivity(intentRedirecionar);
//                    principalActivity.finish();
//                }
//            });
//        }else{
//            textViewTipoOs.setText("DESCARGA");
//            btnEditar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intentRedirecionar = new Intent(principalActivity, DescargaItens.class);
//                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    principalActivity.startActivity(intentRedirecionar);
//                    principalActivity.finish();
//                }
//            });
//            TextViewPlaca.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intentRedirecionar = new Intent(principalActivity, DescargaItens.class);
//                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    principalActivity.startActivity(intentRedirecionar);
//                    principalActivity.finish();
//                }
//            });
//        }


        return viewLinhaLista;
    }

//
//    private PrincipalActivity principalActivity;
//
//    public LinhaOrdemAdapter(PrincipalActivity principalActivity, List<WorkOrdemConferente> lista){
//        super(principalActivity, 0, lista);
//
//
//    }
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//
//        View viewLinhaLista = convertView;
//        if(viewLinhaLista == null ) {
//            viewLinhaLista = LayoutInflater.from(getContext()).inflate(R.layout.activity_linha_ordem, null);
//        }
//        final WorkOrdemConferente workOrdemConferentes = getItem(position);
//
//        TextView TextViewPlaca = (TextView) viewLinhaLista.findViewById(R.id.textViewPlaca);
//        TextView textViewNomeCliente = (TextView) viewLinhaLista.findViewById(R.id.textViewNomeCliente);
//        TextView textViewNomeObra = (TextView) viewLinhaLista.findViewById(R.id.textViewNomeObra);
//        TextView textViewOS = (TextView) viewLinhaLista.findViewById(R.id.textViewOS);
//        TextView textViewTipoOs = (TextView) viewLinhaLista.findViewById(R.id.textViewTipoOs);
//        Button btnEditar = (Button) viewLinhaLista.findViewById(R.id.btnConferir);
//
//
//        TextViewPlaca.setText(String.valueOf(workOrdemConferentes.getPlacaVeiculo()));
//        textViewNomeCliente.setText(String.valueOf(workOrdemConferentes.getCliente()));
//        textViewNomeObra.setText(String.valueOf(workOrdemConferentes.getObra()));
//        textViewOS.setText(String.valueOf(workOrdemConferentes.getNroOrdem()));
//        textViewTipoOs.setText(String.valueOf(workOrdemConferentes.getWorkOrderTypeId()));
////
////
//        if(textViewTipoOs.getText().toString() == "3"){
//            textViewTipoOs.setText("CARGA");
////            btnEditar.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////
////
////                    Intent intentRedirecionar = new Intent(principalActivity, ConfereItens.class);
////                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                    intentRedirecionar.putExtra("placa", workOrdemConferentes.getPlacaVeiculo());
////                    intentRedirecionar.putExtra("WorkOrderId", workOrdemConferentes.getWorkOrderId());
////
////
////                    principalActivity.startActivity(intentRedirecionar);
////                    principalActivity.finish();
////
////                }
////            });
////
////            TextViewPlaca.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////
////                    Intent intentRedirecionar = new Intent(principalActivity, ConfereItens.class);
////                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                    intentRedirecionar.putExtra("placa", workOrdemConferentes.getPlacaVeiculo());
////                    intentRedirecionar.putExtra("WorkOrderId", workOrdemConferentes.getWorkOrderId());
////
////
////
////                    principalActivity.startActivity(intentRedirecionar);
////                    principalActivity.finish();
////                }
////            });
//        }else{
//            textViewTipoOs.setText("DESCARGA");
////
////            btnEditar.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////
////
////                    Intent intentRedirecionar = new Intent(principalActivity, DescargaItens.class);
////                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                    intentRedirecionar.putExtra("placa", workOrdemConferentes.getPlacaVeiculo());
////                    intentRedirecionar.putExtra("WorkOrderId", workOrdemConferentes.getWorkOrderId());
////
////
////                    principalActivity.startActivity(intentRedirecionar);
////                    principalActivity.finish();
////
////                }
////            });
////
////            TextViewPlaca.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////
////                    Intent intentRedirecionar = new Intent(principalActivity, DescargaItens.class);
////                    intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                    intentRedirecionar.putExtra("placa", workOrdemConferentes.getPlacaVeiculo());
////                    intentRedirecionar.putExtra("WorkOrderId", workOrdemConferentes.getWorkOrderId());
////
////
////
////                    principalActivity.startActivity(intentRedirecionar);
////                    principalActivity.finish();
////                }
////            });
//        }
////
//
//        return viewLinhaLista;
//    }
}

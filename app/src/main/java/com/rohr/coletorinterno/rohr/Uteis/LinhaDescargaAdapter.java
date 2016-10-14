package com.rohr.coletorinterno.rohr.Uteis;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rohr.coletorinterno.rohr.ConferenciaDescarga;
import com.rohr.coletorinterno.rohr.DescargaItens;
import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.ItemRetornoLocacao;
import com.rohr.coletorinterno.rohr.Model.Itens;
import com.rohr.coletorinterno.rohr.R;
import com.rohr.coletorinterno.rohr.Repository.ItensRetornoLocacaoRepository;
//import com.rohr.coletorinterno.rohr.Repository.ItensRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 16/08/2016.
 */
public class LinhaDescargaAdapter extends BaseAdapter {

    private static LayoutInflater layoutInflater = null;

    List<ItemRetornoLocacao> itemRetornoLocacao  = new ArrayList<>();

    ItensRetornoLocacaoRepository itensRetornoLocacaoRepository;

    private ConferenciaDescarga conferenciaDescarga;


    public LinhaDescargaAdapter(ConferenciaDescarga conferenciaDescarga, List<ItemRetornoLocacao> itemRetornoLocacao) {

        this.conferenciaDescarga = conferenciaDescarga;
        this.itemRetornoLocacao = itemRetornoLocacao;
        this.layoutInflater     = (LayoutInflater) this.conferenciaDescarga.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itensRetornoLocacaoRepository = new ItensRetornoLocacaoRepository(conferenciaDescarga);
    }

    @Override
    public int getCount() {
        return itemRetornoLocacao.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View viewDescargaItens = layoutInflater.inflate(R.layout.activity_conferencia_descarga, null);

        TextView item = (TextView)viewDescargaItens.findViewById(R.id.textItem);
        final TextView intDescarga = (TextView)viewDescargaItens.findViewById(R.id.intDescarga);

        return viewDescargaItens;
    }

//        public LinhaDescargaAdapter(DescargaItens descargaItens, List<ItemRetornoLocacao> listItemRetorno) {
//        super(descargaItens,0,  listItemRetorno);
//    }
//
//
//    @Override
//    public View getView(final int position, final View convertView, ViewGroup parent) {
//
//        View viewDescargaItens = convertView;
//        if(viewDescargaItens == null){
//           viewDescargaItens = LayoutInflater.from(getContext()).inflate(R.layout.activity_linha_descarga, null);
//        }
//
//        final ItemRetornoLocacao itemRetornoLocacao = getItem(position);
//
//        TextView textForeignKey = (TextView)viewDescargaItens.findViewById(R.id.textForeignKeyDesc);
//        TextView textDescription = (TextView)viewDescargaItens.findViewById(R.id.textDescriptionDesc);
////        TextView intDescarga = (TextView)viewDescargaItens.findViewById(R.id.intDescarga);
////        Button btnFimDescarga = (Button)viewDescargaItens.findViewById(R.id.btnFimDescarga);
//
//        textForeignKey.setText(String.valueOf(itemRetornoLocacao.getForeignKey()));
//        textDescription.setText(String.valueOf(itemRetornoLocacao.getDescription()));
////
////        intDescarga.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                LayoutInflater layoutInflater = LayoutInflater.from(descargaItens);
////                View view = layoutInflater.inflate(R.layout.alert_descarga_activity, null);
////                AlertDialog.Builder alertDialog = new AlertDialog.Builder(descargaItens);
////                alertDialog.setView(view);
////
////                TextView MostraItem = (TextView)view.findViewById(R.id.MostraItem);
////                final EditText descBom = (EditText)view.findViewById(R.id.descBom);
////                final EditText descLimpeza = (EditText)view.findViewById(R.id.descLimpeza);
////                final EditText descDanificado = (EditText)view.findViewById(R.id.descDanificado);
////                final EditText descInutilizado = (EditText)view.findViewById(R.id.descInutilizado);
////
////                MostraItem.setText(String.valueOf(itemRetornoLocacao.getForeignKey()));
////
////
////                alertDialog
////                        .setCancelable(false)
////                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialog, int which) {
////
////                                Float parcial;
////                                Float resBom = Float.valueOf(descBom.getText().toString());
////                                Float resLimpeza = Float.valueOf(descLimpeza.getText().toString());
////                                Float resDanificado = Float.valueOf(descDanificado.getText().toString());
////                                Float resInutilizado = Float.valueOf(descInutilizado.getText().toString());
////
////
//                                parcial = (resBom + resLimpeza + resDanificado + resInutilizado);
//                            }
//                        })
//
//                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                dialog.cancel();
//                            }
//                        });
//                AlertDialog alertDialogAndroid = alertDialog.create();
//                alertDialogAndroid.show();
//            }
//        });
//
//        return viewDescargaItens;
//    }
}

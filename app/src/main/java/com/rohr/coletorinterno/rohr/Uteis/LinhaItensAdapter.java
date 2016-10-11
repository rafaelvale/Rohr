package com.rohr.coletorinterno.rohr.Uteis;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rohr.coletorinterno.rohr.ConfereItens;
import com.rohr.coletorinterno.rohr.DescargaItens;
import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.Model.ItemRetornoLocacao;
import com.rohr.coletorinterno.rohr.Model.Itens;
import com.rohr.coletorinterno.rohr.Model.WorkOrdemConferente;
import com.rohr.coletorinterno.rohr.R;
import com.rohr.coletorinterno.rohr.Repository.ItensRemessaLocacaoRepository;
//import com.rohr.coletorinterno.rohr.Repository.ItensRemessaLocacaoRepository;
//import com.rohr.coletorinterno.rohr.Repository.ItensRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 02/08/2016.
 */
public class LinhaItensAdapter extends BaseAdapter{

    private static LayoutInflater layoutInflater = null;

    List<ItemRemessaLocacao> itemRemessaLocacao  = new ArrayList<>();

    ItensRemessaLocacaoRepository itensRemessaLocacaoRepository;

    private ConfereItens confereItens;

    public LinhaItensAdapter(ConfereItens confereItens, List<ItemRemessaLocacao> itemRemessaLocacao) {

        this.confereItens = confereItens;
        this.itemRemessaLocacao = itemRemessaLocacao;
        this.layoutInflater     = (LayoutInflater) this.confereItens.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itensRemessaLocacaoRepository = new ItensRemessaLocacaoRepository(confereItens);
    }

    @Override
    public int getCount() {
        return itemRemessaLocacao.size();
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
        View viewLinhaItens = layoutInflater.inflate(R.layout.activity_linha_itens, null);

        TextView textForeignKey = (TextView)viewLinhaItens.findViewById(R.id.textForeignKey);
        TextView intSaldo = (TextView)viewLinhaItens.findViewById(R.id.intTotal);
        final TextView totalFaltante = (TextView) viewLinhaItens.findViewById(R.id.Quantity);
        //final TextView amais = (TextView) viewLinhaItens.findViewById(R.id.Quantity2);
        //Button ConferirItem = (Button)viewLinhaItens.findViewById(R.id.btnConferir);




        textForeignKey.setText(String.valueOf(itemRemessaLocacao.get(position).getForeignKey()));
        intSaldo.setText(String.valueOf(itemRemessaLocacao.get(position).getQtdeItens()));
        totalFaltante.setText(String.valueOf(itemRemessaLocacao.get(position).getTotalFaltante()));


        viewLinhaItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(confereItens);
                View view = layoutInflater.inflate(R.layout.alert_quantidade_activity, null);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(confereItens);

                alertDialog.setView(view);
                TextView foreignKey = (TextView)view.findViewById(R.id.textForeignKey);
                final TextView intSaldo = (TextView)view.findViewById(R.id.intTotal);
                final EditText qtdeCarregada = (EditText) view.findViewById(R.id.QtdCarregada);

                foreignKey.setText(String.valueOf(itemRemessaLocacao.get(position).getDescription()));
                intSaldo.setText(String.valueOf(itemRemessaLocacao.get(position).getQtdeItens()));

                alertDialog
                        .setCancelable(false)
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Float Resultado = Float.parseFloat(intSaldo.getText().toString());
                                Float carregado = Float.parseFloat(qtdeCarregada.getText().toString());



                                        Resultado = Resultado - carregado;

                                        totalFaltante.setText(String.valueOf(carregado));
                                        intSaldo.setText(String.valueOf(Resultado));



                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialogAndroid = alertDialog.create();
                alertDialogAndroid.show();



            }
        });


        return viewLinhaItens;
    }

//    public LinhaItensAdapter(ConfereItens confereItens, List<ItemRemessaLocacao> listItemRemessa) {
//        super(confereItens,0, listItemRemessa);
//    }
//
//
//
//    @Override
//    public View getView(final int position, final View convertView, final ViewGroup parent) {
//        View viewLinhaItens = convertView;
//        if(viewLinhaItens == null){
//            viewLinhaItens = LayoutInflater.from(getContext()).inflate(R.layout.activity_linha_itens, null);
//        }
//
//
//        ItemRemessaLocacao itemRemessaLocacao = getItem(position);
//
//
//        TextView IdItem = (TextView)viewLinhaItens.findViewById(R.id.textItem);
//        TextView textForeignKey = (TextView)viewLinhaItens.findViewById(R.id.textForeignKey);
//        TextView Description = (TextView)viewLinhaItens.findViewById(R.id.textDescription);
//        TextView intSaldo = (TextView)viewLinhaItens.findViewById(R.id.intTotal);
//        TextView totalFaltante = (TextView) viewLinhaItens.findViewById(R.id.Quantity);
//       // Button ConferirItem = (Button)viewLinhaItens.findViewById(R.id.btnConferir);
//
//
//        IdItem.setText(String.valueOf(itemRemessaLocacao.getId()));
//        textForeignKey.setText(String.valueOf(itemRemessaLocacao.getForeignKey()));
//        Description.setText(String.valueOf(itemRemessaLocacao.getDescription()));
//        intSaldo.setText(String.valueOf(itemRemessaLocacao.getQtdeItens()));
//        totalFaltante.setText(String.valueOf(itemRemessaLocacao.getTotalFaltante()));
//
//
//
//
//        return viewLinhaItens;
//    }
}

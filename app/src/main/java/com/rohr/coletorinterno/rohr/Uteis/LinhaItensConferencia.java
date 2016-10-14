package com.rohr.coletorinterno.rohr.Uteis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rohr.coletorinterno.rohr.Conferencia;
import com.rohr.coletorinterno.rohr.Model.ItemRemessaLocacao;
import com.rohr.coletorinterno.rohr.R;
import com.rohr.coletorinterno.rohr.Repository.ItensRemessaLocacaoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael.marques on 14/10/2016.
 */
public class LinhaItensConferencia extends BaseAdapter {

    private static LayoutInflater layoutInflater = null;

    List<ItemRemessaLocacao> itemRemessaLocacao = new ArrayList<>();

    ItensRemessaLocacaoRepository itensRemessaLocacaoRepository;

    private Conferencia conferencia;

    public LinhaItensConferencia(Conferencia conferencia, List<ItemRemessaLocacao> itemRemessaLocacao){

        this.conferencia = conferencia;
        this.itemRemessaLocacao = itemRemessaLocacao;
        this.layoutInflater     = (LayoutInflater) this.conferencia.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itensRemessaLocacaoRepository = new ItensRemessaLocacaoRepository(conferencia);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinhaconferencia = layoutInflater.inflate(R.layout.activity_linha_conferencia, null);

        TextView foreignkey = (TextView)viewLinhaconferencia.findViewById(R.id.textForeignKey);
        TextView total = (TextView)viewLinhaconferencia.findViewById(R.id.intTotal);
        TextView carregado = (TextView)viewLinhaconferencia.findViewById(R.id.Quantity);

        foreignkey.setText(String.valueOf(itemRemessaLocacao.get(position).getForeignKey()));
        total.setText(String.valueOf(itemRemessaLocacao.get(position).getQtdeItens()));
        carregado.setText(String.valueOf(itemRemessaLocacao.get(position).getTotalFaltante()));






        return viewLinhaconferencia;
    }
}

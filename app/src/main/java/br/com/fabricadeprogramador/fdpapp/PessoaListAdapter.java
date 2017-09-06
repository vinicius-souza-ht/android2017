package br.com.fabricadeprogramador.fdpapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuspodi on 30/08/17.
 */

public class PessoaListAdapter extends ArrayAdapter<Pessoa> {

    public PessoaListAdapter(Context context, List<Pessoa> pessoaList) {
        super(context, R.layout.item_pessoa_lista, pessoaList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_pessoa_lista, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Pessoa pessoa = getItem(position);
        if(pessoa != null) {
            holder.nomeItemLista.setText(pessoa.getNome());
            holder.idItemLista.setText(pessoa.getId().toString());
//            holder.imagem.setImageResource(pessoa.getImagem());
            holder.telefoneItemLista.setText(pessoa.getTelefone());
            holder.emailItemLista.setText(pessoa.getEmail());
        }
        return convertView;
    }

    class ViewHolder{
        @Bind(R.id.imagem_item_lista)
        ImageView imagem;

        @Bind(R.id.tv_lista_item_id)
        TextView idItemLista;

        @Bind(R.id.tv_lista_item_nome)
        TextView nomeItemLista;

        @Bind(R.id.tv_lista_item_telefone)
        TextView telefoneItemLista;

        @Bind(R.id.tv_lista_item_email)
        TextView emailItemLista;
    }
}

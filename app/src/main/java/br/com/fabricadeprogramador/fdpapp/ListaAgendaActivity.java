package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 30/08/17.
 */

public class ListaAgendaActivity extends AppCompatActivity {

    @Bind(R.id.lv_lista_agenda)
    ListView listaAgenda;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_agenda_activity);

        ButterKnife.bind(this);


        listaAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pessoa pessoaSel = (Pessoa) parent.getItemAtPosition(position);

                Intent irParaCadastro = new Intent(ListaAgendaActivity.this, AgendaActivity.class);
                Bundle parametro = new Bundle();
                parametro.putSerializable("pessoaSel", pessoaSel);
                irParaCadastro.putExtras(parametro);
                startActivity(irParaCadastro);
            }
        });

        listaAgenda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pessoa pessoaSel = (Pessoa) adapterView.getItemAtPosition(i);
//                BancoDeDados bancoDeDados = new BancoDeDados(ListaAgendaActivity.this);
//                bancoDeDados.excluir(pessoaSel);
                GerenciadorAgenda.excluir(pessoaSel);
                atualiza();

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        atualiza();
    }

    public void atualiza(){
//        BancoDeDados banco = new BancoDeDados(this);
        PessoaListAdapter adapter = new PessoaListAdapter(this, GerenciadorAgenda.getPessoasList());
        listaAgenda.setAdapter(adapter);
    }

    @OnClick(R.id.btn_lista_fechar)
    public void fechar(){
        finish();
    }

    @OnClick(R.id.btn_lista_novo)
    public void novo(){
        Intent irParaAgenda = new Intent(ListaAgendaActivity.this, AgendaActivity.class);
        startActivity(irParaAgenda);
    }
}

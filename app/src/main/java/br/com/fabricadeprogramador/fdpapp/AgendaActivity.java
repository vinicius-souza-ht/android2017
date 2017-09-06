package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 23/08/17.
 */

public class AgendaActivity extends AppCompatActivity {

    @Bind(R.id.ed_agenda_id)
    EditText edId;

    @Bind(R.id.ed_agenda_nome)
    EditText edNome;

    @Bind(R.id.ed_agenda_telefone)
    EditText edTelefone;

    @Bind(R.id.ed_agenda_email)
    EditText edEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        if(parametros != null) {
            Pessoa pessoaSel = (Pessoa) parametros.getSerializable("pessoaSel");

            if (pessoaSel != null) {
                edId.setText(pessoaSel.getId().toString());
                edNome.setText(pessoaSel.getNome());
                edEmail.setText(pessoaSel.getEmail());
                edTelefone.setText(pessoaSel.getTelefone());
            }
        }

    }

    @OnClick(R.id.bt_agenda_salvar)
    public void salvar(){

        String id = edId.getText().toString();
        String nome = edNome.getText().toString();
        String telefone = edTelefone.getText().toString();
        String email = edEmail.getText().toString();

        Pessoa pessoa = new Pessoa();

        if(id != null && !id.isEmpty()) {
            pessoa.setId(new Long(id));
        }

        pessoa.setNome(nome);
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);

        //TODO: Salvar em algum lugar
        GerenciadorAgenda.salvar(pessoa); //Salva na Lista


//        Intent intent = new Intent(AgendaActivity.this, ListaAgendaActivity.class);
//        if(edId.getText().toString().isEmpty()){
//            intent.putExtra("pessoa", new Pessoa(edNome.getText().toString(), edTelefone.getText().toString(), edEmail.getText().toString(),0));
//        } else {
//            intent.putExtra("pessoa", new Pessoa(new Long(edId.getText().toString()), edNome.getText().toString(), edTelefone.getText().toString(), edEmail.getText().toString(), 0));
//        }
//        startActivity(intent);

        fechar();
    }

    @OnClick(R.id.bt_agenda_fechar)
    public void fechar(){
        finish();
    }
}

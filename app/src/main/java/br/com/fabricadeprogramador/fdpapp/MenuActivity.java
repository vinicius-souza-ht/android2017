package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 16/08/17.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_menu_calculadora)
    public void botaoMenuCalculadora(){
        Intent irParaCalculadora = new Intent(MenuActivity.this, CalculadoraActivity.class);
        startActivity(irParaCalculadora);
    }

    @OnClick(R.id.btn_menu_conversor)
    public void botaoMenuConversor(){
        Intent irParaConversor = new Intent(MenuActivity.this, ConversorActivity.class);
        startActivity(irParaConversor);
    }

    @OnClick(R.id.btn_menu_agenda)
    public void botaoMenuAgenda(){
        Intent irParaAgenda = new Intent(MenuActivity.this, AgendaActivity.class);
        startActivity(irParaAgenda);
    }

    @OnClick(R.id.btn_menu_agenda2)
    public void botaoMenuAgenda2(){
        Intent irParaAgenda2 = new Intent(MenuActivity.this, ListaAgendaActivity.class);
        startActivity(irParaAgenda2);
    }
}

package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 23/08/17.
 */

public class ConversorActivity extends AppCompatActivity {

    @Bind(R.id.ed_conv_metros)
    EditText edMetro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_conversor);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_cm)
    public void converterMParaCm(){
        Double valorMetro = Double.parseDouble(edMetro.getText().toString());
        Intent irParaResultadoConversao = new Intent(ConversorActivity.this, ResultadoConversaoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("valorMetro",valorMetro);
        bundle.putDouble("valorConvertido",valorMetro / 0.010000);

        irParaResultadoConversao.putExtras(bundle);
        startActivity(irParaResultadoConversao);
    }

    @OnClick(R.id.bt_km)
    public void converterMParaKm(){
        Double valorMetro = Double.parseDouble(edMetro.getText() .toString());
        Intent irParaResultadoConversao = new Intent(ConversorActivity.this, ResultadoConversaoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("valorMetro",valorMetro);
        bundle.putDouble("valorConvertido",valorMetro / 1000);

        irParaResultadoConversao.putExtras(bundle);
        startActivity(irParaResultadoConversao);
    }

    @OnClick(R.id.bt_milha)
    public void converterMParaMilha(){
        Double valorMetro = Double.parseDouble(edMetro.getText().toString());
        Intent irParaResultadoConversao = new Intent(ConversorActivity.this, ResultadoConversaoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("valorMetro",valorMetro);
        bundle.putDouble("valorConvertido",valorMetro * 0.00062137);

        irParaResultadoConversao.putExtras(bundle);
        startActivity(irParaResultadoConversao);
    }

    @OnClick(R.id.bt_polegadas)
    public void converterMParaPolegadas(){
        Double valorMetro = Double.parseDouble(edMetro.getText().toString());
        Intent irParaResultadoConversao = new Intent(ConversorActivity.this, ResultadoConversaoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("valorMetro",valorMetro);
        bundle.putDouble("valorConvertido",valorMetro * 39.370);

        irParaResultadoConversao.putExtras(bundle);
        startActivity(irParaResultadoConversao);
    }
}

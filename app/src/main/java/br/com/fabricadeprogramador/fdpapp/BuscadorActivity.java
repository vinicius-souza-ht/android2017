package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 20/09/17.
 */

public class BuscadorActivity extends AppCompatActivity {

    @Bind(R.id.ed_busca_endereco)
    EditText edEndereco;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_mapa);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_busca_endereco)
    public void buscarEndereco(){
        String busca = edEndereco.getText().toString();

        Localizador localizador = new Localizador(BuscadorActivity.this);
        LatLng resultado = localizador.getCoordenada(busca);

        Intent irParaMapa = new Intent(BuscadorActivity.this, MapsActivity.class);
        irParaMapa.putExtra("lat", resultado.latitude);
        irParaMapa.putExtra("long", resultado.longitude);

        startActivity(irParaMapa);
    }
}

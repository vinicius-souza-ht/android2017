package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by viniciuspodi on 16/08/17.
 */

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Double resultado;

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();
        resultado = (Double) parametros.get("resultado");

        Toast.makeText(ResultadoActivity.this, "O resultado é: " + resultado, Toast.LENGTH_LONG).show();

    }
}

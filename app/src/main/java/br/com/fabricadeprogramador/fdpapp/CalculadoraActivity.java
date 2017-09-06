package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        System.out.println("CHAMOU O ON CREATE");

        //Captura a view da tela
        final EditText edNum1 = (EditText) findViewById(R.id.ed_num1);
        final EditText edNum2 = (EditText) findViewById(R.id.ed_num2);

        final Intent irParaResultado = new Intent(CalculadoraActivity.this, ResultadoActivity.class);
        final Bundle parametros = new Bundle();

        //SOMA
        Button btnSoma = (Button)findViewById(R.id.btn_Soma);
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Converte para valores numéricos

                String str1 = edNum1.getText().toString();
                String str2 = edNum2.getText().toString();

                //Verifica se foi digitado algum valor

                if(str1.isEmpty() || str2.isEmpty()){
                    Toast.makeText(CalculadoraActivity.this, "Insira os dados", Toast.LENGTH_LONG).show();
                } else {
                    Double n1 = Double.parseDouble(str1);
                    Double n2 = Double.parseDouble(str2);

                    Double soma = n1 + n2;

                    parametros.putDouble("resultado", soma);
                    irParaResultado.putExtras(parametros);

                    startActivity(irParaResultado);
                    //Toast.makeText(CalculadoraActivity.this, "A soma é: " + soma, Toast.LENGTH_SHORT).show();
                }
            }
        });


        //SUBTRAÇÃO
        Button btnSubtracao = (Button)findViewById(R.id.btn_Subtracao);
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Converte para valores numéricos

                String str1 = edNum1.getText().toString();
                String str2 = edNum2.getText().toString();

                //Verifica se foi digitado algum valor

                if(str1.isEmpty() || str2.isEmpty()){
                    Toast.makeText(CalculadoraActivity.this, "Insira os dados", Toast.LENGTH_LONG).show();
                } else {
                    Double n1 = Double.parseDouble(str1);
                    Double n2 = Double.parseDouble(str2);

                    Double subtracao = n1 - n2;

                    parametros.putDouble("resultado", subtracao);
                    irParaResultado.putExtras(parametros);

                    startActivity(irParaResultado);
                    //Toast.makeText(CalculadoraActivity.this, "A subtração é: " + subtracao, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //MULTIPLICAÇÃO
        Button btnMultiplicacao = (Button)findViewById(R.id.btn_Multiplicacao);
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Converte para valores numéricos

                String str1 = edNum1.getText().toString();
                String str2 = edNum2.getText().toString();

                //Verifica se foi digitado algum valor

                if(str1.isEmpty() || str2.isEmpty()){
                    Toast.makeText(CalculadoraActivity.this, "Insira os dados", Toast.LENGTH_LONG).show();
                } else {
                    Double n1 = Double.parseDouble(str1);
                    Double n2 = Double.parseDouble(str2);

                    Double multiplicacao = n1 * n2;

                    parametros.putDouble("resultado", multiplicacao);
                    irParaResultado.putExtras(parametros);

                    startActivity(irParaResultado);
                    //Toast.makeText(CalculadoraActivity.this, "A multiplicação é: " + multiplicacao, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //DIVISÃO
        Button btnDivisao = (Button)findViewById(R.id.btn_Divisao);
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Converte para valores numéricos

                String str1 = edNum1.getText().toString();
                String str2 = edNum2.getText().toString();

                Double n1 = Double.parseDouble(str1);
                Double n2 = Double.parseDouble(str2);

                //Verifica se foi digitado algum valor

                if(str1.isEmpty() || str2.isEmpty()){
                    Toast.makeText(CalculadoraActivity.this, "Insira os dados!", Toast.LENGTH_LONG).show();
                }else if(n2 == 0){
                    Toast.makeText(CalculadoraActivity.this, "O divisor não pode ser zero!", Toast.LENGTH_LONG).show();
                } else {
                    Double divisao = n1 / n2;


                    parametros.putDouble("resultado", divisao);
                    irParaResultado.putExtras(parametros);

                    startActivity(irParaResultado);
                    //Toast.makeText(CalculadoraActivity.this, "A divisão é: " + divisao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("CHAMOU O ON START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("CHAMOU O ON RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("CHAMOU O ON PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("CHAMOU O ON STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("CHAMOU O ON DESTROY");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("CHAMOU O ON RESTART");
    }
}

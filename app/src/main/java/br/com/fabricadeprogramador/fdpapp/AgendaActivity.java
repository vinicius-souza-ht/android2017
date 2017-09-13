package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 23/08/17.
 */

public class AgendaActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 123;

    @Bind(R.id.user_image)
    ImageView userImage;

//    @Bind(R.id.ed_agenda_id)
//    EditText edId;

    @Bind(R.id.ed_agenda_nome)
    EditText edNome;

    @Bind(R.id.ed_agenda_telefone)
    EditText edTelefone;

    @Bind(R.id.ed_agenda_email)
    EditText edEmail;

    private Bitmap photo;

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
//                edId.setText(pessoaSel.getId().toString());
                edNome.setText(pessoaSel.getNome());
                edEmail.setText(pessoaSel.getEmail());
                edTelefone.setText(pessoaSel.getTelefone());
            }
        }

    }

    @OnClick(R.id.user_image)
    public void changeImage() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
        } else {
            Toast.makeText(this, "Imagem não carregada", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.bt_agenda_salvar)
    public void salvar(){

//        String id = edId.getText().toString();
        String nome = edNome.getText().toString();
        String telefone = edTelefone.getText().toString();
        String email = edEmail.getText().toString();

        Pessoa pessoa = new Pessoa();

//        if(id != null && !id.isEmpty()) {
//            pessoa.setId(new Long(id));
//        }

        pessoa.setNome(nome);
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);
        pessoa.setImagem(photo);

        //TODO: Salvar em algum lugar
//        GerenciadorAgenda.salvar(pessoa); //Salva na Lista

        BancoDeDados bancoDeDados = new BancoDeDados(AgendaActivity.this);
        bancoDeDados.salvar(pessoa);

        fechar();
    }

    @OnClick(R.id.bt_agenda_fechar)
    public void fechar(){
        finish();
    }
}

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
 * Created by viniciuspodi on 13/09/17.
 */

public class CameraActivity extends AppCompatActivity{

    private static final int CAMERA_REQUEST = 123;

    @Bind(R.id.user_image)
    ImageView userImage;

    @Bind(R.id.name)
    EditText userName;

    @Bind(R.id.email)
    EditText userEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_register);

        ButterKnife.bind(this);
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
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
        } else {
            Toast.makeText(this, "Imagem não carregada", Toast.LENGTH_SHORT).show();
        }
    }
}

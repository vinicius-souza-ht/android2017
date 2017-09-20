package br.com.fabricadeprogramador.fdpapp;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by viniciuspodi on 20/09/17.
 */

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    Marker marker;
    List<LatLng> locais = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        ButterKnife.bind(this);

        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(this);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        if(parametros != null){
            Double lat = parametros.getDouble("lat");
            Double lon = parametros.getDouble("long");

            LatLng coordenadas = new LatLng(lat,lon);

            locais.add(coordenadas);
        }

        Localizador localizador = new Localizador(MapsActivity.this);

        LatLng end1 = localizador.getCoordenada("João Rosa Pires 1001, Campo Grande, MS");
        LatLng end2 = localizador.getCoordenada("Av. Afonso Pena 1000, Campo Grande, MS");
        LatLng end3 = localizador.getCoordenada("Austregesimo de Athaide 76, Campo Grande MS");

        locais.add(end1);
        locais.add(end2);
        locais.add(end3);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);

        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if(marker!=null){
                    marker.remove();
                }


                LatLng local = new LatLng(location.getLatitude(), location.getLongitude());
                marker =  googleMap.addMarker(new MarkerOptions().position(local));
            }
        });

        for (LatLng local: locais){
            if(local != null){
                googleMap.addMarker(new MarkerOptions().position(local));
            }
        }
    }
}

package com.example.prueba_valid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Informacion_artista extends AppCompatActivity {

    ListView lista;
    TextView edt_n, edt_o, edt_p, edt_u;

    String[][] datos_artista = {{"David Bowie","2.3M","Heroes - 2017 Remaster","Starman - 2012 Remaster"},
                                {"Radiohead","4.0M","Creep","Karma Police"},
                                {"Coldplay","3.5M","The Scientist","Viva la Vida"},
                                {"Queen","4.5M","Don't Stop Me Now - Remastered","We Will Rock You - Remastered"},
                                {"The Rolling Stones","2.9M","Paint It Black","Gimme Shelter"}
    };
    String[][] canciones_artista = {{"David Bowie","Starman - 2012 Remaster","Space Oddity - 2015 Remaster","Rebel Rebel - 2016 Remaster"},
                                    {"Creep","Karma Police","No Surprises","No Surprises"},
                                    {"The Scientist","Viva la Vida","Yellow","Yellow"},
                                    {"Don't Stop Me Now - Remastered","We Will Rock You - Remastered","Bohemian Rhapsody","Bohemian Rhapsody"},
                                    {"Paint It Black","Gimme Shelter","Gimme Shelter","Start Me Up - Remastered"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_artista);

        lista = (ListView) findViewById(R.id.Lista_A);

        edt_n = (TextView) findViewById(R.id.Oyentes_l);
        edt_o = (TextView) findViewById(R.id.oyentes);
        edt_p = (TextView) findViewById(R.id.popular);
        edt_u = (TextView) findViewById(R.id.ultimo_lanzamiento);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
           int po = Integer.parseInt(b.getString("posicion"));
           edt_n.setText(datos_artista[po][0]);
           edt_o.setText(datos_artista[po][1]);
           edt_p.setText(datos_artista[po][2]);
           edt_u.setText(datos_artista[po][3]);

        }
    }


}

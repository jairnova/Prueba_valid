package com.example.prueba_valid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

    ListView listado;
    EditText edt_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = (ListView) findViewById(R.id.Lista_Artistas);
        edt_b = (EditText) findViewById(R.id.edt_buscar_art);
        listado.setAdapter(new Adaptador(this, datos_artista));

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent ia = new Intent(view.getContext(), Informacion_artista.class);
                ia.putExtra("posicion", String.valueOf(position));
                startActivity(ia);
            }
        });

    }

    public String [][] buscar_en_lista (String[][] datos, String var){

        String [][] nuv_datos = datos;
        int sb =0;

        for (int x=0; x < datos.length; x++) {
            for (int y=0; y < datos[x].length; y++) {

                if(datos[x][y].equals(var)){
                    sb++;
                }
            }
        }

        if(sb != 0) {
            nuv_datos = new String[sb][datos[0].length];
            int j = 0;

            for (int x = 0; x < datos.length; x++) {
                for (int yy = 0; yy < datos[x].length; yy++) {

                    if (datos[x][yy].equals(var)) {

                        for (int y = 0; y < datos[x].length; y++) {
                            nuv_datos[j][y] = datos[x][y];
                        }
                        j++;
                    }
                }
            }
        }

        return nuv_datos;
    }

    public void buscar_artista(View view){

        String val = edt_b.getText().toString();

        for (int x=0; x < canciones_artista.length; x++) {
            for (int y=0; y < canciones_artista[x].length; y++) {

                if(canciones_artista[x][y].equals(val)){

                    String [][] dat = buscar_en_lista(datos_artista, val);

                    if(dat.length != datos_artista.length ) {
                        listado.setAdapter(new Adaptador(this, dat));
                    } else{
                        listado.setAdapter(new Adaptador(this, dat));

                        Toast toas = Toast.makeText(getApplicationContext(), "No hay artista con la información: '"+val+"'", Toast.LENGTH_SHORT);
                        toas.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);
                        toas.show();
                    }
                }
            }
        }

    }

}

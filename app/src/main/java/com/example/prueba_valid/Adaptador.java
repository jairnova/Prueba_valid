package com.example.prueba_valid;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Adaptador extends BaseAdapter {

    // Nos sirve para instanciar el archivo xml elemento_lista creado
    private static LayoutInflater inflater = null;

    // El context entorno de la aplicacion se utiliza para generar el adaptador
    Context contexto;
    //Es la matriz para almacenar los datos
    String[][] datos;

    public Adaptador(Context context, String[][] dato)
    {
        this.contexto = context;
        this.datos = dato;

        // sirve para crear o instanciar el xml
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView nombre = (TextView) vista.findViewById(R.id.nombre_l);
        TextView oyentes = (TextView) vista.findViewById(R.id.Oyentes_l);
        TextView popular = (TextView) vista.findViewById(R.id.popular_l);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imagen);

        nombre.setText(datos[position][0]);
        oyentes.setText(datos[position][1]);
        popular.setText(datos[position][2]);

        imagen.setImageResource(R.drawable.paciente);

        return vista;
    }

    @Override
    public int getCount() {
        return datos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}

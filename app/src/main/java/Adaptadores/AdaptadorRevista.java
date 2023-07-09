package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listaspractica.R;

import java.util.ArrayList;

import Modelos.Usuario;
import Modelos.revista;

public class AdaptadorRevista extends ArrayAdapter<revista> {
    public AdaptadorRevista(Context context, ArrayList<revista> datos) {
        super(context, R.layout.lista_bonita, datos);

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_bonita, null);
        TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getAno());
        ImageView imageView = (ImageView) item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getImagen())
                .into(imageView);
        return item;
    }
}

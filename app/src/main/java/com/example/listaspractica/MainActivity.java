package com.example.listaspractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adaptadores.AdaptadorUsuario;
import Modelos.Usuario;
import WebService.WebService;
import WebService.Asynchtask;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    ListView LstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LstOpciones = (ListView)findViewById(R.id.lista);
        View header = getLayoutInflater().inflate(R.layout.header,null);
        LstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Usuario> lstUsuarios = Modelos.Usuario.JsonObjectsBuild(jsonArray);
        AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(this, lstUsuarios);
        LstOpciones.setAdapter(adaptadorUsuario);


        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}
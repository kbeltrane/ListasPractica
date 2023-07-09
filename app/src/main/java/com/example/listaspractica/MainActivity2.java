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

import Adaptadores.AdaptadorRevista;
import Adaptadores.AdaptadorUsuario;
import Modelos.Usuario;
import Modelos.revista;
import WebService.WebService;
import WebService.Asynchtask;

public class MainActivity2 extends AppCompatActivity implements Asynchtask {
    ListView LstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String valor = intent.getStringExtra("clave_valor");

        LstOpciones = findViewById(R.id.lista);
        View header = getLayoutInflater().inflate(R.layout.header, null);
        LstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id=1",
                datos, MainActivity2.this, MainActivity2.this);
        ws.execute("GET");


    }


    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<revista> lstrevista = revista.JsonObjectsBuild(jsonArray);
        AdaptadorRevista adaptadorUsuario = new AdaptadorRevista(this, lstrevista);
        LstOpciones.setAdapter(adaptadorUsuario);
        
    }
}
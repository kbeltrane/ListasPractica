package Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class revista {
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    private String numero;
    private String volumen;
    private String ano;
    private String imagen;
    public revista(JSONObject a) throws JSONException {
        numero = a.getString("issue_id").toString();
        volumen = a.getString("volume").toString() ;
        ano = a.getString("year").toString() ;
        imagen = a.getString("cover").toString() ;
    }
    public static ArrayList<revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<revista> revistas = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            revistas.add(new revista(datos.getJSONObject(i)));
        }
        return revistas;
    }
}

package en.ase.grupa1097.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MasinaParser {
private final static String ID="id";
private final static String MARCA="marca";
private final static String PRET="pret";
private final static String PUTERE="putere";
    public static List<Masina> fromJson(String rezultat) {
        try {
            JSONArray array= new JSONArray(rezultat);
            return citireMasini(array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    private static List<Masina> citireMasini(JSONArray array) throws JSONException {
        List<Masina> lista=new ArrayList<>();
        for(int i=0;i< array.length();i++){
            lista.add(citireMasina(array.getJSONObject(i)));
        }
        return lista;
    }

    private static Masina citireMasina(JSONObject object) throws JSONException {
        String marca=object.getString(MARCA);
        long id = object.getLong(ID);
        double pret = object.getDouble(PRET);
        float putere = (float) object.getDouble(PUTERE);
        return new Masina(id, marca, pret, putere);


    }


}

package ro.ase.grupa1086;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ro.ase.grupa1086.retea.HttpsManager;
import ro.ase.grupa1086.util.Produs;
import ro.ase.grupa1086.util.ProdusParser;

public class MainActivity extends AppCompatActivity {
    private List<Produs> listaProduse = new ArrayList<>();
    private ListView listView;
    private static final String adresaUrl = "https://jsonkeeper.com/b/4C3Y";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializareComponente();
        listaProduse.add(new Produs(1, "Mamaliga", 25));
        listaProduse.add(new Produs(4, "Apa", 5));
        incarcareProduseHttps();
    }

    private void incarcareProduseHttps() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager httpsManager = new HttpsManager(adresaUrl);
                String rezultat = httpsManager.process();
                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getProduseFromJson(rezultat);
                    }
                });
            }
        };
        thread.start();
    }

    private void getProduseFromJson(String rezultat) {
        listaProduse.addAll(ProdusParser.fromJson(rezultat));
        notificareAdapter();
    }

    private void notificareAdapter() {
        ArrayAdapter<Produs> adapter = (ArrayAdapter<Produs>)
                listView.getAdapter();
        adapter.notifyDataSetChanged();
    }

    private void initializareComponente() {
        listView = findViewById(R.id.listView);
        adaugareAdapter();
    }

    private void adaugareAdapter() {
        ArrayAdapter<Produs> adapter = new ArrayAdapter<>(
                getApplicationContext(), android.R.layout.simple_list_item_1,
                listaProduse);
        listView.setAdapter(adapter);
    }
}
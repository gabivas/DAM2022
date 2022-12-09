package en.ase.grupa1097;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import en.ase.grupa1097.retea.HttpsManager;
import en.ase.grupa1097.util.Masina;
import en.ase.grupa1097.util.MasinaParser;

public class MainActivity extends AppCompatActivity {
private List<Masina> lista= new ArrayList<>();
private ListView listView;
private static final String URL_JSON="https://jsonkeeper.com/b/GCOU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializareComponente();
        lista.add(new Masina(1,"Ford",20,120));
        lista.add(new Masina(2,"Golf",18,115));

        incarcareMasiniHttps();
    }

    private void incarcareMasiniHttps() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager httpsManager =
                        new HttpsManager(URL_JSON);
                String rezultat = httpsManager.process();
                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        preluareMasiniHttps(rezultat);
                    }
                });
            }
        };
        thread.start();
    }

    private void preluareMasiniHttps(String rezultat) {
    lista.addAll(MasinaParser.fromJson(rezultat));
    notificareAdapter();}

    private void notificareAdapter() {
        ArrayAdapter<Masina> adapter= (ArrayAdapter<Masina>)
                listView.getAdapter();
        adapter.notifyDataSetChanged();

    }

    private void initializareComponente() {
        listView =findViewById(R.id.listView);
        setAdapterListView();
    }

    private void setAdapterListView() {
        ArrayAdapter<Masina> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);
    }

    }
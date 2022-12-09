package ro.ase.grupa1086;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retea retea= new Retea(){
            @Override
            protected void onPostExecute(InputStream inputStream) {
                Log.i("cursValutarConcatenat",cursValutar.toString());
            }
        };
        try {
            retea.execute(new URL("https://www.bnr.ro/nbrfxrates.xml"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
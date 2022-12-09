package ro.ase.grupa1086;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getApplicationContext()
                    .openFileOutput("text.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write("Text-din-fisier");
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("textCitit", citireTextDinFisier(
                getApplicationContext(),"text.txt"));
    }

    private String citireTextDinFisier(Context applicationContext, String numeFisier) {
        String textCitit="";
        try {
            InputStream is = applicationContext
                    .openFileInput(numeFisier);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String linie="";
            while((linie = br.readLine())!=null){
                sb.append("\n").append(linie);
            }
            is.close();
            textCitit= sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textCitit;
    }
}
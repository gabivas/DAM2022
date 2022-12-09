package ro.ase.grupa1086;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int OPTIUNE1 = 0;
    private static final int OPTIUNE2 = 1;
    private EditText etEur, etUsd, etGbp;

    @Override
    public void onClick(View view) {
//        EUR.setText("4.95");
//        USD.setText("4.28");
//        GBP.setText("5.83");
    }

    public enum Location {
        INTERN, PC, DRIVE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEur = findViewById(R.id.editTextEur);
        etUsd = findViewById(R.id.editTextUsd);
        etGbp = findViewById(R.id.editTextGbp);

        Spinner sp1 = findViewById(R.id.spinner1);
        String[] values = new String[Location.values().length];
        int i = 0;
        for (Location loc : Location.values()) {
            values[i++] = loc.toString();
        }
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, values);
        sp1.setAdapter(adaptor);


        Button btn1 = findViewById(R.id.btnAfisare);
        //btn1.setOnClickListener(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEur.setText("4.95");
                etUsd.setText("4.28");
                etGbp.setText("5.83");
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, OPTIUNE1, 1, "OPTIUNE1");
        menu.add(0, OPTIUNE2, 0, "OPTIUNE2");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case OPTIUNE1:
                Log.e("menu", "Am apasat pe OPTIUNE1");
                return true;

            case OPTIUNE2:
                Log.e("menu", "Am apasat pe OPTIUNE2");
                return true;

        }
        return false;
    }
}

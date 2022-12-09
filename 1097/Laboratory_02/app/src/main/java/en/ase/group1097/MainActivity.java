package en.ase.group1097;

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
    private static final int OPTION1 = 0;
    private static final int OPTION2 = 1;
    EditText etEur, etUsd, etGbp;

    @Override
    public void onClick(View view) {
        etEur.setText("4.95");
        etGbp.setText("5.46");
        etUsd.setText("4.20");
    }

    public enum Location {
        INTERN, PC, DRIVE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEur = findViewById(R.id.editTextEur);
        etGbp = findViewById(R.id.editTextGbp);
        etUsd = findViewById(R.id.editTextUsd);

        Spinner spinner = findViewById(R.id.spinner1);
        String[] values = new String[Location.values().length];
        int i = 0;
        for (Location location : Location.values()) {
            values[i++] = location.toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,
                values);
        spinner.setAdapter(adapter);

        Button btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                etEur.setText("4.95");
//                etGbp.setText("5.46");
//                etUsd.setText("4.20");
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, OPTION1, 0, "Click on option 1");
        menu.add(0, OPTION2, 1, "Click on option 2");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case OPTION1:
                Log.i("menu","Option 1 was pressed.");
                return true;
            case OPTION2:
                Log.i("menu","Option 2 was pressed.");
                return true;
        }
        return false;
    }
}
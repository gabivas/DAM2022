package ro.ase.grupa1086;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdaugareStudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_student);
        final EditText etNume=findViewById(R.id.editTextNume);
        final EditText etDataInmatriculare= findViewById(R.id.editTextDataInmatriculare);
        final EditText etVarsta=findViewById(R.id.editTextVarsta);
        Spinner spinner= findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=
                ArrayAdapter.createFromResource(this,
                        R.array.facultate, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button btnSalvare= findViewById(R.id.button);
        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNume.getText().toString().isEmpty()){
                    etNume.setError("Introduceti numele!");
                }
            }
        });
    }
}
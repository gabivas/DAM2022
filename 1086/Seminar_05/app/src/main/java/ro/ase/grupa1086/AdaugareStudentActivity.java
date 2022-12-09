package ro.ase.grupa1086;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdaugareStudentActivity extends AppCompatActivity {
    public static final String ADAUGARE_STUDENT_LABEL = "Adaugare_Student";
    private final String DATE_FORMAT = "dd/MM/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_student);
        final EditText etNume=findViewById(R.id.editTextNume);
        final EditText etDataInmatriculare= findViewById(R.id.editTextDataInmatriculare);
        final EditText etVarsta=findViewById(R.id.editTextVarsta);
        Intent intent = getIntent();
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
                if(etDataInmatriculare.getText().toString().isEmpty()){
                    etDataInmatriculare.setError("Introduceti data!");
                }
                if(etVarsta.getText().toString().isEmpty()){
                    etVarsta.setError("Introduceti varsta!");
                }
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
                Date dataInmatriculare= null;
                try {
                    dataInmatriculare = sdf.parse(etDataInmatriculare.getText().toString());
                    String nume= etNume.getText().toString();
                    int varsta = Integer.parseInt(etVarsta.getText().toString());
                    Facultate facultate = Facultate.valueOf(spinner.getSelectedItem().toString());
                    RadioGroup radioGroup = findViewById(R.id.radioGroup);
                    RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                    FormaInvatamant formaInvatamant = FormaInvatamant.valueOf(radioButton.getText().toString());

                    Student student=new Student(nume, dataInmatriculare, varsta,formaInvatamant, facultate);
                    intent.putExtra(ADAUGARE_STUDENT_LABEL, student);
                    setResult(RESULT_OK, intent);
                    finish();

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
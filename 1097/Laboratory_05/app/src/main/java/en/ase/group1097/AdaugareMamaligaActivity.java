package en.ase.group1097;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class AdaugareMamaligaActivity extends AppCompatActivity {

    public static final String ADAUGARE_MAMALIGA_LABEL = "Adaugare_Mamaliga";
    private final String DATE_FORMAT = "dd/MM/yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_mamaliga);
        final EditText etNumeRestaurant=findViewById(R.id.editTextNumeRestaurant);
        final EditText etDataExp=findViewById(R.id.editTextDataExpirare);
        final EditText etCantitate=findViewById(R.id.editTextCantitate);
        Spinner spinner=findViewById(R.id.spinner);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final Intent intent = getIntent();
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(
                this,R.array.tip_mamaliga,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button saveBt= findViewById(R.id.button);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNumeRestaurant.getText().toString().isEmpty()){
                    etNumeRestaurant.setError("Introduceti numele" +
                            " restaurantului!");
                }
                if(etCantitate.getText().toString().isEmpty()){
                    etCantitate.setError("Introduceti cantitatea");
                }
                if(etDataExp.getText().toString().isEmpty()){
                    etDataExp.setError("Introduceti data");
                }
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
                try {
                    Date dataExpirare = sdf.parse(etDataExp.getText().toString());
                    String numeRestaurant= etNumeRestaurant.getText().toString();
                    int cantitate = Integer.valueOf(etCantitate.getText().toString());
                    TipMamaliga tipMamaliga = TipMamaliga.valueOf(spinner.getSelectedItem()
                            .toString());
                    RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                    TipMalai tipMalai = TipMalai.valueOf(radioButton.getText().toString());
                    Mamaliga mamaliga = new Mamaliga(numeRestaurant,cantitate,dataExpirare,
                            tipMamaliga,tipMalai);
                    Log.i("mamaliga",mamaliga.toString());
                    intent.putExtra(ADAUGARE_MAMALIGA_LABEL, mamaliga);
                    setResult(RESULT_OK,intent);
                    finish();

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
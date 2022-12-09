package en.ase.group1097;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdaugareMamaligaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_mamaliga);
        final EditText etNumeRestaurant=findViewById(R.id.editTextNumeRestaurant);
        final EditText etDataExp=findViewById(R.id.editTextDataExpirare);
        final EditText etCantitate=findViewById(R.id.editTextCantitate);
        Spinner spinner=findViewById(R.id.spinner);
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
            }
        });

    }
}
package en.ase.group1097;

import static en.ase.group1097.AdaugareMamaligaActivity.ADAUGARE_MAMALIGA_LABEL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 200;
    private FloatingActionButton floatingActionButton;
    private ListView listView;
    private List<Mamaliga> listaMamaligi= new ArrayList<Mamaliga>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        AdaugareMamaligaActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        listView=findViewById(R.id.listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this,
                        "Option 1 was pressed!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option2:
                Toast.makeText(this,
                        "Option 2 was pressed!", Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK && data!=null){
            Mamaliga mamaliga = (Mamaliga) data.getSerializableExtra(ADAUGARE_MAMALIGA_LABEL);
            Log.i("mamaliga",mamaliga.toString());
            if(mamaliga!=null){
                listaMamaligi.add(mamaliga);
//                ArrayAdapter<Mamaliga> adapter= new ArrayAdapter<Mamaliga>(
//                        getApplicationContext(), android.R.layout.simple_list_item_1,
//                        listaMamaligi);
                MamaligaAdapter mamaligaAdapter =
                        new MamaligaAdapter(getApplicationContext(),
                                R.layout.mamaligalistview, listaMamaligi,
                getLayoutInflater()){
                            @NonNull
                            @Override
                            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                                View view=super.getView(position, convertView, parent);
                                Mamaliga mamaliga=listaMamaligi.get(position);

                                TextView tvCantitate= view.findViewById(
                                        R.id.tvCantitate);
                                if(mamaliga.getCantitate()>=200){
                                    tvCantitate.setTextColor(Color.GREEN);
                                }
                                else{
                                    tvCantitate.setTextColor(Color.RED);
                                }
                                return view;
                            }
                        };
                listView.setAdapter(mamaligaAdapter);

            }
        }

    }
}
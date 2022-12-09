package en.ase.group1097;

import static en.ase.group1097.AdaugareMamaligaActivity.ADAUGARE_MAMALIGA_LABEL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 200;
    private static final int REQUEST_EDIT_CODE=300;
    private FloatingActionButton floatingActionButton;
    private ListView listView;
    private List<Mamaliga> listaMamaligi= new ArrayList<Mamaliga>();
    private int poz;
    private Intent intent;
    public static final String EDIT_MAMALIGA="editMamaliga";

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pozitie, long id) {
               poz= pozitie;
               intent= new Intent(getApplicationContext(),AdaugareMamaligaActivity.class);
               intent.putExtra(EDIT_MAMALIGA, listaMamaligi.get(poz));
               startActivityForResult(intent,REQUEST_EDIT_CODE);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               final Mamaliga mamaliga = listaMamaligi.get(poz);
               final MamaligaAdapter mamaligaAdapter = (MamaligaAdapter) listView.getAdapter();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Stergere mamaliga din lista")
                        .setMessage("Sigur stergi mamaliga din lista?")
                        .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listaMamaligi.remove(mamaliga);
                                mamaligaAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "S-a sters mamaliga: "+
                                        mamaliga.toString(), Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        }).create();
                alertDialog.show();
                return true;
            }
        });

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
        }else if(requestCode==REQUEST_EDIT_CODE && resultCode==RESULT_OK && data!=null){
            Mamaliga mamaliga = (Mamaliga) data.getSerializableExtra(ADAUGARE_MAMALIGA_LABEL);
            if(mamaliga!=null){
                //actualizam mamaliga de pe pozitia poz din lista
            }
        }

    }
}
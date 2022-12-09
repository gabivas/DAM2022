package en.ase.group1097;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalScrollView scrollView = new HorizontalScrollView(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        CompanieDB database = CompanieDB.getInstance(getApplicationContext());
        Companie companie = new Companie("Google", "04/09/1998", "53861", "California", "25");
        database.getCompanieDao().insertCompanie(companie);
        List<Companie> companii = database.getCompanieDao().getAll();

        ArrayAdapter<Companie> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,
                companii);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pozitie, long id) {
                Companie companie1= companii.get(pozitie);
                ArrayAdapter adapter1= (ArrayAdapter) listView.getAdapter();

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Confirmare stergere")
                        .setMessage("Sigur stergi compania?")
                        .setNegativeButton("NU", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Nu s-a sters nimic", Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        })
                        .setPositiveButton("DA", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                companii.remove(companie1);
                                CompanieDB database = CompanieDB.getInstance(getApplicationContext());
                                database.getCompanieDao().deleteCompanie(companie1);
                                adapter1.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Stergerea a fost efectuata cu succes", Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        }).create();
                dialog.show();
                return false;
            }
        });



        TextView textView = new TextView(this);
        textView.setText("Lista de companii din baza de date:"+"\n");
        linearLayout.addView(textView);
        linearLayout.addView(listView);
        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }
}
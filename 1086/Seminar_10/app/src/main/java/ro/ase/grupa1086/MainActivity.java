package ro.ase.grupa1086;

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

        HorizontalScrollView sv = new HorizontalScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        Sport sport= new Sport("Fotbal", "Mare", "11", "QatarStadium");
        SportDB database = SportDB.getInstance(getApplicationContext());
        database.getSportDao().insertSport(sport);
        List<Sport> sporturi = database.getSportDao().selectALl();

        ArrayAdapter<Sport> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, sporturi);
        ListView lv= new ListView(this);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Sport sport1 = sporturi.get(position);
                ArrayAdapter adapter1 = (ArrayAdapter) lv.getAdapter();
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Confirmare stergere sport")
                        .setMessage("Esti sigur?")
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
                                sporturi.remove(sport1);
                                SportDB database = SportDB.getInstance(getApplicationContext());
                                database.getSportDao().deleteSport(sport1);
                                adapter1.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Stergerea s-a efectuat cu succes", Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        }).create();
                dialog.show();
                return true;
            }
        });

        TextView tv = new TextView(this);
        tv.setText("Lista de sporturi din DB:"+"\n");
        ll.addView(tv);
        ll.addView(lv);
        sv.addView(ll);
        setContentView(sv);
    }
}
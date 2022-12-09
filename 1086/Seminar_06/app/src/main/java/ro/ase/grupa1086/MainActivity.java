package ro.ase.grupa1086;

import static ro.ase.grupa1086.AdaugareStudentActivity.ADAUGARE_STUDENT_LABEL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
    private FloatingActionButton floatingActionButton;
    public static int REQUEST_CODE = 200;
    public static int REQUEST_EDIT_CODE = 300;
    private ListView listView;
    public int poz;
    List<Student> listaStudenti = new ArrayList<Student>();
    private Intent intent;
    public static final String EDIT_STUDENT="editStudent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton=findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),
                        AdaugareStudentActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        listView= findViewById(R.id.idListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pozitie, long id) {
                poz=pozitie;
                intent=new Intent(getApplicationContext(),
                        AdaugareStudentActivity.class);
                intent.putExtra(EDIT_STUDENT,listaStudenti.get(poz));
                startActivityForResult(intent,REQUEST_EDIT_CODE);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Student student= listaStudenti.get(poz);
                final StudentAdapter studentAdapter= (StudentAdapter) listView.getAdapter();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Stergere student din lista")
                        .setMessage("Sigur doresti sa stergi studentul?")
                        .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listaStudenti.remove(student);
                                studentAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "S-a sters studentul: "+student.toString(),
                                        Toast.LENGTH_SHORT).show();
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
        getMenuInflater().inflate(R.menu.meniu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.optiune1:
                Toast.makeText(this, "Ati apasat pe opt1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.optiune2:
                Toast.makeText(this, "Ati apasat pe opt2", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode==RESULT_OK && data !=null){
            Student student = (Student) data.getSerializableExtra(ADAUGARE_STUDENT_LABEL);
            if(student!=null){
                listaStudenti.add(student);
//                ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(getApplicationContext(),
//                        android.R.layout.simple_list_item_1,listaStudenti);
                StudentAdapter studentAdapter=
                        new StudentAdapter(getApplicationContext(),
                                R.layout.studentlistview,listaStudenti,
                                getLayoutInflater()){

                            @NonNull
                            @Override
                            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                                View view= super.getView(position, convertView, parent);
                                Student student= listaStudenti.get(position);
                                TextView tvVarsta= view.findViewById(
                                        R.id.tvVarsta);
                                if(student.getVarsta()>=20){
                                    tvVarsta.setTextColor(Color.GREEN);
                                }
                                else{
                                    tvVarsta.setTextColor(Color.YELLOW);

                                }
                                return view;
                            }
                        };
                listView.setAdapter(studentAdapter);
            }
        }
        else if(requestCode==REQUEST_EDIT_CODE &&
        resultCode==RESULT_OK && data !=null){
            Student student = (Student)data.getSerializableExtra(ADAUGARE_STUDENT_LABEL);

            if(student!=null){
                //actualizam studentul de pe pozitia poz

            }
        }

    }
}

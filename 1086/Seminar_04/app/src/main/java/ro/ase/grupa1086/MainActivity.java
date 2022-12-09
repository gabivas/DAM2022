package ro.ase.grupa1086;

import static ro.ase.grupa1086.AdaugareStudentActivity.ADAUGARE_STUDENT_LABEL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    public static int REQUEST_CODE = 200;
    private ListView listView;
    List<Student> listaStudenti = new ArrayList<Student>();

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
                ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(getApplicationContext(),
                        android.R.layout.simple_list_item_1,listaStudenti);
                listView.setAdapter(adapter);
            }
        }

    }
}
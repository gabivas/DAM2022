package ro.ase.grupa1086;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int resource;
    private List<Student> listaStudenti;
    private LayoutInflater inflater;

    public StudentAdapter(@NonNull Context context,
                          int resource, List<Student> listaStudenti,
                          LayoutInflater inflater) {
        super(context, resource, listaStudenti);
        this.context=context;
        this.listaStudenti=listaStudenti;
        this.inflater=inflater;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource,parent, false);
        Student student = listaStudenti.get(position);
        if(student!=null){
            TextView tv1= view.findViewById(R.id.tvNume);
            TextView tv2= view.findViewById(R.id.tvVarsta);
            TextView tv3= view.findViewById(R.id.tvData);
            TextView tv4= view.findViewById(R.id.tvFacultate);
            TextView tv5= view.findViewById(R.id.tvForma);
            tv1.setText(student.getNume());
            tv2.setText(String.valueOf(student.getVarsta()));
            tv3.setText(new SimpleDateFormat("dd/MM/yyyy").format(student.getDataInmatriculare()));
            tv4.setText(String.valueOf(student.getFacultate()));
            tv5.setText(String.valueOf(student.getFormaInvatamant()));

        }

        return view;
    }
}

package en.ase.group1097;

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

public class MamaligaAdapter extends ArrayAdapter<Mamaliga> {
    private Context context;
    private List<Mamaliga> listaMamaligi;
    private LayoutInflater inflater;
    private int resource;

    public MamaligaAdapter(@NonNull Context context, int resource,
                           List<Mamaliga> listaMamaligi,
                           LayoutInflater inflater) {
        super(context, resource, listaMamaligi);
        this.context=context;
        this.listaMamaligi=listaMamaligi;
        this.inflater=inflater;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource,parent,
                false);
        Mamaliga mamaliga = listaMamaligi.get(position);
        if(mamaliga!=null){
            //setam valorile pe textview-uri
            TextView tv1= view.findViewById(R.id.tvNumeRestaurant);
            TextView tv2= view.findViewById(R.id.tvCantitate);
            TextView tv3= view.findViewById(R.id.tvData);
            TextView tv4= view.findViewById(R.id.tvTipMalai);
            TextView tv5= view.findViewById(R.id.tvTipMamaliga);
            tv1.setText(mamaliga.getNumeRestaurant());
            tv2.setText(String.valueOf(mamaliga.getCantitate()));
            tv3.setText(new SimpleDateFormat("dd/MM/yyyy").format(mamaliga.getDataExpirare()));
            tv4.setText(String.valueOf(mamaliga.getTipMalai()));
            tv5.setText(String.valueOf(mamaliga.getTipMamaliga()));
        }

        return view;
    }
}

package en.ase.group1097;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Double> baniCheltuitiPeZile = new ArrayList<>();
        baniCheltuitiPeZile.add(2.5);
        baniCheltuitiPeZile.add(1.75);
        baniCheltuitiPeZile.add(3.25);
        baniCheltuitiPeZile.add(10.0);

        List<Double> rataNatalitate = new ArrayList<>();
        rataNatalitate.add(5.5);
        rataNatalitate.add(2.4);
        rataNatalitate.add(7.4);
        rataNatalitate.add(4.7);

        XYPlot plot= findViewById(R.id.myXYPlot);
        plot.setTitle("Grafic bani chestuiti si natalitate");

        XYSeries series1 = new SimpleXYSeries(baniCheltuitiPeZile,
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Bani cheltuiti");
        plot.addSeries(series1, new LineAndPointFormatter(getApplicationContext(),
                R.layout.formatter1));

        XYSeries series2 = new SimpleXYSeries(rataNatalitate,
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Natalitate");
        plot.addSeries(series2, new LineAndPointFormatter(getApplicationContext(),
                R.layout.formatter2));
    }
}
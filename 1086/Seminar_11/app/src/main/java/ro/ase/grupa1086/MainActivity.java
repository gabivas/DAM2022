package ro.ase.grupa1086;

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

        List<Double> rataDeDivort = new ArrayList<>();
        rataDeDivort.add(2.3);
        rataDeDivort.add(4.7);
        rataDeDivort.add(2.1);
        rataDeDivort.add(5.0);

        List<Double> rataDeDeces = new ArrayList<>();
        rataDeDeces.add(7.1);
        rataDeDeces.add(14.2);
        rataDeDeces.add(8.5);
        rataDeDeces.add(1.8);
        rataDeDeces.add(7.2);

        XYPlot plot = findViewById(R.id.myPlot);
        plot.setTitle("Grafic rata divort si rata deces");

        XYSeries series1 = new SimpleXYSeries(rataDeDivort,
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Rata divort");
        plot.addSeries(series1, new LineAndPointFormatter(getApplicationContext(),
                R.layout.formatter1));


        XYSeries series2 = new SimpleXYSeries(rataDeDeces,
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Rata deces");
        plot.addSeries(series2, new LineAndPointFormatter(getApplicationContext(),
                R.layout.formatter2));





    }
}
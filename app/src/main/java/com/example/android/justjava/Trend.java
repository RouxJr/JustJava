package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Trend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend);
        BarChart chart;
        try{
            chart = findViewById(R.id.gpTrend);
            chart = findViewById(R.id.gpTrend);

            ArrayList<BarEntry> entries = new ArrayList<>();
            entries.add(new BarEntry(44f , 0));
            entries.add(new BarEntry(60f , 1));
            entries.add(new BarEntry(79f , 2));
            entries.add(new BarEntry(20f , 3));
            entries.add(new BarEntry(50f ,4));
            BarDataSet dataSet = new BarDataSet(entries,"days");

            ArrayList<String> theDates = new ArrayList<>();
            theDates.add("Monday");
            theDates.add("Tuesday");
            theDates.add("Wednesday");
            theDates.add("Thursday");
            theDates.add("Friday");

            BarData data = new BarData(dataSet);
            try
            {
                chart.setData(data);
            }
            catch (Exception e)
            {

            }
        }catch (Exception e)
        {

        }







    }
}

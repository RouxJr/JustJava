package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class Trend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend);
        BarChart chart;
        chart = findViewById(R.id.chart);
        chart = findViewById(R.id.chart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(44 , 0));
        entries.add(new BarEntry(60 , 1));
        entries.add(new BarEntry(7 , 2));
        entries.add(new BarEntry(20 , 3));
        entries.add(new BarEntry(50 ,4));
        BarDataSet dataSet = new BarDataSet(entries,"days");

        ArrayList<String> theDates = new ArrayList<String>();
        theDates.add("Monday");
        theDates.add("Tuesday");
        theDates.add("Wednesday");
        theDates.add("Thursday");
        theDates.add("Friday");

        BarData data = new BarData(dataSet);

        chart.setData(data);
        String[] l = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
        IAxisValueFormatter label = new Labeling(l);
        chart.getAxisLeft().setValueFormatter(label);


    }
}

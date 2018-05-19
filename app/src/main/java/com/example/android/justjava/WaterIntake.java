package com.example.android.justjava;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;


public class WaterIntake extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);

        String[] deviceName = {"Bath","Shower","Toilet","Garden","Dish Washer","Washing Machine","jghjgkj","hjgkg"};
        int[] averageQtyForDevice = {5,6,2,2,5,8,5,6};
        final DeviceList deviceList = new DeviceList(this,deviceName,averageQtyForDevice);
        final TextView tvYourTotalUse = findViewById(R.id.tvYourUsedTotal);
        final ListView dLstv = findViewById(R.id.lstvDevices);
        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvYourTotalUse.setText("You used a total of "+deviceList.getTotalUsed() +" Litres today");
                Intent showGraph = new Intent(getApplicationContext(),Trend.class);
                startActivity(showGraph);
            }
        });
        dLstv.setAdapter(deviceList);

        tvYourTotalUse.setText("You used a total of "+deviceList.getTotalUsed()+" of litres today");
        dLstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(WaterIntake.this,deviceList.getItem(i)+" litres is the basic average",Toast.LENGTH_LONG+3).show();
                tvYourTotalUse.setText(""+deviceList.getTotalUsed());
            }
        });

        Button btnClear = findViewById(R.id.btnDone);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CodecentrixDBHelper cdh = new CodecentrixDBHelper(getBaseContext());
                Date date = new Date();
                cdh.addUsage(0,""+date.getDate(),""+date.getTime(),Integer.parseInt(tvYourTotalUse.getText().toString()));
            }
        });

        final Button btnC = findViewById(R.id.btnClear);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CodecentrixDBHelper cdh = new CodecentrixDBHelper(getBaseContext());
                Cursor c = cdh.GetUsageCursor();
                String s = ""+c.getString(1);
                btnC.setText(s);
            }
        });
    }

}

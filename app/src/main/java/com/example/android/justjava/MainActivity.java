package com.example.android.justjava;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] name = new String[6];
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //name

       int[] icon ={R.drawable.img_consumption,R.drawable.img_profile,R.drawable.img_leaderboard,R.drawable.img_report,R.drawable.img_tips,R.drawable.img_shop};
       Display screen = getWindowManager().getDefaultDisplay();

       final ListAdapter lstAdapter = new ListAdapter(this,name,icon,screen.getWidth(),getResources());
       ListView listView = findViewById(R.id.listView);
       listView.setAdapter(lstAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               //this validation is not the best it needs reconsidation
               if (i == 0)
               {

                   Intent showIntakeRecoder = new Intent(getApplicationContext(),WaterIntake.class) ;
                   startActivity(showIntakeRecoder);
               }

           }
       });

    }




}

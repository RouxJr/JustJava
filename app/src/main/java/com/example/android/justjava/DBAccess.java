package com.example.android.justjava;


import android.os.Looper;
import android.os.StrictMode;

import java.sql.*;
import  java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


public class DBAccess {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String errorMassage;
    public DBAccess()
    {



    }
    public boolean IsConnected()
    {
        return connection != null;
    }
    private void Connect()
    {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<WaterUsage> listWaterItem = null;
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String user = "codecentrix";
            Connection myCon;
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://10.103.137.7:1433/Codecentrix" , "codecentrix", "password");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ResultSet Select()
    {
        try
        {
            Statement st = connection.createStatement();

           resultSet = st.executeQuery("SELECT * FROM WaterUsageItem;");


            connection.close();
        }
        catch (SQLException e)
        {

        }
        return resultSet;
    }

    public String ErrorMassage()
    {
        return errorMassage;
    }
}

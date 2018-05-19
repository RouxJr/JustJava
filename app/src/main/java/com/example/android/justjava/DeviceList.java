package com.example.android.justjava;

import android.content.Context;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by User on 3/31/2018.
 */

public class DeviceList extends BaseAdapter {

    String[] dName;
    int[] dAverageQty;
    LayoutInflater mInflater;
    int total =0;
    public DeviceList(Context context,String[] DeviceName,int[] dAverageQty)
    {
        dName = DeviceName;
        this.dAverageQty = dAverageQty;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dName.length;
    }

    @Override
    public Object getItem(int i) {
        return dName[i] +": "+dAverageQty[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        v = mInflater.inflate(R.layout.device_adapter,null);

        final CheckBox cbDeviceName = v.findViewById(R.id.cbDevieName);
        final EditText txtAvgQty = v.findViewById(R.id.txtQty);
        final LinearLayout dropLayout = v.findViewById(R.id.loQtyDetails);
        dropLayout.setVisibility(View.INVISIBLE);

        cbDeviceName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbDeviceName.isChecked())
                {
                    dropLayout.setVisibility(View.VISIBLE);
                    total+= Integer.parseInt(txtAvgQty.getText().toString());

                }
                else
                {
                    dropLayout.setVisibility(View.INVISIBLE);
                    total-= Integer.parseInt(txtAvgQty.getText().toString());
                }
            }
        });



        final int index =i;
        cbDeviceName.setText(dName[i]);
        txtAvgQty.setText(""+dAverageQty[i]);

        Button btnAdd = v.findViewById(R.id.btnAddQty);
        Button btnMinus = v.findViewById(R.id.btnMinusQty);
        final TextView tvQty = v.findViewById(R.id.tvTotalQty);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = Integer.parseInt(tvQty.getText().toString())+1;
                tvQty.setText(""+q);

                int a =dAverageQty[index] *q;
                txtAvgQty.setText(""+a);
                total+= dAverageQty[index];
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = Integer.parseInt(tvQty.getText().toString());
                if(q>1)
                {
                    q-=1;
                }
                tvQty.setText(""+q);

                int a =dAverageQty[index] *q;

                txtAvgQty.setText(""+a);
                total-= dAverageQty[index];

            }
        });



        return v;
    }

    public int getTotalUsed()
    {
        return total;
    }
}

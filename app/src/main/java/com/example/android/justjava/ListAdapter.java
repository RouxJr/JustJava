package com.example.android.justjava;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Size;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by User on 3/3/2018.
 */

public class ListAdapter extends BaseAdapter {

    String[] name;
    int[] icon;
    int screenWidth;
    Resources res;
    LayoutInflater mInflater;
    Context c;

    public ListAdapter(Context c,String[] ActivityName,int[] icon,int screenWidth,Resources res)
    {
        this.c = c;
        name = ActivityName;
        this.icon = icon;
        this.screenWidth = screenWidth;
        this.res = res;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public ListAdapter(Context c,String[] ActivityName,int[] icon)
    {
        this.c = c;
        name = ActivityName;
        this.icon = icon;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    private void onIntakeClick()
    {

    }
    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return name[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        View v = mInflater.inflate(R.layout.activity_menu_list,null);
        TextView tvName = v.findViewById(R.id.textView);
        ImageView imageIcon =  v.findViewById(R.id.imgIcon);

        tvName.setText(name[i]);
        try
        {
            imageIcon.setImageBitmap(ScaleImg(icon[i]));
        }
        catch (Exception e)
        {
            imageIcon.setImageResource(icon[i]);
        }

        return v;
    }


    public Bitmap ScaleImg(int pic)
    {
        Bitmap scaledImg;
        BitmapFactory.Options op = new BitmapFactory.Options();

        op.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,pic,op);

        int imgWidth = op.outWidth;
        if(imgWidth>1500)
        {
            op.inSampleSize = 20;
        }
        else if(imgWidth>500)
        {
           op.inSampleSize = 5;
        }
        else if(imgWidth>400)
        {
            op.inSampleSize = 4;
        }
        else if(imgWidth>300)
        {
            op.inSampleSize = 3;
        }
        else
        {
            op.inSampleSize = 2;
        }


        op.inJustDecodeBounds = false;
        scaledImg = BitmapFactory.decodeResource(res,pic,op);

        return scaledImg;
    }


}

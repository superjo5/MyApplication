package com.example.superjowtf.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SuPerJoWTF on 23/2/2560.
 */
//Activity นี้สร้างเพื่อทำ Layout เสมือน

public class MyAdapter extends BaseAdapter  {

    //Explicit
    private Context context;
    private int[] ints;
    private String[] titleStrings, detailStrings;

    // กด alt+insert เลือก Constructer แล้วเลือกทั้งหมด ก็จะได้แบบนี้
    public MyAdapter(Context context, int[] ints, String[] titleStrings, String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }



    @Override
    public int getCount() { //นับจำนวนข้อมูลว่ามีกี่ข้อมูล แล้วส่งไปทำงานต่อที่ getView
        return ints.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //รับจำนวนข้อมูลแล้วแสดงผลต่อบนหน้าแอพ

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);

        //Initial View
        ImageView imageView = (ImageView) view.findViewById(R.id.imvIcon);
        TextView titleTextView = (TextView) view.findViewById(R.id.txtTitleLiv);
        TextView DetailTextView = (TextView) view.findViewById(R.id.txtDetailLiv);

        //Show View นำข้อมูลไปแสดงผลบนหน้าเว็บ
        imageView.setImageResource(ints[position]);
        titleTextView.setText(titleStrings[position]);
        DetailTextView.setText(detailStrings[position]);

        return view;
    }
}  //Main Class

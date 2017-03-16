package com.example.superjowtf.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
            R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06, R.drawable.traffic_07,
            R.drawable.traffic_08, R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11,
            R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
            R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19,
            R.drawable.traffic_20};

    private String[] titleStrings, detailStrings, shortString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initail View ผูกตัวแปรกับไอดีของ View
        listView = (ListView) findViewById(R.id.livTraffic);

        //Get Value
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        //SubString detailString ตัดคำใน detail string เพื่อไม่ให้เกิน 30 Character
        shortString = new String[detailStrings.length]; //จองพื้นที่ในหน่วยความจำตัวแปร shortString
        for (int i=0; i < detailStrings.length; i++) {
            shortString[i] = detailStrings[i].substring(0, 29) + "...";

        } //end for

        //Create ListView
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,ints ,titleStrings,shortString);
        listView.setAdapter(myAdapter);

        //Active when click List View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//เมื่อมีการคลิ๊กข้อมูลที่ตำแหน่งใด จะเก็บข้อมูลจากการคลิก
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Detail", detailStrings[position]);
                intent.putExtra("Image", ints[position]);
                startActivity(intent);
            }
        });

    }   //Main Method onCreate

    public void onClickMoreInfo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/"));
        startActivity(intent);
    }//Main Method onClickMoreInfo

    public void onClickAbout_me (View view){
        Intent intent = new Intent(MainActivity.this, About_me.class);
        startActivity(intent);
    }
}   //Main Class

package com.example.superjowtf.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initial View
        TextView titleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        TextView DetailTextView = (TextView) findViewById(R.id.txtDetailScroll);
        ImageView imageView = (ImageView) findViewById(R.id.imvImmageDetail);
        Button button = (Button) findViewById(R.id.btnBack);

        //รับข้อมูลจาก Main Activity มาแสดงผลบน Detail

        titleTextView.setText(getIntent().getStringExtra("Title"));
        DetailTextView.setText(getIntent().getStringExtra("Detail"));
        imageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.traffic_01));



    } //Main Method

    public void clickBack(View view) {
        finish();
    }


} //Main Class

package com.example.superjowtf.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class About_me extends AppCompatActivity {

    //Explicit
    MediaPlayer mediaPlayer;
    int soundID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        TextView phoneTextView = (TextView) findViewById(R.id.txtTel);
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:0828129224"));
                startActivity(phoneIntent);
            }
        });

        //Toast onClick
        ImageView clickImageView = (ImageView) findViewById(R.id.imvMypic);
        clickImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hi My Name Is Wirattapong",Toast.LENGTH_SHORT).show();
                //Show sound1 when click image
                soundID = R.raw.sound0;
                playSound(soundID);
            }
        });

        //Toast onLongClick
        ImageView longClickImageView = (ImageView) findViewById(R.id.imvMypic);
        longClickImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Fuxx You Very Much",Toast.LENGTH_SHORT).show();
                //Show sound1 when click image
                soundID = R.raw.sound3;
                playSound(soundID);
                return true;
            }
        });

    }

    private void playSound(int soundID) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), soundID);
        mediaPlayer.start();
    }

    public void clickBack(View view) {
        finish();
    }

    public void onClickFace(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/jowirattapong.kasemruangsakul"));
        startActivity(intent);
    }
}

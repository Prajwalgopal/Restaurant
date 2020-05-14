package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class basicinfo extends AppCompatActivity { // BASIC INFORMATION OF THE RESTAURANT
    //DECLARATION OF XML OBJECTS

    //private ImageView im1;
    private TextView name1,address,tel,email;
    private Button km;
    private Customlist data;
private ImageView image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicinfo);

//Wiring the objects of XML

        //im1=findViewById(R.id.imageView2);
        name1=findViewById(R.id.textView4);
        address=findViewById(R.id.textView12);
        tel=findViewById(R.id.textView14);
        email=findViewById(R.id.textView16);
        km=findViewById(R.id.km);
        image2=findViewById(R.id.imageView2);



        final Intent intent = getIntent();
        final Bundle bundle= intent.getExtras();


        data=(Customlist)bundle.getSerializable("data");

        name1.setText(data.getIntro());
        address.setText(data.getAddress());
        tel.setText(data.tele);
        email.setText(data.getEmail());



// To access the images from a single destination
        AssetManager assetManager = getAssets();
        Bitmap bitmap;

        InputStream inputStream;
        try {

            inputStream = assetManager.open(data.getId()+"/"+data.getImage2());
            bitmap = BitmapFactory.decodeStream(inputStream);
            image2.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }



        km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(basicinfo.this,Final.class);
                Bundle bundle1=new Bundle();
                bundle1.putSerializable("data1",data);

                intent1.putExtras(bundle1);
                startActivity(intent1);


            }
        });



    }
}

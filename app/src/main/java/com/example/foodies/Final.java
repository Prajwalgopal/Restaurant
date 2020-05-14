package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Final extends AppCompatActivity { //DETAILED INFORMATION OF THE RESTAURANT

    //DECLARATION OF XML OBJECTS

    private TextView desc;
    private Button call;
    private Button mail;
    private Button book;
    private Customlist data;
    private ImageView image3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);






        desc=findViewById(R.id.textView19);
        final Intent intent1 = getIntent();
        final Bundle bundle1= intent1.getExtras();


        image3=findViewById(R.id.imageView5);


        // To access the images from a single destination

        AssetManager assetManager = getAssets();
        Bitmap bitmap;
        data=(Customlist)bundle1.getSerializable("data1");
        InputStream inputStream=null;
        try {

            inputStream = assetManager.open(data.getId()+"/"+data.getImage3());
            bitmap = BitmapFactory.decodeStream(inputStream);
            image3.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }





        desc.setText(data.getDesc());

        book=findViewById(R.id.button6);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(Final.this,WebView.class);
                Bundle bundle5=new Bundle();
                bundle5.putSerializable("data",data);

                intent3.putExtras(bundle5);
                startActivity(intent3);
            }
        });




        //CALL FUNCTIONALITY
        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialContactPhone(data.getTele());


            }
        });

        //MAIL FUNCTIONALITY

        findViewById(R.id.email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendemail(data.getEmail());


            }
        });

    }



    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
    private void sendemail(final String eMail) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL , new String[]{eMail});
        i.putExtra(Intent.EXTRA_SUBJECT, "");
        i.putExtra(Intent.EXTRA_TEXT, "");//message is your details

            startActivity(Intent.createChooser(i, "Send mail..."));





    }
}

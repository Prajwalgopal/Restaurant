package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Restolist extends AppCompatActivity {  // CUSTOM LIST OF RESTAURANTS
    private ListView list;
    private Foodxml data;
    List<Customlist> food;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restolist);
        food=new ArrayList<>();
        data=new Foodxml(getApplicationContext());




        for(int i=0; i<data.getLength();i++) {
            food.add(data.getfood(i));
        }
        list=(ListView)findViewById(R.id.listview);

        RestListAdapater adapter= new RestListAdapater(this,R.layout.custom_row_layout,food);
        Log.e("$$$$","checkmainactivity");
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(Restolist.this,basicinfo.class);
                Bundle bundle= new Bundle();
                bundle.putSerializable("data",data.getfood(i));

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



        }


    }



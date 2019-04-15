package com.example.charitable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Charity extends AppCompatActivity {

    ListView charityList;

    ArrayAdapter<String> charityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);

        charityList = findViewById(R.id.charityList);

        charityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.charityArray));
        charityList.setAdapter(charityAdapter);

        charityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Start Activity Position
                startActivity(new Intent(Charity.this,CharityScreen.class));
            }
        });
    }
}

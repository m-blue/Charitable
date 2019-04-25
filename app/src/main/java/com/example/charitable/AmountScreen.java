package com.example.charitable;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AmountScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_screen);

        TextView TotalAmount = findViewById(R.id.txtTotalAmount);

        SharedPreferences setting = getSharedPreferences("AmountPreference" , MODE_PRIVATE);
        float tA = setting.getFloat("Amount", 0f);
        TotalAmount.setText(Float.toString(tA));
    }
}

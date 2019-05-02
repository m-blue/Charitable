package com.example.charitable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CharityScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_screen);

        Button btnDonate = findViewById(R.id.btnCharityDonate);
        final EditText amountEdit = findViewById(R.id.txtAmount);
        TextView txtSummary = findViewById(R.id.txtSummary);

        Bundle bundle = getIntent().getExtras();
        int location = bundle.getInt("location");
        String[] s = getResources().getStringArray(R.array.txtSummary);
        txtSummary.setText(s[location]);



        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences setting = getSharedPreferences("AmountPreference", MODE_PRIVATE);
                SharedPreferences.Editor editor = setting.edit();
                float numAmount = Float.parseFloat(amountEdit.getText().toString());
                float amount = setting.getFloat("Amount",0f);
                amount += numAmount;
                editor.putFloat("Amount",amount);
                editor.commit();

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://donate.doctorswithoutborders.org/onetime.cfm"))); // TODO: Set this to different urls
            }
        });
    }
}

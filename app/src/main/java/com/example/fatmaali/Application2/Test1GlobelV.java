package com.example.fatmaali.Application2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Test1GlobelV extends AppCompatActivity {
    TextView txt_Go_Next, txtDicemalFormat;
    GlobalV globalV;

    DecimalFormat NumDecimalFormat = new DecimalFormat("000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1_globel_v);
        globalV = (GlobalV) getApplicationContext();
        txt_Go_Next = (TextView) findViewById(R.id.txt_go_next);
        txtDicemalFormat = (TextView) findViewById(R.id.txt_DicemalFormat);

        String name = globalV.getName();
        int num = globalV.getNum();
        txt_Go_Next.setText(num + "_" + name);
    }

    public void btn_GoNext(View view) {
        globalV.setName("Osama");
        int n = globalV.getNum();
        n++;
        globalV.setNum(n);
        startActivity(new Intent(getApplicationContext(), Test2GlobelV.class));
    }

    public void btn_DicemalFormat(View view) {
        txtDicemalFormat.setText(NumDecimalFormat.format(20));
    }
}

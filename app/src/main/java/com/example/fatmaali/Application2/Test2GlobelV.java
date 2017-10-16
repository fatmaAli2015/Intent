package com.example.fatmaali.Application2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Test2GlobelV extends AppCompatActivity {
    TextView txt_Go_Back;
    GlobalV globalV;
    int num;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2_globel_v);

        listView=(ListView) findViewById(R.id.listview_simple);
        List ls = new ArrayList();
//
//        for(int i=0;i<50;i++){
//            ls.add(i+"- New List ");
//        }
        String [] colors = getResources().getStringArray(R.array.colors);

      //  ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,colors);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.item,R.id.textView_item,colors);
        listView.setAdapter(arrayAdapter);

        globalV = (GlobalV)getApplicationContext();
        txt_Go_Back=(TextView)findViewById(R.id.txt_go_back);
        String name = globalV.getName();
         num = globalV.getNum();
        txt_Go_Back.setText( num +"_"+ name);

    }

    public void btn_GoBack(View view) {
       String[] arrayname = {"fatma","ali","ibrahim","gamal","elDen"};
        globalV.setName(arrayname[num-1]);
        int n =  globalV.getNum();
        n++;
        globalV.setNum(n);

      startActivity(new Intent(getApplicationContext(),Test1GlobelV.class));
    }
}

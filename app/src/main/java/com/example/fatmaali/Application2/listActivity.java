package com.example.fatmaali.Application2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {
    ListView listviewCustomList;
    int[] images={R.drawable.download,R.drawable.download1,R.drawable.download2,R.drawable.download3,R.drawable.bg};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listviewCustomList=(ListView)findViewById(R.id.listviewCustomList);

        String[] colors=getResources().getStringArray(R.array.colors);

        ArrayList<listitem> listitems= new ArrayList<listitem>();

        for (int i =0 ;i<colors.length ;i++){
            listitems.add(new listitem(i,images[i],colors[i]));
            ListAdapter LAdapter =new ListAdapter(listitems);
            listviewCustomList.setAdapter(LAdapter);

            listviewCustomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView name = (TextView)view.findViewById(R.id.textView_item);
                    Toast.makeText(getApplicationContext(),name.getText(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    class ListAdapter extends BaseAdapter{
        ArrayList<listitem> list = new ArrayList<listitem>();
        ListAdapter(ArrayList<listitem> list){
          this.list=list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i).name;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View viewc, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.item,null);
            TextView id = (TextView)view.findViewById(R.id.textView_itemid);
            final ImageView img= ( ImageView)view.findViewById(R.id.imageView_customList);
            final TextView name = (TextView)view.findViewById(R.id.textView_item);

            id.setText(String.valueOf(list.get(i).id));
            img.setImageResource(list.get(i).img);
            name.setText(list.get(i).name);
            final int click = i;
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),click+"image",Toast.LENGTH_LONG).show();
                }
            });
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"name",Toast.LENGTH_LONG).show();
                }
            });

            return view;
        }
    }

}

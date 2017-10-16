package com.example.fatmaali.Application2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Image_Inside_Text extends AppCompatActivity {
    TextView textView;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__inside__text);
        textView=(TextView) findViewById(R.id.textView_inside_image);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.download1);
        textView.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT,Shader.TileMode.REPEAT));
        //textView.getPaint().setColor(new Paint().getColor());  // not working
    }
}

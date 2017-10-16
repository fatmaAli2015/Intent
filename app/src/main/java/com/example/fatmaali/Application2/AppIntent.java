package com.example.fatmaali.Application2;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AppIntent extends AppCompatActivity {
    EditText numTxt;
    String sNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_intent);
        numTxt=(EditText)findViewById(R.id.edtxt_tel);
    }

    public void btn_webURL(View view) {
        Intent webUrl = new Intent(Intent.ACTION_VIEW);
        webUrl.setData(Uri.parse("http://www.youtube.com"));
        if (webUrl.resolveActivity(getPackageManager()) != null){
            startActivity(webUrl);
        }
    }

    public void btn_telephone(View view) {
        Intent telphone = new Intent(Intent.ACTION_DIAL);
        sNum = numTxt.getText().toString();
        if(sNum.trim().isEmpty()){
            telphone.setData(Uri.parse("tel: 20280296"));
        }else {
            telphone.setData(Uri.parse("tel:" + sNum ));
        }
        if(telphone.resolveActivity(getPackageManager()) != null){
            startActivity(telphone);
        }
    }

    public void btn_googleMap(View view) {
       Intent googleMap = new Intent(Intent.ACTION_VIEW);
       googleMap.setData(Uri.parse("geo:47.4925, 19.0513?z=17"));
        Intent choosergoogleMap= Intent.createChooser(googleMap,"launch Map");
       if(googleMap.resolveActivity(getPackageManager()) != null){
            startActivity(choosergoogleMap);
        }
    }


    public void btn_ShImage(View view) {
       Intent intentsh_image = new Intent(getApplicationContext(),Photo_Gallery.class);
        if(intentsh_image.resolveActivity(getPackageManager()) != null){
            startActivity(intentsh_image);
        }
    }

    public void btn_shM_Image(View view) {
        Intent intentShMImages = new Intent(getApplicationContext(),Multi_photo.class);
        if(intentShMImages.resolveActivity(getPackageManager()) != null){
            startActivity(intentShMImages);
        }
    }

    public void btn_email(View view) {
        try {
            String[] emails={"fatmaaliibrahim2015@gmail.com","fatmaaliibrahim1994@yahoo.com"};
            Intent intentEmail = new Intent(Intent.ACTION_SEND);
            intentEmail.setData(Uri.parse("email"));
            intentEmail.setType("message/rfc822");
            intentEmail.putExtra(Intent.EXTRA_EMAIL,emails);
            intentEmail.putExtra(Intent.EXTRA_TEXT,"this is a message");
            intentEmail.putExtra(Intent.EXTRA_SUBJECT,"Message");
            if (intentEmail.resolveActivity(getPackageManager()) !=null){
                startActivity(intentEmail);
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Not found this app",Toast.LENGTH_LONG).show();
        }
    }

    public void btn_shText(View view) {
        Intent intentShText = new Intent(Intent.ACTION_SEND)
                .putExtra(Intent.EXTRA_TEXT," Welcome")
                .setType("text/plain");
        startActivity(Intent.createChooser(intentShText,"Launch Text"));
    }

    public void btn_alarm(View view) {
        Intent intentAlarm = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,"Alarm")
                .putExtra(AlarmClock.EXTRA_LENGTH,5)
                .putExtra(AlarmClock.EXTRA_SKIP_UI,true);
        if (intentAlarm.resolveActivity(getPackageManager())!=null){
            startActivity(intentAlarm);
        }
    }
}

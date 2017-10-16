package com.example.fatmaali.Application2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Multi_photo extends AppCompatActivity {
    ImageView img1,img2,img3,img4;
    ArrayList<Uri> imageUris = new ArrayList<Uri>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_photo);
        img1=(ImageView)findViewById(R.id.imageView1);
        img2=(ImageView)findViewById(R.id.imageView2);
        img3=(ImageView)findViewById(R.id.imageView3);
        img4=(ImageView)findViewById(R.id.imageView4);
    }

    public void img1(View view) {
        Intent intentImg1= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if(intentImg1.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intentImg1,1);
        }
    }

    public void img2(View view) {
       Intent intentImg2 = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if(intentImg2.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intentImg2,2);
        }
    }

    public void img3(View view) {
        Intent intentImg3 = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if(intentImg3.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intentImg3,3);
        }
    }

    public void img4(View view) {
        Intent intentImg4= new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if(intentImg4.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intentImg4,4);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==1){
                imageUris.add(data.getData());
                img1.setImageURI(data.getData());
            }
            if(requestCode==2){
                imageUris.add(data.getData());
                img2.setImageURI(data.getData());
            }
            if(requestCode==3){
                imageUris.add(data.getData());
                img3.setImageURI(data.getData());
            }
            if(requestCode==4){
                imageUris.add(data.getData());
                img4.setImageURI(data.getData());
            }
        }
    }

    public void btn_MultiImages(View view) {
        Intent intentShMultiImage = new Intent(Intent.ACTION_SEND_MULTIPLE);
        intentShMultiImage.putParcelableArrayListExtra(Intent.EXTRA_STREAM,imageUris);
        intentShMultiImage.setType("image/*");
        Intent chooserIntentMultiImage = Intent.createChooser(intentShMultiImage,"launch share Multi Image");
        if(chooserIntentMultiImage.resolveActivity(getPackageManager()) != null){
            startActivity(chooserIntentMultiImage);
        }
    }
}

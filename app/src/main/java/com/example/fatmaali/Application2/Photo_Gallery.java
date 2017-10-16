package com.example.fatmaali.Application2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Photo_Gallery extends AppCompatActivity {

    ImageView imageViewGalleryShare;
    int GNum=1;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo__gallery);
        imageViewGalleryShare=(ImageView)findViewById(R.id.imageViewShareImage);
    }

    public void btn_gallery(View view) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery,GNum);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GNum && resultCode==RESULT_OK){
            uri=data.getData();
            imageViewGalleryShare.setImageURI(uri);
        }
    }

    public void btn_ph_Image(View view) {
        Intent intentPh_Image = new Intent(Intent.ACTION_SEND);
        intentPh_Image.setType("image/*");
        intentPh_Image.putExtra(Intent.EXTRA_STREAM,uri);
        intentPh_Image.putExtra(Intent.EXTRA_TEXT,"Launch Image");
        Intent chooserintentPh_Image = Intent.createChooser(intentPh_Image,"Launch Image");
        if(chooserintentPh_Image.resolveActivity(getPackageManager())!= null){
            startActivity(chooserintentPh_Image);
        }
    }
}

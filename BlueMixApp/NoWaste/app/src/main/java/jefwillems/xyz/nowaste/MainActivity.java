package jefwillems.xyz.nowaste;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ibm.watson.developer_cloud.android.library.camera.GalleryHelper;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    //private GalleryHelper gHelper = new GalleryHelper(MainActivity.this);
    //private File imageFile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//                Drawable d = getResources().getDrawable(R.drawable.fruitbowl, getTheme());
//                BitmapDrawable bmd = (BitmapDrawable) d;
//                Bitmap bitmap = bmd.getBitmap();
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//                byte[] imageInByte = stream.toByteArray();
//                ByteArrayInputStream bis = new ByteArrayInputStream(imageInByte);
        /*ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                112);
        gHelper.dispatchGalleryIntent();*/

    }

    public void goToken(View view) {
        Intent intent = new Intent(this, TokenActivity.class);
        startActivity(intent);
    }

    public void capture(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GalleryHelper.PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            this.imageFile = gHelper.getFile(resultCode, data);
            sendRequest();
        }
    }

    private void sendRequest() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20, "e18fd6df252ff388f1cb14fe0b2464f4e6803d68");
                ClassifyOptions classifyOptions;
                try {
                    classifyOptions = new ClassifyOptions.Builder()
                            .imagesFile(imageFile)
                            .build();
                    Log.i("OPTIONS: ", classifyOptions.toString());

                    ClassifiedImages result = service.classify(classifyOptions).execute();
                    Log.i("RESULT: ", result.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (BadRequestException ex) {
                    Log.e("BAD REQUEST: ", ex.getMessage(), ex);
                }
            }
        });

    }*/
}

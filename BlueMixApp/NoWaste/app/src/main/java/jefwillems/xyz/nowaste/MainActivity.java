package jefwillems.xyz.nowaste;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20, "e18fd6df252ff388f1cb14fe0b2464f4e6803d68");
                ClassifyOptions classifyOptions;
                Drawable d = getResources().getDrawable(R.drawable.fruitbowl, getTheme());
                BitmapDrawable bmd = (BitmapDrawable) d;
                Bitmap bitmap = bmd.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] imageInByte = stream.toByteArray();
                ByteArrayInputStream bis = new ByteArrayInputStream(imageInByte);

                classifyOptions = new ClassifyOptions.Builder()
                        .imagesFile(bis)
                        .parameters("{\"classifier_ids\": [\"fruits_1462128776\","
                                + "\"SatelliteModel_6242312846\"],"
                                + "\"owners\": [\"IBM\", \"me\"]}")
                        .build();
                try {
                    ClassifiedImages result = service.classify(classifyOptions).execute();
                    Log.i("RESULT: ", result.toString());
                } catch (BadRequestException ex) {
                    Log.e("BAD REQUEST: ", ex.getMessage(), ex);
                }
            }
        });

    }

    public void goToken(View view) {
        Intent intent = new Intent(this, TokenActivity.class);
        startActivity(intent);
    }

    public void capture(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }


}

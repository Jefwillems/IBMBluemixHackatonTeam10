package jefwillems.xyz.nowaste;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        ClassifyOptions classifyOptions = null;

        try {
            classifyOptions = new ClassifyOptions.Builder()
                    .imagesFile(new File("../../res/drawable/fruitbowl.jpg"))
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ClassifiedImages result = service.classify(classifyOptions).execute();
        System.out.print(result);
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

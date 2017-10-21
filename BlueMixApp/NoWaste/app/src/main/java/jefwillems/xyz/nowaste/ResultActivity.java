package jefwillems.xyz.nowaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void goScanFromResult(View view) {
        finish();
    }


    public void goTokenFromResult(View view) {
        Intent intent = new Intent(this, TokenActivity.class);
        startActivity(intent);
    }
}

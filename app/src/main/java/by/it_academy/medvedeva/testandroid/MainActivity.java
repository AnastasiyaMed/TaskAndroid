package by.it_academy.medvedeva.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Medvedeva Anastasiya
 * on 24.07.2017.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    private final static String TAG = "MainActivity";
    private TextView wonder;
    private TextView day;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");

        final Button helloButton = (Button) findViewById(R.id.hello_button);
        wonder = (TextView) findViewById(R.id.wonderful_text);
        day = (TextView) findViewById(R.id.day_text);
        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchTextInTextView(wonder, day);
            }
        };

        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchTextInTextView(wonder, day);
            }
        });
        wonder.setOnClickListener(this);
        day.setOnClickListener(listener);
    }


    private void switchTextInTextView(TextView wonder, TextView day) {
        String temp = wonder.getText().toString();
        wonder.setText(day.getText().toString());
        day.setText(temp);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    public void onClick(View v) {
        switchTextInTextView(wonder, day);
    }
}

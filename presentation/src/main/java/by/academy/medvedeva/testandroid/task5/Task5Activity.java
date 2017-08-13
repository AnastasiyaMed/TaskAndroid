package by.academy.medvedeva.testandroid.task5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 07.08.2017.
 */

public class Task5Activity extends Activity {
    BroadcastReceiver receiver;
    Intent intent;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);
        textView = (TextView) findViewById(R.id.stateText);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String wifiStatus = intent.getStringExtra("wifi connection");
                if (wifiStatus.equals("wifi connection is on")) {
                    textView.setText("wifi connection is on");
                } else {
                    textView.setText("wifi connection is off");
                }
            }
        };

    }


    @Override
    protected void onStart() {
        super.onStart();
        intent = new Intent(this, Task5Service.class);
        startService(intent);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("wifi connection");
        registerReceiver(receiver, intentFilter);
        Log.d("AAAA", "onStart() in Task5Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(intent);
        unregisterReceiver(receiver);
    }
}

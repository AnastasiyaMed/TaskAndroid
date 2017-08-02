package by.it_academy.medvedeva.testandroid.classwork5;

import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.it_academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 02.08.2017.
 */

public class Classwork5Activity extends Activity {
    private MyBroadcastReceiver receiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}

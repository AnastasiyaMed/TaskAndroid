package by.it_academy.medvedeva.testandroid.classwork5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import by.it_academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 02.08.2017.
 */

public class Classwork5Activity extends Activity {
    private int i = 0;
    private TextView broadText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);

        broadText = (TextView) findViewById(R.id.broad_text);

        Intent intent1 = new Intent(Classwork5Activity.this, MyIntentService.class);
        intent1.putExtra(MyIntentService.KEY_ACTION, "task 1");
        startService(intent1);

        Intent intent2 = new Intent(Classwork5Activity.this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACTION, "task 2");
        startService(intent2);

        Intent intent3 = new Intent(Classwork5Activity.this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_ACTION, "task 3");
        startService(intent3);


        broadText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Classwork5Activity.this, MyService.class);
                stopService(intent);
            }
        });
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("AAA", "onReceive");
//            Bundle extras = intent.getExtras();
//
//            NetworkInfo info = extras.getParcelable("networkInfo");
//
//            NetworkInfo.State state = info.getState();
//            Log.d("TEST Internet", info.toString() + ""
//                    + state.toString());
//
//            if (state == NetworkInfo.State.CONNECTED) {
//                Toast.makeText(getApplicationContext(), "Internet connection is on", Toast.LENGTH_LONG).show();
//
//            } else {
//                Toast.makeText(getApplicationContext(), "Internet connection is Off", Toast.LENGTH_LONG).show();
//            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(MyIntentService.MY_ACTION);
        registerReceiver(receiver, intentFilter);
        Intent intent = new Intent(Classwork5Activity.this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);

        unbindService(serviceConnection);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("AAA", "onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("AAA", "onServiceDisconnected()");
        }
    };

}

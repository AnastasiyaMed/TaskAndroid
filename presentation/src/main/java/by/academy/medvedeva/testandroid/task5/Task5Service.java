package by.academy.medvedeva.testandroid.task5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Medvedeva Anastasiya
 * on 11.08.2017.
 */

public class Task5Service extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("AAAA", "onCreate");
        Toast.makeText(getBaseContext(), "onCreate Service", Toast.LENGTH_SHORT).show();

    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();

            NetworkInfo info = extras.getParcelable("networkInfo");


            NetworkInfo.State state = info != null ? info.getState() : null;

            Log.d("AAAA", "onReceive: info = " + info);

            Intent intentForActivitySendState = new Intent("wifi connection");

            if (state == NetworkInfo.State.CONNECTED) {
                Toast.makeText(getBaseContext(), "wifi connection is on", Toast.LENGTH_SHORT).show();
                intentForActivitySendState.putExtra("wifi connection", "wifi connection is on");
            } else {
                Toast.makeText(getBaseContext(), "wifi connection is off", Toast.LENGTH_SHORT).show();
                intentForActivitySendState.putExtra("wifi connection", "wifi connection is off");
            }
            sendBroadcast(intentForActivitySendState);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("AAAA", "onStartCommand");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(receiver, intentFilter);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        Log.d("AAAA", "onDestroy");
    }
}

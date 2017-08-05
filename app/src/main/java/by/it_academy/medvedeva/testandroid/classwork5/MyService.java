package by.it_academy.medvedeva.testandroid.classwork5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Medvedeva Anastasiya
 * on 02.08.2017.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("AAAA", "onCreateService");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("AAAA", "onBindService");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("AAAA", "onUnbindService");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("AAAA", "onStartCommandService");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("AAAA", "onDestroyService");
        super.onDestroy();
    }
}

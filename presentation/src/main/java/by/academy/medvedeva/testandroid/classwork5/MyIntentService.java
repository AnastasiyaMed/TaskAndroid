package by.academy.medvedeva.testandroid.classwork5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Medvedeva Anastasiya
 * on 02.08.2017.
 */

//  1. РАБОТАЕТ В ОТДЕЛЬНОМ ПОТОКЕ.
// 2. ЭТО ОЧЕРЕДЬ ЗАДАЧ
// 3. САМ ВЫКЛЮЧАЕТСЯ (вызывает OnDestroy) после выполнения всех задач
public class MyIntentService extends IntentService {
    public static final String KEY_ACTION = "KEY_ACTION";


    public static final String MY_ACTION = "by.it_academy.medvedeva.testandroid.classwork5.MY_ACTION";

    public MyIntentService() {
        super("MyIntentServise");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getStringExtra(KEY_ACTION);

        //    Log.e("AAA", "onHandleIntent() action = " + action);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intentReceiver = new Intent(MY_ACTION);
        // здесь используется глобальный BrodcasrtReceiver
        // можно использовать локальный, его надо чуть чуть по другому объявить
        sendBroadcast(intentReceiver);
    }
}

package by.academy.medvedeva.testandroid;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import by.academy.medvedeva.testandroid.datainjection.AppComponent;
import by.academy.medvedeva.testandroid.datainjection.AppModule;
import by.academy.medvedeva.testandroid.datainjection.DaggerAppComponent;

/**
 * Created by Medvedeva Anastasiya
 * on 31.07.2017.
 */

public class LeakCanaryTool extends Application {

    public static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }
}


package by.academy.medvedeva.testandroid.classwork7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.databinding.ActivityClasswork7Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 07.08.2017.
 */

public class Classwork7Activity extends Activity {
    // класс ОбсерваблФилд следит за изменениями состояния переменной
    public ObservableField<String> myText = new ObservableField<>("It's awesome news!! My project works!");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // сетает активити в xml
        ActivityClasswork7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork7);
        binding.setActivity(this);
        //можно получать доступ к элементам вью и в активити
        binding.awesomeTextView.getText();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    final int a = i;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myText.set(String.valueOf(a));
                        }
                    });
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

package by.academy.medvedeva.testandroid.task7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.databinding.ActivityTask7Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 13.08.2017.
 */

public class Task7Activity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // сетает активити в xml
        ActivityTask7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_task7);

        User user = new User();
        User.setPhoto(binding.photoImage, "http://www.ljplus.ru/img4/v/i/visla/bwerro26.jpg");
        user.setAge("22");
        user.setFullName("Сидоров Василий Вячеславович");
        user.setSex("man");

        binding.setUser(user);
    }

}

package by.academy.medvedeva.testandroid.task7;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.databinding.ActivityTask7Binding;

/**
 * Created by Medvedeva Anastasiya
 * on 17.08.2017.
 */

public class Task7Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTask7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_task7);

        User user = new User();
        user.setPhoto("http://pikchyriki.net/avatar/minony/100/46.jpg");
        user.setFullName("Pupkin Vasili Alibabaevich");
        user.setAge(45);
        user.setSex("man");

        binding.setUser(user);
    }

    @BindingAdapter("bind:src")
    public static void setPhoto(ImageView photoImage, String imageUrl) {
        Glide.with(photoImage.getContext()).load(imageUrl).into(photoImage);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

}

package by.academy.medvedeva.testandroid.task9;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import by.academy.medvedeva.testandroid.base.BaseViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 21.08.2017.
 */

public class ImageViewModel implements BaseViewModel {
    private ObservableField<String> url;

    public ObservableField<String> getUrl() {
        return url;
    }

    public void setUrl(ObservableField<String> url) {
        this.url = url;
    }

    public ImageViewModel(ObservableField<String> url) {
        this.url = url;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
    }

    @BindingAdapter("bind:src")
    public static void setPhoto(ImageView photoImage, String imageUrl) {
        Glide.with(photoImage.getContext()).load(imageUrl).into(photoImage);
    }
}

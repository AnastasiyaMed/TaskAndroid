package by.academy.medvedeva.testandroid.task13;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import by.academy.medvedeva.testandroid.base.BaseItemViewModel;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

public class Task13ProfileItemViewModel extends BaseItemViewModel<ProfileModel> {
    public ObservableField<String> name = new ObservableField<>("");
    private Context context;
    private String id;

    @Override
    public void setItem(ProfileModel item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
        id = (item.getId());
    }


    public void onSuperButtonClick(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("ID", id);
        context.startActivity(intent);

    }

    public void setContext(Context context) {
        this.context = context;
    }
}

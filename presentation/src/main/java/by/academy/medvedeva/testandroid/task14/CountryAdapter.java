package by.academy.medvedeva.testandroid.task14;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Medvedeva Anastasiya
 * on 12.09.2017.
 */

public class CountryAdapter extends ArrayAdapter {
    public CountryAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public CountryAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public CountryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
    }

    public CountryAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public CountryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public CountryAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }
}

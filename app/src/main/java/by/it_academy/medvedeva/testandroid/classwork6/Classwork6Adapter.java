package by.it_academy.medvedeva.testandroid.classwork6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.it_academy.medvedeva.testandroid.R;


/**
 * Created by Medvedeva Anastasiya
 * on 04.08.2017.
 */

public class Classwork6Adapter extends RecyclerView.Adapter<Classwork6Adapter.Holder> {
    private List<String> items;

    public Classwork6Adapter(List<String> items) {
        this.items = items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false);
        Log.e("AAAAA", "onCreateViewHolder");
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("AAAAA", "onBindViewHolder");
        String item = items.get(position);
        // добавить картинки
        // holder.imageView.
        holder.textView.setText(item);

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}

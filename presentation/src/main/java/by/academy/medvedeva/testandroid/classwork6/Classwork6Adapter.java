package by.academy.medvedeva.testandroid.classwork6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import by.academy.medvedeva.testandroid.R;


/**
 * Created by Medvedeva Anastasiya
 * on 04.08.2017.
 */

class Classwork6Adapter extends RecyclerView.Adapter<Classwork6Adapter.Holder> {
    private List<String> items;
    private OnItemClickListener onItemClickListener;

    Classwork6Adapter(List<String> items) {
        this.items = items;
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        // это весь айтем
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false);
        Log.e("AAAAA", "onCreateViewHolder");
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("AAAAA", "onBindViewHolder");
        final String item = items.get(position);
        // добавить картинки
        // holder.imageView.
        holder.textView.setText(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    interface OnItemClickListener {
        void onItemClick(String item);
    }
}

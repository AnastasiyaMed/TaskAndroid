package by.academy.medvedeva.testandroid.task6;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 13.08.2017.
 */

public class Task6Activity extends Activity {
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task6);

        list.add("http://kaliaka.ru/kartinki-na-telefon/image/000002010.jpg");
        list.add("http://kaliaka.ru/kartinki-na-telefon/image/000002012.jpg");
        list.add("http://kaliaka.ru/kartinki-na-telefon/image/000002013.jpg");
        list.add("http://kaliaka.ru/kartinki-na-telefon/image/000002017.jpg");
        list.add("http://kaliaka.ru/kartinki-na-telefon/image/000002019.jpg");
        list.add("http://www.sunhome.ru/i/wallpapers/212/smailik-kartinka-na-telefon.240x320.jpg");
        list.add("http://www.nokiaplanet.com/uploads/posts/2014-01/1390292852_abstrack-butterflies-240x320.jpg");


        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);

        int spanCount = 2;
        GridLayoutManager gridLM = new GridLayoutManager(this, spanCount);
        //  rv.setHasFixedSize(true);


        rv.setLayoutManager(gridLM);

        Task6Adapter adapter = new Task6Adapter(list);
        rv.setAdapter(adapter);

    }

    private class Task6Adapter extends RecyclerView.Adapter<Task6Adapter.Holder> {
        private List<String> list;

        Task6Adapter(List<String> list) {
            this.list = list;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            // это весь айтем
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view_task6, parent, false);
            Log.e("AAAAA", "onCreateViewHolder");
            return new Holder(root);
        }

        @Override
        public void onBindViewHolder(final Holder holder, int position) {
            final String item = list.get(position);
            Glide.with(getBaseContext()).load(item).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    holder.progress.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    holder.progress.setVisibility(View.GONE);
                    holder.imageView.setVisibility(View.VISIBLE);
                    return false;
                }
            }).
                    into(holder.imageView);
        }


        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            ImageView imageView;
            ProgressBar progress;

            Holder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.image);
                progress = (ProgressBar) itemView.findViewById(R.id.progress);
            }
        }
    }
}

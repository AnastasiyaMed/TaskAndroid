package by.academy.medvedeva.testandroid.task9;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.base.BaseViewModel;
import by.academy.medvedeva.testandroid.databinding.ActivityTask9Binding;
import by.academy.medvedeva.testandroid.databinding.ItemTask9Binding;
import by.it_academy.medvedeva.taskandroid.entity.ImageEntity;
import by.it_academy.medvedeva.taskandroid.interaction.ImageUseCase;


/**
 * Created by Medvedeva Anastasiya
 * on 20.08.2017.
 */

public class Task9ViewModel implements BaseViewModel {

    public Activity activity;
    List<ImageEntity> items;
    private ImageUseCase useCase = new ImageUseCase();

    public Task9ViewModel(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
        items = useCase.execute();

        ActivityTask9Binding binding = DataBindingUtil
                .setContentView(activity, R.layout.activity_task9);
        RecyclerView recyclerView = binding.recyclerView;
        int spanCount = 2;
        GridLayoutManager gridLM = new GridLayoutManager(activity, spanCount);
        recyclerView.setLayoutManager(gridLM);
        Task9ViewModel.Task9ViewAdapter adapter = new Task9ViewAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void pause() {
    }

    class Task9ViewAdapter extends RecyclerView.Adapter<Task9ViewModel.Task9ViewAdapter.Holder> {
        Task9ViewModel viewModel = new Task9ViewModel(activity);
        List<ImageEntity> items;

        Task9ViewAdapter(Task9ViewModel viewModel, List<ImageEntity> items) {
            this.viewModel = viewModel;
            this.items = items;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemTask9Binding binding = ItemTask9Binding.inflate(inflater, parent, false);
            return new Holder(binding.getRoot());
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            final ImageEntity item = items.get(position);
            ObservableField<String> url = new ObservableField<>(item.getUrl());
            ImageViewModel imageViewModel = new ImageViewModel(url);
            holder.binding.setViewModel(imageViewModel);
        }

        @Override
        public int getItemCount() {
            return items == null ? 0 : items.size();
        }


        class Holder extends RecyclerView.ViewHolder {
            ItemTask9Binding binding;

            Holder(View itemView) {
                super(itemView);
                binding = DataBindingUtil.bind(itemView);
            }
        }

    }

}

package by.academy.medvedeva.testandroid.classwork6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 04.08.2017.
 */

public class Classwork6Activity extends Activity {
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);

        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");
        list.add("Item 6");
        list.add("Item 7");
        list.add("Item 8");
        list.add("Item 9");
        list.add("Item 10");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // отвечает за отрисовку итемов на экране
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this); // здесь можно добавить горизонтальный скролинг. По умолчанию вертикальный

        recyclerView.setLayoutManager(linearLayoutManager);

        Classwork6Adapter adapter = new Classwork6Adapter(list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Classwork6Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {

            }
        });

    }
}

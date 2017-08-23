package by.academy.medvedeva.testandroid.classwork13;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 21.08.2017.
 */

public class Classwork13SecondFragment extends Fragment {

    // во фрагменте не желательно определять конструкторов с параметрами. Только без.
    // когда андроид восстанавливает фрагменты, он всегда вызывает конструктор по умолчанию. Если мы хранили какие-то
    // данные во фрагменте, они пропадут

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getArguments() метод который типа getIntent - отдает данные
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Здесь не желательно вешать листенеры на какие-то элементы фрагмента, потому что на момент вызова этого метода, экран еще не создан
        return inflater.inflate(R.layout.fragment_classwork13_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Всю логику сюда!!!
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
      // после того как отработал этот метод можно обратиться к активити: getActivity()
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}

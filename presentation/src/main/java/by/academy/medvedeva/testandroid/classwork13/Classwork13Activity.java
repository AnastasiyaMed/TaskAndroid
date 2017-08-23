package by.academy.medvedeva.testandroid.classwork13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import by.academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 21.08.2017.
 */

public class Classwork13Activity extends FragmentActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork13);

        // если в онКриэйте создавать фразменг, нужно делать проверку: if(savedInstanseState == null) {}


        findViewById(R.id.fragment1Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(), Classwork13Fragment.newInstance(getSupportFragmentManager(), "jhf"), false);

            }
        });

        findViewById(R.id.fragment2Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(), new Classwork13SecondFragment(), false);

            }
        });
    }

    private void showFragment(FragmentManager fragmentManager, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // во фрагмент транзакшн можно подавать анимации
        // fragment.getClass().getName() вместо уникального флага для фрагмента
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
       // fragmentTransaction.addToBackStack(null); добавляет фрагмент в историю
        if (addToBackStack)fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

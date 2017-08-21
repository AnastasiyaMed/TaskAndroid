package by.academy.medvedeva.testandroid.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import by.academy.medvedeva.testandroid.R;
import by.academy.medvedeva.testandroid.classwork10.Classwork10Activity;
import by.academy.medvedeva.testandroid.classwork12.Classwork12Activity;
import by.academy.medvedeva.testandroid.classwork2.Classwork2Activity;
import by.academy.medvedeva.testandroid.classwork3.Classwork3Activity;
import by.academy.medvedeva.testandroid.classwork4.Classwork4Activity;
import by.academy.medvedeva.testandroid.classwork5.Classwork5Activity;
import by.academy.medvedeva.testandroid.classwork6.Classwork6Activity;
import by.academy.medvedeva.testandroid.classwork7.Classwork7Activity;
import by.academy.medvedeva.testandroid.classwork8.Classwork8Activity;
import by.academy.medvedeva.testandroid.task1.Task1Activity;
import by.academy.medvedeva.testandroid.task2.Task2Activity;
import by.academy.medvedeva.testandroid.task3.Task3Activity;
import by.academy.medvedeva.testandroid.task4.Task4Activity;
import by.academy.medvedeva.testandroid.task5.Task5Activity;
import by.academy.medvedeva.testandroid.task6.Task6Activity;
import by.academy.medvedeva.testandroid.task7.Task7Activity;
import by.academy.medvedeva.testandroid.task9.Task9Activity;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by Medvedeva Anastasiya
 * on 26.07.2017.
 */

public class MainActivity extends Activity implements View.OnClickListener {


    public PublishSubject<String> publishSubject = PublishSubject.create();
    // behaviorSubject хранит историю. Он кэширует один объект,
    // то есть последний до подписки на него и все что после
    // и есть возможность задавать количество сообщений, которые будут кэшироваться
    public BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
    // replaySubject хранит ВСЮ историю. Когда бы сообщения не были отправлены, он покажет все
    public ReplaySubject<String> replaySubject = ReplaySubject.create();

    Disposable disposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // посылаем информацию в паблишсабжэект
        // эти данные мы не получили, потому что не подписались на них еще
        publishSubject.onNext("1");
        publishSubject.onNext("2");
        publishSubject.onNext("3");
        publishSubject.onNext("4");

        // подписываемся на него, и обязательно потом отписаться
        disposable = publishSubject.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAA", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        // эти данные мы уже получим, потому что уже подписались
        publishSubject.onNext("5");
        publishSubject.onNext("6");
        publishSubject.onNext("7");


        behaviorSubject.onNext("123");


        // ContextCompat помогает управлять разрешениями в разных версиях андроида

        final Button task1Button = (Button) findViewById(R.id.task1_button);
        final Button task2Button = (Button) findViewById(R.id.task2_button);
        final Button task3Button = (Button) findViewById(R.id.task3_button);
        final Button task4Button = (Button) findViewById(R.id.task4_button);
        final Button task5Button = (Button) findViewById(R.id.task5_button);
        final Button task6Button = (Button) findViewById(R.id.task6_button);
        final Button task7Button = (Button) findViewById(R.id.task7_button);
        final Button task9Button = (Button) findViewById(R.id.task9_button);
        final Button class2 = (Button) findViewById(R.id.class2_button);
        final Button class3 = (Button) findViewById(R.id.class3_button);
        final Button class4 = (Button) findViewById(R.id.class4_button);
        final Button class5 = (Button) findViewById(R.id.class5_button);
        final Button class6 = (Button) findViewById(R.id.class6_button);
        final Button class7 = (Button) findViewById(R.id.class7_button);
        final Button class8 = (Button) findViewById(R.id.class8_button);
        final Button class10 = (Button) findViewById(R.id.class10_button);
        final Button class12 = (Button) findViewById(R.id.class12_button);

        class2.setOnClickListener(this);
        class3.setOnClickListener(this);
        class4.setOnClickListener(this);
        class5.setOnClickListener(this);
        class6.setOnClickListener(this);
        class7.setOnClickListener(this);
        class8.setOnClickListener(this);
        class10.setOnClickListener(this);
        class12.setOnClickListener(this);
        task2Button.setOnClickListener(this);
        task3Button.setOnClickListener(this);
        task4Button.setOnClickListener(this);
        task5Button.setOnClickListener(this);
        task6Button.setOnClickListener(this);
        task7Button.setOnClickListener(this);
        task9Button.setOnClickListener(this);

        task1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Task1Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case (R.id.class2_button):
                intent = new Intent(getApplicationContext(), Classwork2Activity.class);
                startActivity(intent);
                break;
            case (R.id.class3_button):
                intent = new Intent(getApplicationContext(), Classwork3Activity.class);
                startActivity(intent);
                break;
            case (R.id.class4_button):
                intent = new Intent(getApplicationContext(), Classwork4Activity.class);
                startActivity(intent);
                break;
            case (R.id.class5_button):
                intent = new Intent(getApplicationContext(), Classwork5Activity.class);
                startActivity(intent);
                break;
            case (R.id.class6_button):
                intent = new Intent(getApplicationContext(), Classwork6Activity.class);
                startActivity(intent);
                break;
            case (R.id.class7_button):
                intent = new Intent(getApplicationContext(), Classwork7Activity.class);
                startActivity(intent);
                break;
            case (R.id.class8_button):
                intent = new Intent(getApplicationContext(), Classwork8Activity.class);
                startActivity(intent);
                break;
            case (R.id.class10_button):
                intent = new Intent(getApplicationContext(), Classwork10Activity.class);
                startActivity(intent);
                break;
            case (R.id.class12_button):
                intent = new Intent(getApplicationContext(), Classwork12Activity.class);
                startActivity(intent);
                break;
            case (R.id.task1_button):
                intent = new Intent(getApplicationContext(), Task1Activity.class);
                startActivity(intent);
                break;
            case (R.id.task2_button):
                intent = new Intent(getApplicationContext(), Task2Activity.class);
                startActivity(intent);
                break;
            case (R.id.task3_button):
                intent = new Intent(getApplicationContext(), Task3Activity.class);
                startActivity(intent);
                break;
            case (R.id.task4_button):
                intent = new Intent(getApplicationContext(), Task4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate, R.anim.alpha);
                break;
            case (R.id.task5_button):
                intent = new Intent(getApplicationContext(), Task5Activity.class);
                startActivity(intent);
                break;
            case (R.id.task6_button):
                intent = new Intent(getApplicationContext(), Task6Activity.class);
                startActivity(intent);
                break;
            case (R.id.task7_button):
                intent = new Intent(getApplicationContext(), Task7Activity.class);
                startActivity(intent);
                break;
        case (R.id.task9_button):
                intent = new Intent(getApplicationContext(), Task9Activity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}

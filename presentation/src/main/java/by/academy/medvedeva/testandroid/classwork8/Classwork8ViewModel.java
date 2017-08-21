package by.academy.medvedeva.testandroid.classwork8;

import android.app.Activity;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.widget.Toast;

import by.academy.medvedeva.testandroid.base.BaseViewModel;

/**
 * Created by Medvedeva Anastasiya
 * on 09.08.2017.
 */

public class Classwork8ViewModel implements BaseViewModel {
    public Activity activity;
    public ObservableField<String> helloText = new ObservableField<>("Hello!");

    public Classwork8ViewModel(Activity activity) {
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

    }

    @Override
    public void pause() {

    }

    public void onSuperButtonClick() {
        Toast.makeText(this.activity, "O-la!", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(activity, Classwork7Activity.class);
//        activity.startActivity(intent);
        Classwork8Activity.show(activity);
    }


    // Косячный из-за того, что пользователь может уйти с активити, пока продолжается работа
    // метода doInBackground
    /**
     * The three types used by an asynchronous task are the following:
     Params, the type of the parameters sent to the task upon execution.
     Progress, the type of the progress units published during the background computation.
     Result, the type of the result of the background computation.
     **/
    public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            // этот метод работает в UI потоке, до начала работы  doInBackground
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            // этот метод работает в UI потоке, но его нужно вызвать самостоятельно из метода doInBackground
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... params) {
            // этот код выполняется в отдельном потоке
            // и передает данные (return)
            // в метод onPostxecute(), который работает в основном потоке

            publishProgress(); // вызывает метод onProgressUpdate..
            // второй параметр класса менянтся на Int, входной параметр метода
            // onProgressUpdate объявляется Int
            // и передаем сюда int (0-100)

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // этот метод работает в UI потоке
            // берет данные из doInBackground
            // если мы меняем третий параметр класса и возвращаемый типа метода doInBackground
            super.onPostExecute(aVoid);
        }
    }
}

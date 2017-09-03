package by.it_academy.medvedeva.data.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import by.it_academy.medvedeva.data.entity.Profile;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Medvedeva Anastasiya
 * on 16.08.2017.
 */

public class RestService {
    private static final RestService instance = new RestService();
    private RestApi restApi;

    private RestService() {
        init();
    }

    public static RestService getInstance() {
        return instance;
    }

    private void init() {

        //это для логгирования
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/3CC2DABE-ECC4-93CE-FF48-C699EAF1FD00/D6209607-F1CC-D406-FF1B-30F74614EA00/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();

        restApi = retrofit.create(RestApi.class);
    }

    public Observable<List<Profile>> getProfiles() {
        return restApi.getProfiles();
    }

//    public Observable<List<Profile>> getProfile(int id) {
//        return restApi.getProfile("id=".concat(String.valueOf(id)));
//    }

    public Observable<Profile> getProfile(String id) {
        return restApi.getProfile(id);
    }

//    public Observable<Void> saveProfile(Profile profile) {
//        return restApi.saveProfile("id=".concat(String.valueOf(profile.getId())), profile);
//    }

    public Observable<Void> saveProfile(Profile profile) {
        return restApi.saveProfile(profile.getId(), profile);
    }
}

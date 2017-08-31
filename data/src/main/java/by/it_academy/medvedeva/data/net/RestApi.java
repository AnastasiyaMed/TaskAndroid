package by.it_academy.medvedeva.data.net;

import java.util.List;

import by.it_academy.medvedeva.data.entity.Profile;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Medvedeva Anastasiya
 * on 16.08.2017.
 */

public interface RestApi {


    @GET("data/Profiles")
    Observable<List<Profile>> getProfiles();

    @GET("data/Profiles")
    Observable<List<Profile>> getProfile(@Query("where") String id);


    @POST("data/Profiles")
    Observable<Void> saveProfile(@Body Profile profile);
}


// все подробности в ретрофитовской библиотеке

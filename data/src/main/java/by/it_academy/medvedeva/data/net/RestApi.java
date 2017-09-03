package by.it_academy.medvedeva.data.net;

import java.util.List;

import by.it_academy.medvedeva.data.entity.Profile;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Medvedeva Anastasiya
 * on 16.08.2017.
 */

public interface RestApi {


    @GET("data/Profiles")
    Observable<List<Profile>> getProfiles();
//
//    @GET("data/Profiles")
//    Observable<List<Profile>> getProfile(@Query("where") String id);

    @GET("data/Profiles/{objectId}")
    Observable<Profile> getProfile(@Path("objectId") String id);


//    @PUT("data/bulk/Profiles")
//    Observable<Void> saveProfile(@Query(value = "where", encoded = true) String id, @Body Profile profile);
//}

    @PUT("data/Profiles/{objectId}")
    Observable<Void> saveProfile(@Path("objectId") String id, @Body Profile profile);
}


// все подробности в ретрофитовской библиотеке

package by.it_academy.medvedeva.taskandroid.interaction;


import by.it_academy.medvedeva.data.entity.Profile;
import by.it_academy.medvedeva.data.net.RestService;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */

public class SaveProfileUseCase extends UseCase<ProfileModel, String> {

    // диспосэбл(rx2) это сабскрайбер (rx1)
    // по умолчанию Обсервэбл не выполнится, если на него никто не подписался (hot Observable)
    // cold Observable выполнится

    @Override
    protected Observable<String> buildUseCase(ProfileModel param) {

        // здесь делается запрос к слою data, в котором дергается какой-то метод на сервере (Rest)
        Profile profileData = new Profile();
        profileData.setName(param.getName());
        profileData.setSurname(param.getSurname());
        profileData.setAge(param.getAge());
        profileData.setId(param.getId());


        return RestService.getInstance().saveProfile(profileData).
                map(new Function<Void, String>() {
                    @Override
                    public String apply(@NonNull Void aVoid) throws Exception {
                        return "OK";
                    }
                });
    }
}

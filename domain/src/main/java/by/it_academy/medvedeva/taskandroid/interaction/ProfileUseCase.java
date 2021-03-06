package by.it_academy.medvedeva.taskandroid.interaction;


import java.util.List;
import java.util.concurrent.TimeUnit;

import by.it_academy.medvedeva.data.entity.Profile;
import by.it_academy.medvedeva.data.net.RestService;
import by.it_academy.medvedeva.taskandroid.entity.ProfileId;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Medvedeva Anastasiya
 * on 14.08.2017.
 */

public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {

    // диспосэбл(rx2) это сабскрайбер (rx1)
    // по умолчанию Обсервэбл не выполнится, если на него никто не подписался (hot Observable)
    // cold Observable выполнится

    @Override
    protected Observable<ProfileModel> buildUseCase(ProfileId param) {

        // здесь делается запрос к слою data, в котором дергается какой-то метод на сервере (Rest)



        return RestService.getInstance().getProfiles()
                .map(new Function<List<Profile>, ProfileModel>() {
                    @Override
                    public ProfileModel apply(List<Profile> profileList) throws Exception {
                        Profile profileData=profileList.get(0);
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setAge(profileData.getAge());
                        profileModel.setName(profileData.getName());
                        profileModel.setSurname(profileData.getSurname());

                        return profileModel;
                    }
                });
    }
}

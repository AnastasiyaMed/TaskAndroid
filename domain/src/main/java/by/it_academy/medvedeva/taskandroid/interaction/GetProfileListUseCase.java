package by.it_academy.medvedeva.taskandroid.interaction;

import java.util.ArrayList;
import java.util.List;

import by.it_academy.medvedeva.data.entity.Profile;
import by.it_academy.medvedeva.data.net.RestService;
import by.it_academy.medvedeva.taskandroid.entity.ProfileId;
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel;
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Medvedeva Anastasiya
 * on 27.08.2017.
 */

public class GetProfileListUseCase extends UseCase<ProfileId, List<ProfileModel>> {

    @Override
    protected Observable<List<ProfileModel>> buildUseCase(ProfileId param) {
        return RestService.getInstance().getProfiles().map(new Function<List<Profile>, List<ProfileModel>>() {
            @Override
            public List<ProfileModel> apply(@NonNull List<Profile> profiles) throws Exception {
                List<ProfileModel> list = new ArrayList<>();
                for(Profile profile: profiles) {
                    list.add(convert(profile));
                }
                return list;
            }
        });

    }

    private ProfileModel convert(Profile dataModel) {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setName(dataModel.getName());
        profileModel.setSurname(dataModel.getSurname());
        profileModel.setAge(dataModel.getAge());
        return profileModel;
    }
}

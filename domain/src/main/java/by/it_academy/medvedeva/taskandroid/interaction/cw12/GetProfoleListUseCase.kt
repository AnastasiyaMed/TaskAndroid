package by.it_academy.medvedeva.taskandroid.interaction.cw12

import by.it_academy.medvedeva.data.entity.Profile
import by.it_academy.medvedeva.data.net.RestService
import by.it_academy.medvedeva.taskandroid.entity.ProfileModel
import by.it_academy.medvedeva.taskandroid.interaction.base.UseCase
import io.reactivex.Observable

/**
 * Created by Medvedeva Anastasiya
 * on 18.08.2017.
 */

class GetProfoleListUseCase : UseCase<Void, List<ProfileModel>>() {

    override fun buildUseCase(param: Void): Observable<List<ProfileModel>> {
        return RestService.getInstance().profiles.map {
            it.map { convert(it) }
        }
    }

    private fun convert(dataModel: Profile): ProfileModel {
        val profileModel = ProfileModel()
        profileModel.name = dataModel.name
        profileModel.surname = dataModel.surname
        profileModel.age = dataModel.age
        return profileModel
    }
}

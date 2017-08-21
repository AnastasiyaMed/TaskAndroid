package by.it_academy.medvedeva.taskandroid.interaction.base;

/**
 * Created by Medvedeva Anastasiya
 * on 20.08.2017.
 */

public abstract class UseCaseTask9<InParam, OutParam> {
    protected abstract OutParam buildUseCase();

    public OutParam execute() {
        return buildUseCase();
    }
}

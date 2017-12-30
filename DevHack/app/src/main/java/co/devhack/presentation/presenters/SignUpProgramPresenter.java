package co.devhack.presentation.presenters;

import co.devhack.domain.usecase.ProgramUseCase;
import co.devhack.domain.usecase.impl.ProgramUseCaseImpl;
import co.devhack.helpers.Callback;
import co.devhack.presentation.interfaces.SignUpProgramContract;

/**
 * Created by Juanpa on 26/12/2017.
 */

public class SignUpProgramPresenter implements SignUpProgramContract.UserActionsListener {

    private SignUpProgramContract.View view;
    private ProgramUseCase useCase;

    public SignUpProgramPresenter(SignUpProgramContract.View view){
        this.view = view;
        this.useCase = new ProgramUseCaseImpl();
    }

    @Override
    public void onSignUp(String curso, String celular, String email, String nombre) {
        if (view != null){

            view.showProgressbar();

            useCase.sentPost(curso, celular, email, nombre, new Callback<Boolean>() {
                @Override
                public void success(Boolean result) {
                    view.hideProgressbar();
                    view.sucessfull();
                }

                @Override
                public void error(Exception error) {
                    view.hideProgressbar();
                    view.showMenssageError(error);
                }
            });
        }

    }
}

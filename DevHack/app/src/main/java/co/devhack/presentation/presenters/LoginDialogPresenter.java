package co.devhack.presentation.presenters;

import co.devhack.domain.usecase.UserUseCase;
import co.devhack.domain.usecase.impl.UserUseCaseImpl;
import co.devhack.helpers.Callback;
import co.devhack.presentation.interfaces.LoginDialogContract;

/**
 * Created by Juanpa on 21/12/2017.
 */

public class LoginDialogPresenter implements LoginDialogContract.UserActionsListener{

    private LoginDialogContract.View view;
    private UserUseCase userUseCase;

    public LoginDialogPresenter(LoginDialogContract.View view){
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onLogin(String email, String password) {

        if (view != null){

            view.showProgressbar();

            userUseCase.login(email, password, new Callback<Boolean>() {
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

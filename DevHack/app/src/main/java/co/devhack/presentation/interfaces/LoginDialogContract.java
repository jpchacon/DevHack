package co.devhack.presentation.interfaces;

/**
 * Created by Juanpa on 20/12/2017.
 */

public interface LoginDialogContract {
    interface View{
        void sucessfull();

        void showMenssageError(Exception error);

        void showProgressbar();
        void hideProgressbar();

    }
    interface UserActionsListener{
        void onLogin(String email, String password);
    }
}

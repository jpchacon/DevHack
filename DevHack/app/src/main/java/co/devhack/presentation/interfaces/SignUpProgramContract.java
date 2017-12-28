package co.devhack.presentation.interfaces;

/**
 * Created by Juanpa on 26/12/2017.
 */

public interface SignUpProgramContract {
    interface View{
        void sucessfull();

        void showMenssageError(Exception error);


    }
    interface UserActionsListener{
        void onSignUp(String curso, String celular, String email, String nombre);
    }
}

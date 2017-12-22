package co.devhack.domain.usecase;

import co.devhack.helpers.Callback;

/**
 * Created by Juanpa on 21/12/2017.
 */

public interface UserUseCase {
    void login(String email, String password, Callback<Boolean> callback);

}

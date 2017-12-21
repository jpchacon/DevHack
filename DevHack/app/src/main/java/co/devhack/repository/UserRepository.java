package co.devhack.repository;

import co.devhack.helpers.Callback;

/**
 * Created by Juanpa on 20/12/2017.
 */

public interface UserRepository {

    void login(String email, String password, Callback<Boolean> callback);
}

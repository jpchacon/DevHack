package co.devhack.domain.usecase.impl;

import co.devhack.domain.usecase.UserUseCase;
import co.devhack.helpers.Callback;
import co.devhack.repository.UserRepository;
import co.devhack.repository.impl.UserFirebaseRepository;

/**
 * Created by Juanpa on 21/12/2017.
 */

public class UserUseCaseImpl implements UserUseCase{
    private UserRepository userRepository;

    public UserUseCaseImpl(){
        this.userRepository = new UserFirebaseRepository();
    }

    @Override
    public void login(String email, String password, final Callback<Boolean> callback) {
        userRepository.login(email, password, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }
}

package co.devhack.domain.usecase;

import java.util.List;

import co.devhack.domain.model.Modules;
import co.devhack.domain.model.Program;
import co.devhack.helpers.Callback;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface ProgramUseCase {

    void getAll(Callback<List<Program>> callback);

    void getDetails(Callback<List<Modules>> callback, String program);

    void sentPost(String curso, String celular, String email, String nombre, Callback<Boolean> callback);
}

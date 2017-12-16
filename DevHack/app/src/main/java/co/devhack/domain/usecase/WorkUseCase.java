package co.devhack.domain.usecase;

import java.util.List;

import co.devhack.domain.model.Work;
import co.devhack.helpers.Callback;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface WorkUseCase {
    void getAll(Callback<List<Work>> callback);
}

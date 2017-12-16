package co.devhack.presentation.interfaces;

import java.util.List;

import co.devhack.domain.model.Work;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface ListWorkContract {

    interface View {
        void refreshTodos();
    }

    interface UserActionsListener {
        void loadAll();
        List<Work> getLstWorks();
    }
}

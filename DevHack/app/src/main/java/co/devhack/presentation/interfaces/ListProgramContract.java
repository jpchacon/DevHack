package co.devhack.presentation.interfaces;

import java.util.List;

import co.devhack.domain.model.Program;

/**
 * Created by cdcalvo on 16/12/17.
 */

public interface ListProgramContract {

    interface View {

        void refreshPrograms();

    }

    interface UserActionsListener {

        void loadAll();

        List<Program> getLstPrograms();

    }
}

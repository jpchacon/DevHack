package co.devhack.presentation.interfaces;

import java.util.List;

import co.devhack.domain.model.Modules;

/**
 * Created by cdcalvo on 21/12/17.
 */

public interface ProgramInformationContract {

    interface View {

        void refreshDetails();

    }

    interface UserActionsListener {

        void loadAll();

        List<Modules> getLstDetails();

    }
}

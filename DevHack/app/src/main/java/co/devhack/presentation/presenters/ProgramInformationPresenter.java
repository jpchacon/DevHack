package co.devhack.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import co.devhack.domain.model.Modules;
import co.devhack.domain.usecase.ProgramUseCase;
import co.devhack.domain.usecase.impl.ProgramUseCaseImpl;
import co.devhack.helpers.Callback;
import co.devhack.presentation.interfaces.ProgramInformationContract;

/**
 * Created by cdcalvo on 21/12/17.
 */

public class ProgramInformationPresenter implements ProgramInformationContract.UserActionsListener {

    private ProgramInformationContract.View view;
    private ProgramUseCase programUseCase;
    private List<Modules> lstDetails;
    private String program;

    public ProgramInformationPresenter(ProgramInformationContract.View view, String program) {
        this.view = view;
        this.programUseCase = new ProgramUseCaseImpl();
        this.lstDetails = new ArrayList<>(0);
        this.program = program;
    }

    @Override
    public void loadAll() {
        programUseCase.getDetails(new Callback<List<Modules>>() {
            @Override
            public void success(List<Modules> result) {
                //Se hace clear sobre la instancia del lstDetails para evitar que el adapter quede
                //con una referencia vieja de los datos cuando se actualicen
                lstDetails.clear();
                lstDetails.addAll(result);
            }

            @Override
            public void error(Exception error) {
            }
        }, program);

    }

    @Override
    public List<Modules> getLstDetails() {
        return lstDetails;
    }
}

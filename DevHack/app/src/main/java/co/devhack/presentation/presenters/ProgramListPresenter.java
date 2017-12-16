package co.devhack.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import co.devhack.domain.model.Program;
import co.devhack.domain.usecase.ProgramUseCase;
import co.devhack.domain.usecase.impl.ProgramUseCaseImpl;
import co.devhack.helpers.Callback;
import co.devhack.presentation.interfaces.ProgramListContract;

/**
 * Created by cdcalvo on 16/12/17.
 */

public class ProgramListPresenter implements ProgramListContract.UserActionsListener {

    private ProgramListContract.View view;
    private ProgramUseCase programUseCase;
    private List<Program> lstPrograms;

    public ProgramListPresenter(ProgramListContract.View view) {
        this.view = view;
        this.programUseCase = new ProgramUseCaseImpl();
        this.lstPrograms = new ArrayList<>(0);
    }

    @Override
    public void loadAll() {
        programUseCase.getAll(new Callback<List<Program>>() {
            @Override
            public void success(List<Program> result) {
                //Se hace clear sobre la instancia del lstPrograms para evitar que el adapter quede
                //con una referencia vieja de los datos cuando se actualicen
                lstPrograms.clear();
                lstPrograms.addAll(result);
            }

            @Override
            public void error(Exception error) {
                //TODO MOSTRAR ERROR
                //view.showErrorMessage(error);
            }
        });
    }

    @Override
    public List<Program> getLstPrograms() {
        return lstPrograms;
    }
}

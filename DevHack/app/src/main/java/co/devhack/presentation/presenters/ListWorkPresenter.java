package co.devhack.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import co.devhack.domain.model.Work;
import co.devhack.domain.usecase.WorkUseCase;
import co.devhack.domain.usecase.impl.WorkUseCaseImpl;
import co.devhack.helpers.Callback;
import co.devhack.presentation.interfaces.ListWorkContract;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class ListWorkPresenter implements ListWorkContract.UserActionsListener {

    private ListWorkContract.View view;
    private WorkUseCase workUseCase;
    private List<Work> workList;

    public ListWorkPresenter(ListWorkContract.View view){
        this.view = view;
        this.workUseCase = new WorkUseCaseImpl();
        this.workList = new ArrayList<>(0);
    }
    @Override
    public void loadAll() {
        workUseCase.getAll(new Callback<List<Work>>() {
            @Override
            public void success(List<Work> result) {
                //Se hace clear sobre la instancia del lstTodos para evitar que el adapter quede
                //con una referencia vieja de los datos cuando se actualicen
                workList.clear();
                workList.addAll(result);
            }

            @Override
            public void error(Exception error) {
                //TODO MOSTRAR ERROR
            }
        });

    }

    @Override
    public List<Work> getLstWorks() {
        return workList;
    }


}

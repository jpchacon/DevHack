package co.devhack.domain.usecase.impl;

import java.util.List;

import co.devhack.domain.model.Work;
import co.devhack.domain.usecase.WorkUseCase;
import co.devhack.helpers.Callback;
import co.devhack.helpers.ThreadExecutor;
import co.devhack.repository.impl.WorkRestRepository;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class WorkUseCaseImpl implements WorkUseCase {

    private WorkRestRepository workRestRepository;

    public WorkUseCaseImpl(){
        workRestRepository = new WorkRestRepository();
    }

    @Override
    public void getAll(final Callback<List<Work>> callback) {
        new ThreadExecutor<List<Work>>(new ThreadExecutor.Task<List<Work>>() {
            @Override
            public List<Work> execute() throws Exception {
                return workRestRepository.getAll();
            }

            @Override
            public void finish(Exception error, List<Work> result) {
                if(error != null){
                    callback.error(error);
                }else{
                    callback.success(result);
                }
            }
        }).execute();
    }
}

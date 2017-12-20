package co.devhack.domain.usecase.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
                HashMap<String, Work> hashMap = workRestRepository.getAll();
                List<Work> lstWork = new ArrayList<>(0);
                if(hashMap != null && hashMap.size() > 0){
                    Iterator<String> iterator = hashMap.keySet().iterator();
                    String key;
                    Work work;
                    while(iterator.hasNext()){
                        key = iterator.next();

                        work = hashMap.get(key);

                        work.setId(key);

                        lstWork.add(work);
                    }
                }

                return lstWork;
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

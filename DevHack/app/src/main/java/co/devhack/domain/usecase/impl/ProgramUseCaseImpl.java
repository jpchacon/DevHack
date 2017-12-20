package co.devhack.domain.usecase.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import co.devhack.domain.model.Program;
import co.devhack.domain.usecase.ProgramUseCase;
import co.devhack.helpers.Callback;
import co.devhack.helpers.ThreadExecutor;
import co.devhack.repository.ProgramRepository;
import co.devhack.repository.impl.ProgramRestRepository;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class ProgramUseCaseImpl implements ProgramUseCase {

    private ProgramRepository programRepository;

    public ProgramUseCaseImpl() {
        this.programRepository = new ProgramRestRepository();
    }

    @Override
    public void getAll(final Callback<List<Program>> callback) {
        new ThreadExecutor<List<Program>>(new ThreadExecutor.Task<List<Program>>() {
            @Override
            public List<Program> execute() throws Exception {
                HashMap<String, Program> hashMap = programRepository.getAll();
                List<Program> lstProgram = new ArrayList<>(0);
                if(hashMap != null && hashMap.size() > 0){
                    Iterator <String> iterator = hashMap.keySet().iterator();
                    String key;
                    Program program;
                    while(iterator.hasNext()){
                        key = iterator.next();

                        program = hashMap.get(key);

                        program.setId(key);

                        lstProgram.add(program);
                    }
                }

                return lstProgram;
            }

            @Override
            public void finish(Exception error, List<Program> result) {
                if(error != null) {
                    callback.error(error);
                } else {
                    callback.success(result);
                }
            }
        }).execute();
    }
}

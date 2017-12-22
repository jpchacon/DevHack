package co.devhack.repository;

import java.util.HashMap;
import java.util.List;

import co.devhack.domain.model.Modules;
import co.devhack.domain.model.Program;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface ProgramRepository {

    HashMap<String, Program> getAll() throws Exception;

    HashMap<String, List<Modules>> getDetails(String program) throws Exception;
}

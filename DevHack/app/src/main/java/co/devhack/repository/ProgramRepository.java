package co.devhack.repository;

import java.util.List;

import co.devhack.domain.model.Program;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface ProgramRepository {

    List<Program> getAll() throws Exception;
}

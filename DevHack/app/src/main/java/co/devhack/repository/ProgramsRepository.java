package co.devhack.repository;

import java.util.List;

import co.devhack.domain.model.Programs;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface ProgramsRepository {

    List<Programs> getAll() throws Exception;
}

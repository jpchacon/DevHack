package co.devhack.repository;

import java.util.HashMap;
import java.util.List;

import co.devhack.domain.model.Work;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface WorkRepository {
    HashMap<String, Work> getAll() throws Exception;
}

package co.devhack.repository.impl;

import java.util.List;

import co.devhack.domain.model.Program;
import co.devhack.helpers.RetrofitSingleton;
import co.devhack.repository.ProgramRepository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class ProgramRestRepository  implements ProgramRepository {

    public interface ProgramService {

        @GET("programs.json")
        Call<List<Program>> getAll();
    }

    @Override
    public List<Program> getAll() throws Exception {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        ProgramService todoService = retrofit.create(ProgramService.class);
        Call<List<Program>> call = todoService.getAll();

        Response<List<Program>> response = call.execute();

        return response.body();
    }
}

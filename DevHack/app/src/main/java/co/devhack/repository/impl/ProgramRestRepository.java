package co.devhack.repository.impl;

import java.util.List;

import co.devhack.domain.model.Programs;
import co.devhack.helpers.RetrofitSingleton;
import co.devhack.repository.ProgramsRepository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class ProgramRestRepository  implements ProgramsRepository {

    public interface ProgramService {

        @GET("programs.json")
        Call<List<Programs>> getAll();
    }

    @Override
    public List<Programs> getAll() throws Exception {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        ProgramService todoService = retrofit.create(ProgramService.class);
        Call<List<Programs>> call = todoService.getAll();

        Response<List<Programs>> response = call.execute();

        return response.body();
    }
}

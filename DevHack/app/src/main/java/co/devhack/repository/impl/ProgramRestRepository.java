package co.devhack.repository.impl;

import java.util.HashMap;
import java.util.List;

import co.devhack.domain.model.Modules;
import co.devhack.domain.model.Program;
import co.devhack.helpers.RetrofitSingleton;
import co.devhack.repository.ProgramRepository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static co.devhack.helpers.Constants.API_URI;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class ProgramRestRepository  implements ProgramRepository {

    public interface ProgramService {

        @GET("programs.json")
        Call<HashMap<String, Program>> getAll();

        @GET("detailPrograms/{program}.json")
        Call<HashMap<String, List<Modules>>> getDetails(@Path("program") String program);
    }

    @Override
    public HashMap<String, Program> getAll() throws Exception {
        Retrofit retrofit = RetrofitSingleton.getInstance(API_URI);
        ProgramService programService = retrofit.create(ProgramService.class);
        Call<HashMap<String, Program>> call = programService.getAll();

        Response<HashMap<String, Program>> response = call.execute();

        return response.body();
    }

    @Override
    public HashMap<String, List<Modules>> getDetails(String program) throws Exception{
        Retrofit retrofit = RetrofitSingleton.getInstance(API_URI);
        ProgramService programService = retrofit.create(ProgramService.class);
        Call<HashMap<String, List<Modules>>> call = programService.getDetails(program);

        Response<HashMap<String, List<Modules>>> response = call.execute();

        return response.body();
    }
}

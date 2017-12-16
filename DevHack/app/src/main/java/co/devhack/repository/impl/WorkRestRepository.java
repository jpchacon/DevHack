package co.devhack.repository.impl;

import java.util.List;

import co.devhack.domain.model.Work;
import co.devhack.helpers.RetrofitSingleton;
import co.devhack.repository.WorkRepository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class WorkRestRepository implements WorkRepository {

    public interface WorkService{
        @GET("work.json")
        Call<List<Work>> getAll();
    }


    @Override
    public List<Work> getAll() throws Exception {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        WorkService workService = retrofit.create(WorkService.class);
        Call<List<Work>> call = workService.getAll();

        Response<List<Work>> response = call.execute();

        return response.body();
    }
}

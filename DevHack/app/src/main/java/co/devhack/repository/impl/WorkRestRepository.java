package co.devhack.repository.impl;

import java.util.HashMap;
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

import static co.devhack.helpers.Constants.API_URI;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class WorkRestRepository implements WorkRepository {

    public interface WorkService{
        @GET("works.json")
        Call<HashMap<String, Work>> getAll();
    }


    @Override
    public HashMap<String, Work> getAll() throws Exception {
        Retrofit retrofit = RetrofitSingleton.getInstance(API_URI);
        WorkService workService = retrofit.create(WorkService.class);
        Call<HashMap<String, Work>> call = workService.getAll();

        Response<HashMap<String, Work>> response = call.execute();

        return response.body();
    }
}

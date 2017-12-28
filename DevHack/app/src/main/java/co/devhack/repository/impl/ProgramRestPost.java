package co.devhack.repository.impl;

import java.io.IOException;

import co.devhack.domain.model.SignUpProgram;
import co.devhack.helpers.Callback;
import co.devhack.helpers.RetrofitSingleton;
import co.devhack.repository.ProgramPost;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static co.devhack.helpers.Constants.API_POST;

/**
 * Created by Juanpa on 26/12/2017.
 */

public class ProgramRestPost implements ProgramPost {

    private APIService mApiService;

    public interface APIService{

        @POST("cursos")
        @FormUrlEncoded
        Call<SignUpProgram> savePost(@Field("curso") String curso,
                                     @Field("celular") String celular,
                                     @Field("email") String email,
                                     @Field("nombre") String nombre);
    }

    public ProgramRestPost(){
        mApiService = RetrofitSingleton.getApiService();
    }

    @Override
    public void postData(String curso, String celular, String email, String nombre, final Callback<Boolean> callback) throws IOException {

        mApiService.savePost(curso,celular,email,nombre).enqueue(new retrofit2.Callback<SignUpProgram>() {
            @Override
            public void onResponse(Call<SignUpProgram> call, Response<SignUpProgram> response) {
                if (response.isSuccessful()){
                    callback.success(true);
                }

            }

            @Override
            public void onFailure(Call<SignUpProgram> call, Throwable t) {

            }
        });

    }
}

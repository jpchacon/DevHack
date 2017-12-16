package co.devhack.helpers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static co.devhack.helpers.Constants.API_URI;

/**
 * Created by Juanpa on 16/12/2017.
 */

public class RetrofitSingleton {

    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if(retrofit == null) {
            retrofit = getInstance(API_URI);
        }

        return retrofit;
    }

    public static Retrofit getInstance(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

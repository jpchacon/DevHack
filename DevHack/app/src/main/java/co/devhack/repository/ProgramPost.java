package co.devhack.repository;

import java.io.IOException;

import co.devhack.helpers.Callback;

/**
 * Created by Juanpa on 26/12/2017.
 */

public interface ProgramPost {

    void postData(String curso, String celular, String email, String nombre, Callback<Boolean> callback) throws IOException;
}

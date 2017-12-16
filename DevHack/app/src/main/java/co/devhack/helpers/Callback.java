package co.devhack.helpers;

/**
 * Created by Juanpa on 16/12/2017.
 */

public interface Callback<T> {
    void success(T result);
    void error(Exception error);
}

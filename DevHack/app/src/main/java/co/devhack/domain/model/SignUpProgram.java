package co.devhack.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Juanpa on 26/12/2017.
 */

public class SignUpProgram {

    @SerializedName("curso")
    @Expose
    private String curso;
    @SerializedName("celular")
    @Expose
    private String celular;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}

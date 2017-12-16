package co.devhack.domain.model;

/**
 * Created by Juanpa on 14/12/2017.
 */

public class Work {

    private Integer id;
    private String empresa;
    private String cargo;
    private String tipo;
    private String fecha;
    private String descripcion;
    private String email;
    private String celular;

    public Work(String empresa, String cargo, String tipo, String fecha, String descripcion, String email, String celular) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.email = email;
        this.celular = celular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}

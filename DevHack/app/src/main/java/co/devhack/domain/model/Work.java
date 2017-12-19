package co.devhack.domain.model;

/**
 * Created by Juanpa on 14/12/2017.
 */

public class Work {

    private String id;
    private String ciudad;
    private String descripcion;
    private String email;
    private String empresa;
    private String fecha;
    private String keywords;
    private String modalidad;
    private String telefono;
    private String titulo;


    public Work(String ciudad, String descripcion, String email, String empresa, String fecha, String keywords, String modalidad, String telefono, String titulo) {
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.email = email;
        this.empresa = empresa;
        this.fecha = fecha;
        this.keywords = keywords;
        this.modalidad = modalidad;
        this.telefono = telefono;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

package co.devhack.domain.model;

/**
 * Created by cdcalvo on 19/12/17.
 */

public class Modules {
    private String name;
    private String themes;


    /**
     * Constructor para crear Modulos
     * @param name
     * @param themes
     */
    public Modules(String name, String themes) {
        this.name = name;
        this.themes = themes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }
}

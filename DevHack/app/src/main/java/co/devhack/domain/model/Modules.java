package co.devhack.domain.model;

import java.util.List;

/**
 * Created by cdcalvo on 19/12/17.
 */

public class Modules {
    private String name;
    private List<String> themes;


    /**
     * Constructor para crear Modulos
     * @param name
     * @param themes
     */
    public Modules(String name, List<String> themes) {
        this.name = name;
        this.themes = themes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getThemes() {
        return themes;
    }

    public void setThemes(List<String> themes) {
        this.themes = themes;
    }
}

package co.devhack.domain.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Juanpa on 14/12/2017.
 */
public class Program {
    private Integer id;
    private String image;
    private String description;
    private Date startDate;
    private String duration;
    private String schedules;
    private List<String> modules;
    private List<String> themes;
    private String investment;

    /**
     * Constructor para crear Programs
     * @param description
     * @param startDate
     * @param image
     * @param duration
     * @param schedules
     * @param modules
     * @param themes
     * @param investment

     */
    public Program(String image, String description, Date startDate, String duration,
                    String schedules, List<String> modules, List<String> themes,
                    String investment) {
        this.image = image;
        this.description = description;
        this.startDate = startDate;
        this.duration = duration;
        this.schedules = schedules;
        this.modules = modules;
        this.themes = themes;
        this.investment = investment;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSchedules() {
        return schedules;
    }

    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

    public List<String> getThemes() {
        return themes;
    }

    public void setThemes(List<String> themes) {
        this.themes = themes;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }
}

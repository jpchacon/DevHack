package co.devhack.domain.model;

/**
 * Created by Juanpa on 14/12/2017.
 */
public class Program {
    private String image;
    private String name;
    private String startDate;
    private String duration;
    private String schedules;
    private String investment;
    private String id;

    /**
     * Constructor para crear Programs
     * @param name
     * @param startDate
     * @param duration
     * @param schedules
     * @param investment
     * @param image
     */
    public Program(String name, String startDate, String duration,
                    String schedules, String investment,String image) {
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.schedules = schedules;
        this.investment = investment;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
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

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }
}

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

public class MaintenanceTask {
    // A unique identifier for the task within the Maintenance Action.
    private final UUID taskID = UUID.randomUUID();
    //A descriptive name for the task.
    private String name;
    // The expected time required to complete the task.
    private Duration duration;
    //The category of personnel needed to perform the task.
    private PersonnelType personnelType;
    //The hourly rate charged for the personnel.
    private BigDecimal hourlyRate;
    // The average number of personnel required for the task.
    private int numberOfPersonnel;

    public MaintenanceTask(String name, Duration duration, PersonnelType personnelType, BigDecimal hourlyRate, int numberOfPersonnel) {
        this.name = name;
        this.duration = duration;
        this.personnelType = personnelType;
        this.hourlyRate = hourlyRate;
        this.numberOfPersonnel = numberOfPersonnel;
    }

    public UUID getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public PersonnelType getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(PersonnelType personnelType) {
        this.personnelType = personnelType;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getNumberOfPersonnel() {
        return numberOfPersonnel;
    }

    public void setNumberOfPersonnel(int numberOfPersonnel) {
        this.numberOfPersonnel = numberOfPersonnel;
    }
}

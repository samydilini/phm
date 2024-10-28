import java.util.List;
import java.util.UUID;

public class MaintenanceAction {
    //A unique identifier for the Maintenance Action.
    private final UUID actionId = UUID.randomUUID();
    //A descriptive name for the Maintenance Action.
    private String name;
    //The type of maintenance being performed. This can be one of the following:
    private MaintenanceType maintenanceType;

    //Mean Time Between Maintenance (MTBM): The average time in hours between executions of the Maintenance Action.
   private Double meanTimeBetweenMaintenance;

   //One or more Tasks representing the steps required to complete the Maintenance Action.
    private List<MaintenanceTask> maintenanceActionTasks;

    public MaintenanceAction(String name, MaintenanceType maintenanceType, Double meanTimeBetweenMaintenance, List<MaintenanceTask> maintenanceActionTasks) {
        this.name = name;
        this.maintenanceType = maintenanceType;
        this.meanTimeBetweenMaintenance = meanTimeBetweenMaintenance;
        this.maintenanceActionTasks = maintenanceActionTasks;
    }

    public UUID getActionId() {
        return actionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public Double getMeanTimeBetweenMaintenance() {
        return meanTimeBetweenMaintenance;
    }

    public void setMeanTimeBetweenMaintenance(Double meanTimeBetweenMaintenance) {
        this.meanTimeBetweenMaintenance = meanTimeBetweenMaintenance;
    }

    public List<MaintenanceTask> getMaintenanceActionTasks() {
        return maintenanceActionTasks;
    }

    public void setMaintenanceActionTasks(List<MaintenanceTask> maintenanceActionTasks) {
        this.maintenanceActionTasks = maintenanceActionTasks;
    }
}

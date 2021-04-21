package Case_Study.models;

public class Room extends Services {
    private String freeService;

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String serviceName, Double areaOfUse, Integer rentalCosts, Integer maxNumOfPeople, String rentType, String freeService) {
        super(id, serviceName, areaOfUse, rentalCosts, maxNumOfPeople, rentType);
        this.freeService = freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    @Override
    public void showInfor() {
        System.out.println("Room{" +
                "freeService='" + freeService + '\'' +
                ", id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", areaOfUse=" + areaOfUse +
                ", rentalCosts=" + rentalCosts +
                ", MaxNumOfPeople=" + MaxNumOfPeople +
                ", rentType='" + rentType + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return id +
                "," + serviceName +
                "," + areaOfUse +
                "," + rentalCosts +
                "," + MaxNumOfPeople +
                "," + rentType +
                "," + freeService;
    }
}

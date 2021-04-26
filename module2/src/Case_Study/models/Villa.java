package Case_Study.models;

public class Villa extends Vip  {

    protected Double poolArea;

    public Villa() {
    }

    public Villa(String id, String serviceName, Double areaOfUse, Integer rentalCosts, Integer maxNumOfPeople, String rentType, String roomStandard, String comfortDescription, Integer numFloors, Double poolArea) {
        super(id, serviceName, areaOfUse, rentalCosts, maxNumOfPeople, rentType, roomStandard, comfortDescription, numFloors);
        this.poolArea = poolArea;
    }



    public String getRoomStandard() {
        return this.roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getComfortDescription() {
        return this.comfortDescription;
    }

    public void setComfortDescription(String comfortDescription) {
        this.comfortDescription = comfortDescription;
    }

    public Double getPoolArea() {
        return this.poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumFloors() {
        return this.numFloors;
    }

    public void setNumFloors(Integer numFloors) {
        this.numFloors = numFloors;
    }

    @Override
    public void showInfor() {
        System.out.println("Villa{" +
                "poolArea=" + poolArea +
                ", roomStandard='" + roomStandard + '\'' +
                ", comfortDescription='" + comfortDescription + '\'' +
                ", numFloors=" + numFloors +
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
                "," + roomStandard +
                "," + comfortDescription +
                "," + numFloors +
                "," + poolArea
                ;
    }


    @Override
    public String csv() {
        return id +
                "," + serviceName +
                "," + areaOfUse +
                "," + rentalCosts +
                "," + MaxNumOfPeople +
                "," + rentType +
                "," + roomStandard +
                "," + comfortDescription +
                "," + numFloors +
                "," + poolArea
                ;
    }
}

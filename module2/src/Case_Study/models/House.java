package Case_Study.models;

public class House extends Vip {
    public House() {
    }

    public House(String id, String serviceName, Double areaOfUse, Integer rentalCosts, Integer maxNumOfPeople, String rentType, String roomStandard, String comfortDescription, Integer numFloors) {
        super(id, serviceName, areaOfUse, rentalCosts, maxNumOfPeople, rentType, roomStandard, comfortDescription, numFloors);
    }

    public String getRoomStandard() {
        return this.roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getComfortDescription() {
        return comfortDescription;
    }

    public void setComfortDescription(String comfortDescription) {
        this.comfortDescription = comfortDescription;
    }

    public Integer getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(Integer numFloors) {
        this.numFloors = numFloors;
    }


    @Override
    public void showInfor() {
        System.out.println("House{" +
                "roomStandard='" + roomStandard + '\'' +
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
                "," + numFloors
                ;
    }
}

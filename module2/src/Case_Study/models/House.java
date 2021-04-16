package Case_Study.models;

public class House extends Vip {


    public House(Integer id) {
        super(id);
    }

    public House(Integer id, String roomStandard, String comfortDescription, Integer numFloors) {
        super(id, roomStandard, comfortDescription, numFloors);
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
    public String toString() {
        return  id +
                "," + roomStandard +
                "," + comfortDescription +
                "," + numFloors ;
    }

    @Override
    public void showInfor() {
        System.out.println("House{" +
                ", id=" + id +   '\'' +
                ", comfortDescription='" + comfortDescription + '\'' +
                ", numFloors=" + numFloors +
                "roomStandard='" + roomStandard +
                '}');

    }
}

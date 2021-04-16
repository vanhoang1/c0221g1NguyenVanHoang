package Case_Study.models;

public abstract  class Vip extends Services {
    protected String roomStandard;
    protected   String comfortDescription;
    protected   Integer numFloors;
    public Vip(Integer id) {
        super(id);
    }

    public String getRoomStandard() {
        return roomStandard;
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

    public Vip(Integer id, String roomStandard, String comfortDescription, Integer numFloors) {
        super(id);
        this.roomStandard = roomStandard;
        this.comfortDescription = comfortDescription;
        this.numFloors = numFloors;
    }

    @Override
    public void showInfor() {

    }
}

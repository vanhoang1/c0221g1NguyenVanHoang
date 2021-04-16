package Case_Study.models;

public  class Villa extends Vip {

    protected Double poolArea;

    public Villa(Integer id, Double poolArea) {
        super(id);
        this.poolArea = poolArea;
    }
    public Villa(Integer id, String roomStandard, String comfortDescription, Integer numFloors, Double poolArea) {
        super(id, roomStandard, comfortDescription, numFloors);
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
        System.out.println( "Villa{" +
                ", id=" + id + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", comfortDescription='" + comfortDescription + '\'' +
                ", poolArea=" + poolArea  + '\'' +
                ", numFloors=" + numFloors +
                '}');
    }

    @Override
    public String toString() {
        return   id +
                "," + roomStandard +
                "," + comfortDescription +
                "," + numFloors +
                "," + poolArea;
    }
}

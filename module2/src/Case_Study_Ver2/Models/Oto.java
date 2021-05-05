package Case_Study_Ver2.Models;

public class Oto extends Transport {
    private int numberOfSeats;
    private String vehicleModel;

    public Oto() {
    }

    public Oto(String licensePlates, String manufacturerName, int yearOfManufacture, String owner, int numberOfSeats, String vehicleModel) {
        super(licensePlates, manufacturerName, yearOfManufacture, owner);
        this.numberOfSeats = numberOfSeats;
        this.vehicleModel = vehicleModel;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public String toCsv() {
        return super.toCsv()+
                ","+numberOfSeats+
                ","+vehicleModel;
    }

    @Override
    public void  toObject(String[] list) {
        super.toObject(list);
        setNumberOfSeats(Integer.parseInt(list[4]));
        setVehicleModel(list[5]);
    }

    @Override
    public String toString() {
        return super.toString() +"Oto{" +
                "numberOfSeats=" + numberOfSeats +
                ", vehicleModel='" + vehicleModel + '\'' +
                "} " ;
    }
}

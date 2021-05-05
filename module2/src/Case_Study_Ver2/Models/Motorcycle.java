package Case_Study_Ver2.Models;

public class Motorcycle extends Transport {
    private int wattage;

    public Motorcycle() {
    }

    public Motorcycle(String licensePlates, String manufacturerName, int yearOfManufacture, String owner, int wattage) {
        super(licensePlates, manufacturerName, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toCsv() {
        return super.toCsv() +
                "," + wattage;
    }

    @Override
    public void toObject(String[] list) {
       super.toObject(list);
       setWattage(Integer.parseInt(list[4]));
    }

    @Override
    public String toString() {
        return super.toString()+ "Motorcycle{" +
                "wattage=" + wattage +
                "} " ;
    }
}

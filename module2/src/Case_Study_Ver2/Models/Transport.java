package Case_Study_Ver2.Models;

import Case_Study_Ver2.Commons.CsvToString;

public abstract class Transport implements CsvToString {
    private String licensePlates;
    private String manufacturerName;
    private int yearOfManufacture;
    private String owner;

    public Transport() {
    }

    public  Transport(String licensePlates, String manufacturerName, int yearOfManufacture, String owner) {
        this.licensePlates = licensePlates;
        this.manufacturerName = manufacturerName;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    @Override
    public String toCsv() {
        return  licensePlates +
                "," + manufacturerName +
                "," + yearOfManufacture +
                "," + owner ;
    }

    @Override
    public void toObject(String[] list) {
        setLicensePlates(list[0]);
        setManufacturerName(list[1]);
        setYearOfManufacture( Integer.parseInt( list[2]));
        setOwner(list[3]);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "licensePlates='" + licensePlates + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", owner='" + owner + '\'' +
                '}';
    }
}

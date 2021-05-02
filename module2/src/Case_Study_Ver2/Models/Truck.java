package Case_Study_Ver2.Models;

import java.util.List;

public class Truck extends Transport {
    private int limitLoad;

    public Truck() {
    }

    public Truck(String licensePlates, String manufacturerName, int yearOfManufacture, String owner, int limitLoad) {
        super(licensePlates, manufacturerName, yearOfManufacture, owner);
        this.limitLoad = limitLoad;
    }

    public int getLimitLoad() {
        return limitLoad;
    }

    public void setLimitLoad(int limitLoad) {
        this.limitLoad = limitLoad;
    }

    @Override
    public String toCsv() {
        return super.toCsv()+
                ","+limitLoad;
    }

    @Override
    public void toObject(String[] list) {
        super.toObject(list);
        setLimitLoad( Integer.parseInt( list[4]));
    }


}

package model.bean;

public  class Services {
    private int id;
    private String serviceName;
    private int areaOfUse;
    private  int numberOfFloors;
    private int maxNumOfPeople;
    private int rentalCosts;
    private int idRentType;
    private int idServiceType;
    private String status;

    public Services(int id, String serviceName, int areaOfUse, int numberOfFloors, int maxNumOfPeople, int rentalCosts, int idRentType, int idServiceType, String status) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaOfUse = areaOfUse;
        this.numberOfFloors = numberOfFloors;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentalCosts = rentalCosts;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.status = status;
    }

    public Services() {
    }

    public Services(String serviceName, int areaOfUse, int numberOfFloors, int maxNumOfPeople, int rentalCosts, int idRentType, int idServiceType, String status) {
        this.serviceName = serviceName;
        this.areaOfUse = areaOfUse;
        this.numberOfFloors = numberOfFloors;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentalCosts = rentalCosts;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getAreaOfUse() {
        return areaOfUse;
    }

    public void setAreaOfUse(int areaOfUse) {
        this.areaOfUse = areaOfUse;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getMaxNumOfPeople() {
        return maxNumOfPeople;
    }

    public void setMaxNumOfPeople(int maxNumOfPeople) {
        this.maxNumOfPeople = maxNumOfPeople;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

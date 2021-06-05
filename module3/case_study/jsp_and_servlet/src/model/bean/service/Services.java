package model.bean.service;

public  class Services {
    private int id;
    private String serviceName;
    private int areaOfUse;
    private  int numberOfFloors;
    private int maxNumOfPeople;
    private int rentalCosts;
    private RentType rentType;
    private ServiceType serviceType;
    private String status;

    public Services(int id, String serviceName, int areaOfUse, int numberOfFloors, int maxNumOfPeople, int rentalCosts, RentType rentType, ServiceType serviceType, String status) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaOfUse = areaOfUse;
        this.numberOfFloors = numberOfFloors;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentalCosts = rentalCosts;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.status = status;
    }

    public Services() {
    }

    public Services(String serviceName, int areaOfUse, int numberOfFloors, int maxNumOfPeople, int rentalCosts, RentType rentType, ServiceType serviceType, String status) {
        this.serviceName = serviceName;
        this.areaOfUse = areaOfUse;
        this.numberOfFloors = numberOfFloors;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentalCosts = rentalCosts;
        this.rentType = rentType;
        this.serviceType = serviceType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}

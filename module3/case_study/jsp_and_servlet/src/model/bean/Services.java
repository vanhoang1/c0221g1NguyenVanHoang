package model.bean;

public abstract class Services implements Comparable<Services> {
    protected String id;
    protected String serviceName;
    protected Double areaOfUse;
    protected Integer rentalCosts;
    protected Integer MaxNumOfPeople;
    protected String rentType;

    public Services() {
    }

    public Services(String id, String serviceName, Double areaOfUse, Integer rentalCosts, Integer maxNumOfPeople, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaOfUse = areaOfUse;
        this.rentalCosts = rentalCosts;
        this.MaxNumOfPeople = maxNumOfPeople;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getAreaOfUse() {
        return areaOfUse;
    }

    public void setAreaOfUse(Double areaOfUse) {
        this.areaOfUse = areaOfUse;
    }

    public Integer getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Integer rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public Integer getMaxNumOfPeople() {
        return MaxNumOfPeople;
    }

    public void setMaxNumOfPeople(Integer maxNumOfPeople) {
        MaxNumOfPeople = maxNumOfPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public abstract void showInfor();

    public int hashCode() {
        return 31 + serviceName.hashCode();
    }
    @Override
    public int compareTo(Services o) {
        return this.getServiceName().compareTo(o.getServiceName());
    }
}

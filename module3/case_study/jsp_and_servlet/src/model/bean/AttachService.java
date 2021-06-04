package model.bean;

public class AttachService {
    private int id;
    private String attachName;
    private double attachCost;
    private int attachUnit;
    private String status;

    public AttachService() {
    }

    public AttachService(int id, String attachName, double attachCost, int attachUnit, String status) {
        this.id = id;
        this.attachName = attachName;
        this.attachCost = attachCost;
        this.attachUnit = attachUnit;
        this.status = status;
    }

    public AttachService(String attachName, double attachCost, int attachUnit, String status) {
        this.attachName = attachName;
        this.attachCost = attachCost;
        this.attachUnit = attachUnit;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public double getAttachCost() {
        return attachCost;
    }

    public void setAttachCost(double attachCost) {
        this.attachCost = attachCost;
    }

    public int getAttachUnit() {
        return attachUnit;
    }

    public void setAttachUnit(int attachUnit) {
        this.attachUnit = attachUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

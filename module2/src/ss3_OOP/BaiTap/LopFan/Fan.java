package ss3_OOP.BaiTap.LopFan;

public class Fan {
    final int SlOW=1;
    final int MEDIUM=2;
    final int FAST =3;
    private int speed=SlOW;
    private boolean on=false;
    private double radius=5;
    private String color="blue";

    public int getSlOW() {
        return SlOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Fan(){}

    @Override
    public String toString() {
        if(this.on)
        return "Fan is ON " +
                "speed=" + speed +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
        else  return "Fan is OFF " +
                "speed=" + speed +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}

package ss6_keThua.BaiTap.lopCircle;

public class Circle {
    private double radius=1;
    protected String mauSac="red";
    public Circle(){

    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public double getArea(){
      return   Math.pow( this.radius,2)*3.14;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", mauSac=" + mauSac +
                ",Area :"+ getArea()
                + '\'' +
                '}';
    }
}

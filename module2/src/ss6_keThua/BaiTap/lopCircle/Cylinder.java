package ss6_keThua.BaiTap.lopCircle;

public class  Cylinder extends Circle {
   private double height=1;
    public Cylinder() {
        super();
    }

    public Cylinder(double radius,double height) {
        super(radius);
        this.height=height;
    }
    public double volume(){
       return super.getArea()*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "Thể tích:"+volume()+
                "height=" + height +
                ", mauSac='" + mauSac + '\'' +
                '}';
    }
}

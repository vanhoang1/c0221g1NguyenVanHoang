package ss6_keThua.ThucHanh.doiTuongHinhHoc;


public class Circle extends Shape  {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.round( radius * radius * Math.PI);
    }

    public double getPerimeter() {
        return  Math.round(2 * radius * Math.PI);
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                +'\n'
                +"Area : "
                +getArea()
                +'\n'
                +"Perimeter :"
                +getPerimeter()
                +'\n'
                + "which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() +getRadius()*percent);
    }
}
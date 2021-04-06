package ss6_keThua.BaiTap.LopTriangle;

public class Triangle extends Shape {
    public double side1 =1.0;
    public double side2 =1.0;
    public double side3 =1.0;
    public Triangle(){
        Shape.soCanh=3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        Shape.soCanh=3;
    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        Shape.soCanh=3;
    }
    public double getPerimeter(){
        return side1+side2+side3;
    }
    public double getArea(){
        double n=getPerimeter()/2;
        return  Math.pow((n*(n-side1)*(n-side2)*(n-side3)),0.5);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                super.toString()+
                "side1= " + side1 +
                ", side2= " + side2 +
                ", side3= " + side3 +
                " Area = "+getArea()+
                " Perimeter = "+getPerimeter()+
                '\'' +
                '}';
    }
}

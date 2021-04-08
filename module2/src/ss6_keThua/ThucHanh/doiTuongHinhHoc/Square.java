package ss6_keThua.ThucHanh.doiTuongHinhHoc;

import ss7_abstractClass.BaiTap.interfaceResizeable.Colorable;

public class Square extends Rectangle implements Colorable {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }


    public void setWidth(double width) {
        setSide(width);
    }


    public void setLength(double length) {
        setSide(length);
    }


    public void resize(double percent) {
        setSide(getSide()+getSide()*percent);
    }


    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
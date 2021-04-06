package ss7_abstractClass.BaiTap.interfaceResizeable;

import ss6_keThua.ThucHanh.doiTuongHinhHoc.Circle;
import ss6_keThua.ThucHanh.doiTuongHinhHoc.Shape;
import ss6_keThua.ThucHanh.doiTuongHinhHoc.Square;

public class RunColor {
    public static void main(String[] args) {
        Shape[] arrShape= new Shape[3];
        Circle circle1= new Circle();
        Square square1=new Square();
        Square square2=new Square();
        arrShape[0]=circle1;
        arrShape[1]=square1;
        arrShape[2]=square2;

        for (Shape i :
                arrShape) {
            if(i instanceof Colorable){
                ((Colorable) i).howToColor();
            }else  System.out.println(i.getArea());
        }
    }
}

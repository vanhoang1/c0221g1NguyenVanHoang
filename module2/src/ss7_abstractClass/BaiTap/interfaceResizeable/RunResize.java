package ss7_abstractClass.BaiTap.interfaceResizeable;

import ss6_keThua.ThucHanh.doiTuongHinhHoc.Circle;
import ss6_keThua.ThucHanh.doiTuongHinhHoc.Rectangle;
import ss6_keThua.ThucHanh.doiTuongHinhHoc.Shape;
import ss6_keThua.ThucHanh.doiTuongHinhHoc.Square;

public class RunResize {
    public static void main(String[] args) {
        Shape[] arrShape= new Shape[4];

        Shape square=new Square(3);
        Shape circle1= new Circle(3);
        Shape rectangle=new Rectangle(3,5) ;
        Shape square2=new Square(3);

        arrShape[0]= rectangle;
        arrShape[1]=square;
        arrShape[2]=circle1;
        arrShape[3]=square2;
        for (Shape i :
                arrShape) {
            System.out.println(i.getArea());
        }
        System.out.println("sau khi resize :");
        for (Shape i :
                arrShape) {
            i.resize(Math.random());
            System.out.printf("%.2f",i.getArea());
            System.out.println();
        }
    }
}
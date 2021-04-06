package ss6_keThua.ThucHanh.doiTuongHinhHoc;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
//        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println("--Trước khi thay đổi size:--");
        System.out.println(circle);
        circle.resize(Math.random());
        System.out.println("--Sau khi thay đổi--");
        System.out.println(circle);
//        circle = new Circle(3.5, "indigo", false);
//        System.out.println(circle);

    }
}

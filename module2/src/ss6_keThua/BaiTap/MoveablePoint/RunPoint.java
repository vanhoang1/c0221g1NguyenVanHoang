package ss6_keThua.BaiTap.MoveablePoint;

public class RunPoint {
    public static void main(String[] args) {
        Point banh= new Point();
        Point banh1=new Point(1,2);
        MoveablePoint banh2=new MoveablePoint();
        MoveablePoint banh3=new MoveablePoint(3,4);
        MoveablePoint banh4=new MoveablePoint(3,4,5,6);
        System.out.println(banh.toString());
        System.out.println(banh1.toString());
        System.out.println(banh2.toString());
        System.out.println(banh3.toString());
        System.out.println(banh4.toString());

    }

}

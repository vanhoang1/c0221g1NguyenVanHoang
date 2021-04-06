package ss6_keThua.BaiTap.LopTriangle;

public class Shape {
    public String color = "red";
    static int soCanh = 0;

    public Shape() {

    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String hinhDang(){
     if(soCanh==3)return "Tam giác";
       else return null;
    }
    @Override
    public String toString() {
        return "Shape{" +
                "color='" + getColor() + '\'' +
                "hình dạng"+hinhDang()+
                "Số cạnh " + soCanh +
                '}';
    }

}

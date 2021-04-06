package ss9_TDD.BaiTap;

public class TriangleClassifier {
    public static  String checkTriangle(int a ,int b,int c){
       boolean  isTriangle=(a + b) > c && (b + c) > a && (c + a) > b;
       if (isTriangle){
           // tam giác đều
           if (a == b && b == c) {
               return "Tam giac deu";
           }
           // tam giác cân
           else if ((a == b && b != c) || (b == c && c != a)
                   || (a == c && c != b)) {
              return  "Tam giac can";
           }
           else return "Tam giác thường";
       }else return  "Không phải tam giác";
    }

}

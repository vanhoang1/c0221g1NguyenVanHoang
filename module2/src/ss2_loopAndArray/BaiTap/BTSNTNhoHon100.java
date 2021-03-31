package ss2_loopAndArray.BaiTap;

public class BTSNTNhoHon100 {
    public static void main(String[] args) {

        int dem=2;
        while (dem<100){
            boolean check = true;
            for(int i=2;i<dem;i++){
                if (dem % i == 0) {
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.print(dem+" ");
            }
            dem++;

        }
    }
}

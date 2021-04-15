package ss14_thuat_toan_sap_xep.bai_tap.minh_hoa_sap_xep_chen;

import java.util.Arrays;


public class SapXepChen {
    static int[] list = {1, 9, 3, 12, -1, -7};

    public static void main(String[] args) {
        int j;
        int t;
        for(int i=1;i<list.length;i++)
        {
            j=i-1;
            t=list[i];

            while(j >= 0 && t < list[j])
            {
                list[j+1]=list[j];
                System.out.println(" đẩy các giá giá trị trong list");
                System.out.println(Arrays.toString(list));
                j--;
            }
            System.out.printf("Chèn %d vào vị trí %d",t,j+1);
            list[j+1]=t; // Chèn
            System.out.println(Arrays.toString(list));
        }
    }
}
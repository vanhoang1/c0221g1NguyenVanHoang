package ss14_thuat_toan_sap_xep.bai_tap.cai_dat_sap_xep_chen;

import java.util.Arrays;

public class insertionSortMain {
     static int[] insertionSort(int[] list){
        int j;
        int t;
        for(int i=1;i<list.length;i++)
        {
            j=i-1;
            t=list[i];

            while(j >= 0 && t < list[j])
            {
                list[j+1]=list[j];
                j--;
            }
            list[j+1]=t; // Chèn
        }
        return list;
    }

    public static void main(String[] args) {

        int[] newList= {1,2,5,2,8,-1,7,12,6,4};
        System.out.println(" chưa sắp xếp :");
        System.out.println(Arrays.toString( newList));
        System.out.println(" đã sắp sếp : ");
        System.out.println(Arrays.toString( insertionSort(newList)));
    }
}

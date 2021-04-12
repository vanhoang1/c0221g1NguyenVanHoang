package ss13_thuat_toan_tim_kiem.bai_tap.tim_kiem_de_quy;

public class DeQuy {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static int search(int[]list,int key){
        int low = 0;
        int high = list.length - 1;
        return searchDeQuy(list,key,low,high);
    }

    static int searchDeQuy( int[]list,int key,int left, int right) {
        int mid;
        if(left>right){
            return -1;
        }
        mid=(left+right)/2;
        if(list[mid]==key){
            return mid;
        }
        if(list[mid]<key){
            mid+=1;
            return searchDeQuy(list,key,mid,right);
        }else {
            mid-=1;
          return searchDeQuy(list,key,left,mid);
        }
    }

    public static void main(String[] args) {
        System.out.println( search(list,4));
        System.out.println( search(list,5));
    }
}

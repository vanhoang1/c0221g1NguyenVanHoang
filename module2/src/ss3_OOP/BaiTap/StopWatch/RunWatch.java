package ss3_OOP.BaiTap.StopWatch;

public class RunWatch {
    public static void main(String[] args) {
        StopWatch now=new StopWatch();
        int[] arr= new int[100000];
        now.start();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)Math.floor(Math.random()*100);
        }
        int k=0;
        do {
            int min=arr[k];
            for (int i = k; i <arr.length ; i++) {
                if(min>arr[i]){
                    min=arr[i];
                }
            }
            arr[k]=min;
            k++;
        }while (k<arr.length);
        now.stop();
        System.out.println(now.getElapsedTime());
    }
}

package ss11_DSA_stack_queue.bai_tap.chuyen_doi_he_10_sang_he_2;

public class StackNhiPhan {
        private int[] arr;
        private int size;
        private int index = 0;

        public StackNhiPhan() {
            arr=new int[size];
        }

    private void ensureCapacity() {
        if (index >= arr.length) {
            int[] newData = new int[++size];
            System.arraycopy(arr, 0, newData, 0, arr.length);
            arr = newData;
        }
    }
    public void BiariNum(int num){
            while (num!=0){
                ensureCapacity();
                arr[index]=num%2;
                index++;
                num = num/2;
            }
        }
        public void prinfBiari(){
            String data="";
            for (int i=index-1;i>=0;i--){
                data+=arr[i];
            }
            System.out.println(data);
        }

}

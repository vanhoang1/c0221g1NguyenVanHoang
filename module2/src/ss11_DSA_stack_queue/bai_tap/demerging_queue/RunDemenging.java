package ss11_DSA_stack_queue.bai_tap.demerging_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RunDemenging {
    public static void main(String[] args) {
        String[][] danhSach = new String[][]{
                {"nam","1/1"},
                {"nu","2/2"},
                {"nam","3/3"},
                {"nu","4/4"},
                {"nam","5/5"},
        };
        Queue<String[]> nu= new LinkedList<>();
        Queue<String[]> nam= new LinkedList<>();
        for (String[] x :
               danhSach ) {
            if(x[0].equals("nu")){
                nu.add(x);
            }else nam.add(x);
        }
        StringBuilder data= new StringBuilder();
        while (!nu.isEmpty()){
            data.append(Arrays.toString(nu.remove()));
            data.append('\n');
        }
        while (!nam.isEmpty()){
            data.append(Arrays.toString(nam.remove()));
            data.append('\n');
        }
        System.out.println(data);
    }
}

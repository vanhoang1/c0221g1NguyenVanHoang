package ss11_DSA_stack_queue.bai_tap.dem_so_lan_treemap;

public class RunTreeNote {
    public static void main(String[] args) {
        String[] chuoi=("aaaaaaaxczxczxcbbbdzxcxzcassaasbbccc").toLowerCase().split("");
        Map<String> map=new Map<>();
        for (String x :
                chuoi) {
            map.add(x);
        }
        map.printMap();
    }
}

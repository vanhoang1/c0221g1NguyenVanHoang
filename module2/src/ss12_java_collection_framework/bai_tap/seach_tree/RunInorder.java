package ss12_java_collection_framework.bai_tap.seach_tree;

import ss12_java_collection_framework.bai_tap.duyet_theo_thu_tu_postorde.Portorder;

public class RunInorder {
    public static void main(String[] args) {
        Portorder tree =new Portorder();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println( tree.seach(41));

    }
}
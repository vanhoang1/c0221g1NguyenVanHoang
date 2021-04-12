package ss11_DSA_stack_queue.bai_tap.dem_so_lan_treemap;

import java.util.Map;

public class TreeNode<K> {
    private K key;
    private int value;
    TreeNode<K> next;
    public TreeNode(K key, int value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode(K key) {
        this.key=key;
        next=null;
        setValue(1);
    }

    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

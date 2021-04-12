package ss11_DSA_stack_queue.bai_tap.dem_so_lan_treemap;

public class Map<K> {
    TreeNode<K> goc;
    int numNote=0;

    public Map() {
    }
    public void  add(K key){
        TreeNode<K> temp= goc;
        if(temp==null){
            temp=new TreeNode<>(key);
            goc=temp;
            return;
        }
       while (temp!=null){
            if(temp.getKey().equals(key)){
                temp.setValue(temp.getValue()+1);
                return;
            }
            temp=temp.next;
        }
        TreeNode<K> newNode=new TreeNode<>(key);
        newNode.next=goc;
        goc=newNode;
        numNote++;
    }
    public void printMap(){
        TreeNode<K> temp= goc;
        String data="";
        while (temp!=null){
            data+="-["+temp.getKey()+","+temp.getValue()+"]-";
           temp= temp.next;
        }
        System.out.println(data);
    }

}

package Case_Study.controllers.dataOfFurama;


import Case_Study.models.*;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class PushPullVHR<K> {
    protected   int num=0;
    protected ArrayList<K> K;
    protected   ArrayList<K> clone;
    protected String path;
    public PushPullVHR() {
        K= new ArrayList<>();
        clone=new ArrayList<>();
    }
    public void push(ArrayList<String> arrayList ){
        K.add(conver(arrayList));
        ReadWrite<K> readWrite= new ReadWrite<>();
        readWrite.write(K,path);
        moveClone();
    }
    public K conver(ArrayList<String> arrayList){
        return null;
    }
    public  void pull(ArrayList<ArrayList<String>> arrayList){
        for (  ArrayList<String>  x:
                arrayList
        ) {
            clone.add(conver(x));
        }
        System.out.println(Arrays.toString(clone.toArray()));
    }
    public  void moveClone(){
        ReadWrite<String> readWrite= new ReadWrite<>();
        ArrayList<ArrayList<String>> x=readWrite.read(this.path);
        pull(x);
    }
}

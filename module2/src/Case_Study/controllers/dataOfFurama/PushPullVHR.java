package Case_Study.controllers.dataOfFurama;


import Case_Study.models.*;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class PushPullVHR<K> {
    String id;
    String serviceName ;
    Double areaOfUse;
    Integer rentalCosts ;
    Integer MaxNumOfPeople;
    String rentType ;
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

    }
    public K conver(ArrayList<String> arrayList){
        this. id = arrayList.get(0);
        this.serviceName = arrayList.get(1);
        this.areaOfUse = Double.parseDouble(arrayList.get(2));
        this.rentalCosts = Integer.parseInt(arrayList.get(3));
        this. MaxNumOfPeople = Integer.parseInt(arrayList.get(4));
        this. rentType = arrayList.get(5);
        return null;
    }
    public  void pull(ArrayList<ArrayList<String>> arrayList){
        ArrayList<K> newA =  new ArrayList<>();
        for (  ArrayList<String>  x:
                arrayList
        ) {

            newA.add(conver(x));
        }
        clone=newA;
    }
    public  void moveClone(){
        ReadWrite<String> readWrite= new ReadWrite<>();
        ArrayList<ArrayList<String>> x=readWrite.read(this.path);
        pull(x);
    }
}

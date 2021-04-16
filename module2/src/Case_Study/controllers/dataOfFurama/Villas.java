package Case_Study.controllers.dataOfFurama;

import Case_Study.models.Villa;

import java.util.ArrayList;

public class Villas extends PushPullVHR<Villa> {


    public Villas() {
       super();
       super.path=PathFurama.VILLAPATH;
    }

    @Override
    public Villa conver(ArrayList<String> arrayList){
        Integer id= Integer.parseInt(arrayList.get(0));
        String roomStandard=arrayList.get(1);
        String comfortDescription=arrayList.get(2);
        Integer numFloors= Integer.parseInt( arrayList.get(3));
        Double poolArea=Double.parseDouble(arrayList.get(4));
        return new Villa(id,roomStandard,comfortDescription,numFloors,poolArea);
    }

}

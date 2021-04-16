package Case_Study.controllers.dataOfFurama;

import Case_Study.models.House;
import Case_Study.models.Villa;


import java.util.ArrayList;

public class Houses extends PushPullVHR<House> {
    public Houses() {
        super();
        super.path=PathFurama.HOUSEAPATH;
    }
   @Override
    public  House conver(ArrayList<String> arrayList){
        Integer id= Integer.parseInt(arrayList.get(0));
        String roomStandard=arrayList.get(1);
        String comfortDescription=arrayList.get(2);
        Integer numFloors= Integer.parseInt( arrayList.get(3));
        return  new House(id,roomStandard,comfortDescription,numFloors);
    }
}

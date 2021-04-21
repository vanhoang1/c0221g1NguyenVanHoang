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
         super.conver(arrayList);
       String roomStandard=arrayList.get(6);
       String comfortDescription=arrayList.get(7);
       Integer numFloors= Integer.parseInt( arrayList.get(8));
        return  new House(id,serviceName,areaOfUse,rentalCosts,MaxNumOfPeople,rentType,roomStandard,comfortDescription,numFloors);
    }
    public void showHouses(){
        moveClone();
        for (House x :
                this.clone) {
            x.showInfor();
        }
    }

}

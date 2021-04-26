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
        super.conver(arrayList);
        String roomStandard=arrayList.get(6);
        String comfortDescription=arrayList.get(7);
        Integer numFloors= Integer.parseInt( arrayList.get(8));
        Double poolArea=Double.parseDouble(arrayList.get(9));
        return new Villa(id,serviceName,areaOfUse,rentalCosts,MaxNumOfPeople,rentType,roomStandard,comfortDescription,numFloors,poolArea);
    }
    public void showVilas(){
        moveClone();
        for (Villa x :
                this.clone) {
            x.showInfor();
        }
    }
}

package Case_Study.controllers.dataOfFurama;

import Case_Study.models.Room;
import Case_Study.models.Villa;

import java.util.ArrayList;

public class Rooms extends PushPullVHR<Room> {
    public Rooms() {
        super();
        super.path = PathFurama.ROOMPATH;
    }

    @Override
    public Room conver(ArrayList<String> arrayList) {
        super.conver(arrayList);
        String freeService = arrayList.get(6);
        return new Room(id, serviceName, areaOfUse, rentalCosts, MaxNumOfPeople, rentType, freeService);
    }
    public void showRooms(){
        moveClone();
        for (Room x :
                this.clone) {
            x.showInfor();
        }
    }
}

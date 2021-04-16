package Case_Study.controllers.dataOfFurama;

import Case_Study.models.Room;

import java.util.ArrayList;

public class Rooms extends PushPullVHR<Room> {
    public Rooms() {
        super();
        super.path=PathFurama.ROOMPATH;
    }

    @Override
    public Room conver(ArrayList<String> arrayList) {
        Integer id=Integer.parseInt(arrayList.get(0));
        String freeService=arrayList.get(1);
        return new Room(id,freeService);
    }
}

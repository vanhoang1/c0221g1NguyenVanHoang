package Case_Study.models;

public class Room extends Services {
    private  String freeService;


    public Room( Integer id, String freeService) {
        super(id);
        this.freeService = freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    @Override
    public void showInfor() {
        System.out.println( "Room{" +
                ", id=" + id + '\'' +
                "freeService='" + freeService +
                '}');
    }

    @Override
    public String toString() {
        return id +
                "," + freeService ;
    }
}

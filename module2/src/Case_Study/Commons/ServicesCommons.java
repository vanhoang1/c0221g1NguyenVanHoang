package Case_Study.Commons;

import Case_Study.controllers.ValidateInput;
import Case_Study.controllers.dataOfFurama.PathFurama;
import Case_Study.models.House;
import Case_Study.models.Room;
import Case_Study.models.Services;
import Case_Study.models.Villa;

import java.util.ArrayList;
import java.util.List;

public  class ServicesCommons{
    protected   List<Services> arrayList;
    protected   List<Services> clone;
    protected   List<Services> villas;
    protected   List<Services> houses;
    protected   List<Services> rooms;
    protected String path= PathFurama.VILLAPATH;
    private static ValidateInput validateInput= new ValidateInput();

    public ServicesCommons() {
        villas= new ArrayList<>();
        houses= new ArrayList<>();
        rooms= new ArrayList<>();

    }

    public void pull(){
    List<List<String>> list=  WriteRead.read(path);
        for (List<String> o :
                list) {
            if(o!=null)
            {
                if( validateInput.check(1,o.get(0)) ){
                    villas.add(conver(o,"villa"));
                }
                if( validateInput.check(2,o.get(0)) ){
                    houses.add(conver(o,"house"));
                }
            }

        }

    }
    public  Services conver(List<String> o,String s ){
        Services services ;
        switch (s){
            case "villa":
                services= new Villa();
                services.setId(o.get(0));
                return services;

            case "house":
                services= new House();
                services.setId(o.get(0));
                return services;

        }
        return null;
    }




    public void showVilla(){
        for (Services s :
                villas) {
            s.showInfor();
        }
    }
    public void showHouse(){
        for (Services s :
                houses) {
            s.showInfor();
        }
    }
}

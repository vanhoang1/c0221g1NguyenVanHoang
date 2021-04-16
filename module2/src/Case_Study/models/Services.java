package Case_Study.models;

public abstract class Services {
    protected Integer id;

    public Services(Integer id) {
        this.id = id;
    }

    public abstract void showInfor();

}

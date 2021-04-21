package Case_Study.controllers.exception;

public class BirthdayException extends userException {
    public BirthdayException() {
        super("Nam sinh phai >1900 va nho hon nam hien tai 18 nam, dung dinh dạng dd/mm/yyyy");
    }
}

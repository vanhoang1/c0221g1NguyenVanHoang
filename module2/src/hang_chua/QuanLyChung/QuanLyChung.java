package hang_chua.QuanLyChung;
import hang_chua.WriteRead.WriteRead;
import hang_chua.WriteRead.CsvToString;
import java.util.List;
import java.util.Scanner;
public abstract class QuanLyChung<E extends CsvToString> implements ThaoTac {
    protected List<E> list;
    protected WriteRead<E> writeRead;

    public QuanLyChung() {
        this.writeRead=chonDocGhi();
    }

    public  abstract WriteRead<E> chonDocGhi();

    public List<E> getList() {
        return this.list;
    }

    public List<E> pullList() {
        return this.writeRead.read();
    }

    public void pushList() {
        writeRead.write(getList());
    }
    public void setList(List<E> list) {
        this.list = list;
    }

    public void xoa() {
        int i = timKiem();
        if (i >= 0) {
            chonXoa(i);
        }
    }

    public void chonXoa(int index) {
        System.out.println("bạn chọn xóa" + '\n' + getList().get(index).toString() + '\n' +
                "1.Yes" + '\n' +
                "2.No");
        int choice;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 2 && choice != 1) {
                    throw new Exception("chỉ chọn 1 hoặc 2 ");
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (choice == 1) {
            getList().remove(index);
        }
    }

    public void hienThi() {
        setList(pullList());
        for (E e :
                getList()) {
            System.out.println(e.toString());
        }
    }

    public abstract void suaThongTin(E e);

    public void sua() {
        int index = timKiem();
        if (index > 0) {
            E e = getList().get(index);
            System.out.println("sửa thong tin");
            suaThongTin(e);
        }
    }

    public int timKiem() {
        setList(pullList());
        String input;
        int index = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println(" nhập vào ");
                input = scanner.nextLine();
                for (E e :
                        getList()) {
                    boolean dk = dieuKienTimKiem(e, input);
                    if (dk) {
                        index = getList().indexOf(e);
                    }
                }
                if (input.equals("") || index > 0) {
                    break;
                }
                if (index == -1) {
                    throw new Exception("sai dau vao");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }

    protected abstract boolean dieuKienTimKiem(E e, String input);
}

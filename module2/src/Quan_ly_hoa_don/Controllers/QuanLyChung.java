package Quan_ly_hoa_don.Controllers;

import Quan_ly_hoa_don.Commons.CsvToString;
import Quan_ly_hoa_don.Commons.WriteRead;

import java.util.ArrayList;
import java.util.List;

public abstract class QuanLyChung<E extends CsvToString> {
  protected   List<E> list;
  protected   String path;
  protected WriteRead<E> writeRead;

    public  List<E> getList(){
        return this.list;
    }
    public abstract List<E> pullList();
    public abstract void pushList();

    public void setList(List<E> list) {
        this.list = list;
    }

    public abstract String getPath() ;

    public void setPath(String path) {
        this.path = path;
    }
}

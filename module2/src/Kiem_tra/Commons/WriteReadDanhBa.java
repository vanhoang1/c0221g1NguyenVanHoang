package Kiem_tra.Commons;

import Kiem_tra.Models.DanhBa;
import hang_chua.WriteRead.WriteRead;

public class WriteReadDanhBa extends WriteRead<DanhBa> {

    public WriteReadDanhBa(String path) {
        super(path);
    }

    @Override
    public DanhBa conver(String[] x) {
        return new DanhBa();
    }
}

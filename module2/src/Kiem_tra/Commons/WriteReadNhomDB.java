package Kiem_tra.Commons;

import Kiem_tra.Models.NhomDanhBa;
import hang_chua.WriteRead.WriteRead;

public class WriteReadNhomDB extends WriteRead<NhomDanhBa> {
    public WriteReadNhomDB(String path) {
        super(path);
    }

    @Override
    public NhomDanhBa conver(String[] x) {
        return new NhomDanhBa();
    }
}

package model.repository;

import model.bean.AttachService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttachServiceRepository extends BaseRepository<AttachService> {
    public AttachServiceRepository() {
        this.SELECT = "SELECT * FROM case_study.dich_vu_di_kem WHERE (`id_dich_vu_di_kem` = ?);";
        this.SELECT_ALL = "SELECT * FROM case_study.dich_vu_di_kem;";
        this.INSERT = "INSERT INTO `case_study`.`dich_vu_di_kem` (`ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES (?, ?, ?, ?);";
        this.UPDATE = "UPDATE `case_study`.`dich_vu_di_kem` SET `ten_dich_vu_di_kem` = ?, `gia` = ?, `trang_thai_kha_dung` = ? WHERE (`id_dich_vu_di_kem`  = ?);";
        this.ID = 5;
    }

    @Override
    public AttachService get(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(1);
            String attachName = resultSet.getString("ten_dich_vu_di_kem");
            double attachCost = resultSet.getDouble("gia");
            int attachUnit = resultSet.getInt("don_vi");
            String status = resultSet.getString("trang_thai_kha_dung");
            return new AttachService(id, attachName, attachCost, attachUnit, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(AttachService attachService, PreparedStatement preparedStatement) {

    }
}

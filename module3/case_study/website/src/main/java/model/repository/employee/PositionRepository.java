package model.repository.employee;

import model.bean.employee.Position;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRepository extends BaseRepository<Position> {
    public PositionRepository() {
        this.SELECT_ALL="SELECT * FROM case_study.vi_tri;";
        this.SELECT="SELECT * FROM case_study.vi_tri  WHERE (`id_vi_tri` = ?);";
    }

    @Override
    public Position get(ResultSet resultSet) {
        try {
          int id=  resultSet.getInt(1);
          String name =resultSet.getString("ten_vi_tri");
         return new Position(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(Position position, PreparedStatement preparedStatement) {

    }
}

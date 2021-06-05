package model.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<E> {
    private static String URL = "jdbc:mysql://localhost:3306/case_study?useSSL=false";
    private static String USERNAME = "root";
    private static String PASS = "mysql123";
    protected  String DEL;
    protected  String FIND;
    protected  String SELECT_ALL;
    protected  String SELECT;
    protected  String INSERT;
    protected  String UPDATE;
    protected  int ID;
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public List<E> getAll(){
        List<E> list = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                E e = get(resultSet);
                list.add(e);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    };
    public  E get(int id){
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return get(resultSet);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    };
    public boolean update(int id, E e) {
        Connection connection = getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            set(e,preparedStatement);
            preparedStatement.setInt(ID, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();

        } catch (SQLException f) {
            f.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException k) {
                k.printStackTrace();
            }
        }

        return check;
    }
    public  boolean delete(int id){
        Connection connection = getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    };
    public List<E> search(String name){
        List<E> list = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND);
            preparedStatement.setString(1, '%' + name + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                E e = get(resultSet);
                list.add(e);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    };
    public boolean insert(E e) {
        Connection connection = getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            set(e,preparedStatement);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch (SQLException f) {
            f.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException k) {
                k.printStackTrace();
            }
        }
        return check;
    }
    public abstract E get(ResultSet resultSet);
    public abstract void  set(E e,PreparedStatement preparedStatement);
}

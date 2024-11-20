package com.ems.dao;

import com.ems.config.DatabaseConnection;
import com.ems.dto.EmpDTO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOImpl implements EmpDAO {

//    private Connection connection;
    private static EmpDAOImpl empDAO;

//    Singleton Pattern
    private EmpDAOImpl() {}

    public static EmpDAOImpl getInstance() {
        if(empDAO == null) {
            empDAO = new EmpDAOImpl();
        }
        return empDAO;
    }

//    public EmpDAOImpl() throws IOException {
//        this.connection = DatabaseConnection.getConnection();
//    }

    @Override
    public void addNewEmp(EmpDTO empDTO) {
        String query = "INSERT INTO employees values (?, ?, ?, ?)";

        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, empDTO.getEmpId());
            ps.setString(2, empDTO.getEmpName());
            ps.setDouble(3, empDTO.getEmpSalary());
            ps.setString(4, empDTO.getEmpDept());
            ps.executeUpdate();
            System.out.println("Data Inserted Successfully...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmpDTO getEmpById(int id) {
        return null;
    }

    @Override
    public void deleteEmpById(int id) {
        String query = "SELECT * FROM employees";
        try(Connection connection = DatabaseConnection.getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmpById(int id) {
        String query = "SELECT * FROM employees";
        try(Connection connection = DatabaseConnection.getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<EmpDTO> showAllEmp() {
        String query = "SELECT * FROM employees";
        List<EmpDTO> empDTOS = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmpDTO empDTO = new EmpDTO(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("dept"));
                empDTOS.add(empDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empDTOS;
    }
}

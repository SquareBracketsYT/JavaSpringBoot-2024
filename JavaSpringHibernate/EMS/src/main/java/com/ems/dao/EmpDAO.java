package com.ems.dao;

import com.ems.dto.EmpDTO;

import java.util.List;

public interface EmpDAO {
    public void addNewEmp(EmpDTO empDTO);
    public EmpDTO getEmpById(int id);
    public void deleteEmpById(int id);
    public void updateEmpById(int id);
    public List<EmpDTO> showAllEmp();
}

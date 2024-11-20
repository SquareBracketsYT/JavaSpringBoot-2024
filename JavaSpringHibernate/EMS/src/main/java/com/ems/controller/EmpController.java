package com.ems.controller;

import com.ems.dao.EmpDAOImpl;
import com.ems.dto.EmpDTO;
import com.ems.service.SalaryService;
import java.util.List;

public class EmpController {
    private SalaryService salaryService = new SalaryService();
    private EmpDAOImpl empDAO = EmpDAOImpl.getInstance();

//    public EmpController() throws IOException {
//         this.empDAO = new EmpDAOImpl();
//    }

    public void addEmp(EmpDTO empDTO) {
        empDAO.addNewEmp(empDTO);
    }

    public void deleteEmpById(int id) {
        empDAO.deleteEmpById(id);
    }

    public void updateEmpById(int id) {
        empDAO.deleteEmpById(id);
    }

    public void showAllEmp() {
        List<EmpDTO> empDTOS = empDAO.showAllEmp();
        for (EmpDTO emp : empDTOS) {
            System.out.println("Emp ID : " + emp.getEmpId());
            System.out.println("Emp Name : " + emp.getEmpName());
        }
    }

    public double getSalary(int empId) {
        EmpDTO empDTO = empDAO.getEmpById(empId);
        return salaryService.calculateSalary(empDTO);
    }
}

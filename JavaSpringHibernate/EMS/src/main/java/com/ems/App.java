package com.ems;

import com.ems.controller.EmpController;
import com.ems.dto.EmpDTO;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        EmpController empController = new EmpController();
//        EmpDTO empDTO = new EmpDTO(105, "Steve", 48000, "HR");
//        empController.addEmp(empDTO);
//        empController.deleteEmpById(101);
//        empController.updateEmpById();
        empController.showAllEmp();
    }
}

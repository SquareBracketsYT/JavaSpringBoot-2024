package com.ems.service;

import com.ems.dto.EmpDTO;

public class SalaryService {

    // Open/Closed principle
    // we can extend this method for bonus, incentive, deduction
    public double calculateSalary(EmpDTO empDTO) {
        return empDTO.getEmpSalary();
    }
}

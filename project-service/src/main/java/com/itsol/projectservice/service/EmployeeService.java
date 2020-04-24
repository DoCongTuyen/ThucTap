package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployees();

    void create(EmployeeDto employeeDto);

    void update(EmployeeDto employeeDto);

    void delete(long id);

    EmployeeDto getEmployeeId(Long id);
}

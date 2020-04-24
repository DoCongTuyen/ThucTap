package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Employee;
import com.itsol.projectservice.dto.EmployeeDto;
import com.itsol.projectservice.repository.EmployeeRepo;
import com.itsol.projectservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList.stream().map(employee ->
                modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(EmployeeDto employeeDto) {
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        employeeRepo.save(employee);
    }

    @Override
    public void update(EmployeeDto employeeDto) {
        Employee employee = employeeRepo.getOne(employeeDto.getId());
        employee.setUserName(employeeDto.getUserName());
        employee.setAddress(employeeDto.getAddress());
        employee.setBirthDay(employeeDto.getBirthDay());
        employee.setCreatedDate(employeeDto.getCreatedDate());
        employee.setDepartmentId(employeeDto.getDepartmentId());
        employee.setFullName(employeeDto.getFullName());
        employee.setEmail(employeeDto.getEmail());
        employee.setImgUrl(employeeDto.getImgUrl());
        employee.setGraduatedYear(employeeDto.getGraduatedYear());
        employee.setIsActived(employeeDto.getIsActived());
        employee.setLastAccess(employeeDto.getLastAccess());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setPassword(employeeDto.getPassword());
        employee.setPositionId(employeeDto.getPositionId());
        employee.setUniversity(employeeDto.getUniversity());
        employee.setTeamId(employeeDto.getTeamId());
        employee.setSkypeAccount(employeeDto.getSkypeAccount());
        employee.setUserType(employeeDto.getUserType());
        employee.setIsManager(employeeDto.getIsManager());
        employee.setIsLeader(employeeDto.getIsLeader());
    }

    @Override
    public void delete(long id) {
        employeeRepo.deleteById(id);
    }


    @Override
    public EmployeeDto getEmployeeId(Long id) {
       Optional<Employee> optionalEmployee= employeeRepo.findById(id);
       return optionalEmployee.map(employee -> modelMapper.map(employee,EmployeeDto.class)).orElse(null);
    }
}

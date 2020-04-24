package com.itsol.projectservice.rest;

import com.itsol.projectservice.domain.Employee;
import com.itsol.projectservice.dto.EmployeeDto;
import com.itsol.projectservice.service.Impl.EmployeeServiceImpl;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("")
    ResponseEntity<List<EmployeeDto>> getAll(){
        List<EmployeeDto> list = employeeService.getEmployees();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Void> create(@RequestBody EmployeeDto employeeDto){
        try {
            employeeService.create(employeeDto);
           return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update")
    ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto){
        employeeService.update(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find-one/{id}")
    ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id){
        EmployeeDto employeeDto = employeeService.getEmployeeId(id);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
}

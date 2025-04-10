package com.example.cms.Service;


import com.example.cms.DTO.employeeResDTO;
import com.example.cms.Entity.employee;
import com.example.cms.Repository.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
@Autowired
    private employeeRepo employeeRepo;
public List<employeeResDTO>getAllEmployee(){
return employeeRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
}
public List<String>searchByName(String name){
    if(name == null || name.trim().isEmpty()){
        return List.of("không được bỏ trống");
    }
    List<String>usernameresult = employeeRepo.SeacrhByName(name);
    if(name.isEmpty()){
        return List.of("không có kết quả");
    }
    return usernameresult;
}
private employeeResDTO convertToDTO(employee employee){
    employeeResDTO dto = new employeeResDTO();
    dto.setId(employee.getId());
    dto.setUsername(employee.getUsername());
    dto.setCccd(employee.getCccd());
}
}

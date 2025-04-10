package com.example.cms.Repository;

import com.example.cms.Entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import java.util.List;

public interface employeeRepo extends JpaRepository <employee, Long>{
    // tìm tên
    @Query("SELECT e.username FROM employee e WHERE e.username LIKE CONCAT('%', :name, '%')")
    List<String> SeacrhByName(@Param("name") String name);
    //lấy ra tất cả theo cccd
    @Query("SELECT e FROM employee e WHERE e.cccd = :cccd")
    employee searchByCccd(@Param("cccd") String cccd);
    //kiểm tra cccd có dùng với ai khác ko
    @Query("SELECT COUNT(e) > 0 FROM employee e WHERE e.cccd = :cccd AND e.id != :id")
    boolean exitsByCccdAndNotId(@Param("cccd") String cccd,@Param("id") Long id);
    //ktra cccd đã dùng chưa
    boolean exitsByCccd(String cccd);
//hàm lưu
default employee saveEmployee(employee employee){
    if(employee.getId() == null){
        if(exitsByCccd(employee.getCccd())){
            throw new RuntimeException("CCCD_EXITS");
            //tạo mới
        }
    }else{
        if(exitsByCccdAndNotId(employee.getCccd(), employee.getId())){
            throw new RuntimeException("CCCD_USED");
            //sửa
        }
    }
    return save(employee);
}

}

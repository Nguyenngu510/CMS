package com.example.cms.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table
public class employee {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String username;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String cccd;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String facebook;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String sdt;
    private Date namsinh;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String quequan;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String noiohientai;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String trinhdo;
    @Column(unique = true,columnDefinition ="NVARCHAR(255)")
    private String truonghoc;
    @Column(unique = true,columnDefinition ="NVARCHAR(MAX)")
    private String ghichu;

}

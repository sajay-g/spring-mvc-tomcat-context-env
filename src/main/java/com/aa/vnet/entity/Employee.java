package com.aa.vnet.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Employee")
public class Employee implements Serializable
{
    private static final long serialVersionUID = 2636431107480780992L;

    @Id
    @Column(name = "employee_id")
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String emailStationRepo;
}

//public class Employee implements Serializable
//{
//
//}

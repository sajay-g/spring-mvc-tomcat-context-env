package com.aa.vnet.repository;

import com.aa.vnet.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface EmployeeRep extends CrudRepository<Employee, Integer>
{

}
//public interface EmployeeRep
//{
//}

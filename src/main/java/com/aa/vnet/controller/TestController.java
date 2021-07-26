package com.aa.vnet.controller;

import com.aa.vnet.config.PropertyComponent;
import com.aa.vnet.repository.EmployeeRep;
import com.aa.vnet.repository.StationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController("${context}")
public class TestController
{

    @Autowired PropertyComponent propertyComponent;

    @Autowired EmployeeRep employeeRep;
//    @Autowired StationRepo employeeRep;
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    @GetMapping(value = "/health")
    public String health()
    {
	log.info("****************health**************");

	String response = employeeRep.findAll().toString();
	log.info("response "+response);
	log.info("Property "+propertyComponent.getProperty());
	return "Application is UP!!!"+ LocalDateTime.now().toString()+" "+response;
    }
}

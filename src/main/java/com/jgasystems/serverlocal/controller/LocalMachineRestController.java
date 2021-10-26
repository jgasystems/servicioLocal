package com.jgasystems.serverlocal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgasystems.serverlocal.service.LocalMachineService;

@RestController
@RequestMapping("/apiLocal") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/apiLocal/
public class LocalMachineRestController {
	
	 //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private LocalMachineService localMachineService;
    
    @GetMapping("/hello")
    public String hello() {
      return "Hi";
    }
    
    @GetMapping("/getIp")
    public String getLocalIp(){
        return localMachineService.getIp();
    }
    
    @GetMapping("/getIpVDI")
    public String getVDIIp(){
        return localMachineService.getVDIIp();
    }
    
    @GetMapping("/getUser")
    public String findAll(){
        return localMachineService.getUser();
    }

}

package com.easygest.customerservice.adapter.in.web.administrativedivisiontype;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrativeDivisionType")
public class AdministrativeDivisionTypeController {

    @GetMapping
    public AdministrativeDivisionTypeResponse getAllAdminitrativeDivisionType(){
        return null;
    }
}

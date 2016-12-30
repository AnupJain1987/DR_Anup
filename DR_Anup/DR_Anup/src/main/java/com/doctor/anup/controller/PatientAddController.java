package com.doctor.anup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doctor.anup.model.Patient;
 

 
@Controller
@RequestMapping("/add")
public class PatientAddController{

    Logger log = LoggerFactory.getLogger(this.getClass());
     
    @RequestMapping(value="/patient", method=RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient";
    }
 
    @RequestMapping(value="/addpatient", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute Patient patient, Model model) {
         
        model.addAttribute("patientaddshow", patient);
        String info = String.format("Customer Submission: id = %d, firstname = %s, lastname = %s", 
        		patient.getId(), patient.getBp(), patient.getVisit());
        log.info(info);
         
        return "patientShow";
    }

}

 
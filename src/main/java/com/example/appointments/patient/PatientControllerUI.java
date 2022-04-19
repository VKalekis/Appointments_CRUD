package com.example.appointments.patient;

import com.example.appointments.doctor.Doctor;
import com.example.appointments.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/patients")
public class PatientControllerUI {
    private PatientService patientService;

    @Autowired
    public PatientControllerUI(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/ui")
    public String bootstrap(Model model) {
        List<Patient> patientList = patientService.getPatients();
        model.addAttribute("patientList", patientList);
        return "patients";
    }
}

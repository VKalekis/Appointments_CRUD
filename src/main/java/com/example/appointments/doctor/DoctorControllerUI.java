package com.example.appointments.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/doctors")
public class DoctorControllerUI {
    private DoctorService doctorService;

    @Autowired
    public DoctorControllerUI(DoctorService doctorService) {
            this.doctorService = doctorService;
        }


        @GetMapping("/ui")
    public String bootstrap(Model model) {
        List<Doctor> doctorList = doctorService.getDoctors();
        model.addAttribute("doctorList", doctorList);
        return "doctors";
    }
}

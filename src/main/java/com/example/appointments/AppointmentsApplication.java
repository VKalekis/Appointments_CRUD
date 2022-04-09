package com.example.appointments;

import com.example.appointments.doctor.Doctor;
import com.example.appointments.doctor.DoctorRepository;
import com.example.appointments.test.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AppointmentsApplication {

    private Logger logger = LoggerFactory.getLogger(AppointmentsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AppointmentsApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(DoctorRepository doctorRepository) {
        return (args -> {

            doctorRepository.save(
                    new Doctor("John",
                            "Smith",
                            "Surgeon",
                            LocalDate.of(1975,3,18),
                            new Test("Test of 1st"))
            );


            doctorRepository.save(
                    new Doctor("Ines",
                    "Gossart",
                    "Dermatologist",
                    LocalDate.of(1965, 12,10))
            );

            doctorRepository.save(
                    new Doctor("Maddy",
                    "Westmerland",
                    "Anesthesiologist",
                    LocalDate.of(1986,5,13))
            );

            logger.info("Doctors currently in the repository");
            logger.info("-------------------------------");
            for (Doctor doctor : doctorRepository.findAll()) {
                logger.info(doctor.toString());
            }
            logger.info("");
        });
    }

}

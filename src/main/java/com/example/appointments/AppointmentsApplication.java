package com.example.appointments;

import com.example.appointments.appointment.Appointment;
import com.example.appointments.appointment.AppointmentRepository;
import com.example.appointments.doctor.Doctor;
import com.example.appointments.doctor.DoctorRepository;
import com.example.appointments.patient.Patient;
import com.example.appointments.patient.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class AppointmentsApplication {

    private Logger logger = LoggerFactory.getLogger(AppointmentsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AppointmentsApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        return (args -> {

            Doctor doctor1 = new Doctor("John",
                                "Smith",
                                "Surgeon",
                                LocalDate.of(1975,3,18));
            Doctor doctor2 = new Doctor("Ines",
                        "Gossart",
                        "Dermatologist",
                                LocalDate.of(1965, 12,10));

            Doctor doctor3 = new Doctor("Maddy",
                        "Westmerland",
                        "Anesthesiologist",
                                LocalDate.of(1986,5,13));

            Patient patient1 = new Patient("Lily",
                            "McElwee",
                                 LocalDate.of(1981, 8,7));

            Patient patient2 = new Patient("Aldis",
                            "Conochie",
                                    LocalDate.of(1987, 6,17));

            doctorRepository.save(doctor1);
            doctorRepository.save(doctor2);
            doctorRepository.save(doctor3);

            patientRepository.save(patient1);
            patientRepository.save(patient2);


            Appointment app1 = new Appointment("Appointment1", LocalDateTime.of(2017,1,3,22,00));
            Appointment app2 = new Appointment("Appointment2", LocalDateTime.of(2015,2,3,3,00));


            doctor1.setAppointment(app1);
            doctor3.setAppointment(app2);

            patient2.setAppointment(app1);
            patient1.setAppointment(app2);

            appointmentRepository.save(app1);
            appointmentRepository.save(app2);




            logger.info("Doctors currently in the repository");
            logger.info("-------------------------------");
            for (Doctor doctor : doctorRepository.findAll()) {
                logger.info(doctor.toString());
            }
            logger.info("Patients currently in the repository");
            logger.info("-------------------------------");
            for (Patient patient : patientRepository.findAll()) {
                logger.info(patient.toString());
            }

            logger.info("Appointments currently in the repository");
            logger.info("-------------------------------");
            for (Appointment appointment : appointmentRepository.findAll()) {
                logger.info(appointment.toString());
            }

            logger.info("");
        });
    }

}

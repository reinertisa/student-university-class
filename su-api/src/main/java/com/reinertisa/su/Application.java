package com.reinertisa.su;

import com.reinertisa.su.exception.AlreadyExistsException;
import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.StudentRequest;
import com.reinertisa.su.model.UniversityClassRequest;
import com.reinertisa.su.service.StudentService;
import com.reinertisa.su.service.UniversityClassService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService,
                                               UniversityClassService universityClassService) {
        return args -> {
          createStudent(studentService, universityClassService);
        };
    }

    private void createStudent(StudentService studentService, UniversityClassService universityClassService)
            throws AlreadyExistsException, ResourceNotFoundException {

        UniversityClassRequest u1 = new UniversityClassRequest();
        u1.setUniversityClassName("Calculus I");
        u1.setCourseId(101);
        u1.setProfessor("Sade Miller");
        u1.setDescription("The hardest course");
        universityClassService.createUniversityClass(u1);

        UniversityClassRequest u2 = new UniversityClassRequest();
        u2.setUniversityClassName("Calculus II");
        u2.setCourseId(201);
        u2.setProfessor("Benjamin Miller");
        u2.setDescription("The hardest second course");
        universityClassService.createUniversityClass(u2);

        StudentRequest s1 = new StudentRequest();
        s1.setStudentId("U1234");
        s1.setStudentEmail("test@gmail.com");
        s1.setStudentName("Jack Nicholson");
        s1.setUniversityClassesRequest(Set.of(u1, u2));
        studentService.createStudent(s1);

        StudentRequest s2 = new StudentRequest();
        s2.setStudentId("U9999");
        s2.setStudentEmail("test2@gmail.com");
        s2.setStudentName("Mark Nicholson");
        s2.setUniversityClassesRequest(Set.of(u1, u2));
        studentService.createStudent(s2);
    }

}

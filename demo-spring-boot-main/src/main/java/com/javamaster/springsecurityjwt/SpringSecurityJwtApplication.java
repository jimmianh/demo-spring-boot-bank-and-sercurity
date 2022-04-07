package com.javamaster.springsecurityjwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//            int max = 10;
//            Faker faker = new Faker(new Locale("en-US"));
//            HashMap<Integer, Employee> mapEmployees = new HashMap<>();
//            HashMap<Integer, Project> mapProjects = new HashMap<>();
//
//            for(int i = 0; i < max; i++)
//            {
//                Employee employee = new Employee(faker.name().firstName(), faker.name().lastName(), faker.internet().safeEmailAddress());
//                Project project = new Project(faker.app().name(), faker.app().version() ,faker.lorem().sentence());
//                mapEmployees.put(i, employee);
//                mapProjects.put(i, project);
//                employee.setProjects(Collections.singletonList(mapProjects.get(i)));
//                project.setEmployees(Collections.singletonList(mapEmployees.get(i)));
//                projectRepository.save(project);
//                employeeRepository.save(employee);
//            }
//        };
//    }

}

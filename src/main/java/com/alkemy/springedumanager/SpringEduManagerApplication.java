package com.alkemy.springedumanager;

import com.alkemy.springedumanager.model.Curso;
import com.alkemy.springedumanager.model.Estudiante;
import com.alkemy.springedumanager.repository.CursoRepository;
import com.alkemy.springedumanager.repository.EstudianteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringEduManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEduManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(CursoRepository cursoRepo, EstudianteRepository estRepo) {
        return args -> {
            cursoRepo.save(new Curso("Spring Framework & Boot", "Desarrollo backend empresarial con JEE", 60));
            cursoRepo.save(new Curso("Arquitectura Cloud & Microservicios", "Despliegue y contenedores", 45));

            estRepo.save(new Estudiante("Carlos", "Gómez", "carlos.gomez@example.com"));
            estRepo.save(new Estudiante("Mariana", "Silva", "mariana.silva@example.com"));
        };
    }
}
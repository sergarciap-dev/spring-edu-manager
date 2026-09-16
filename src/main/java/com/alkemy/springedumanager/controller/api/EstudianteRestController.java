package com.alkemy.springedumanager.controller.api;

import com.alkemy.springedumanager.model.Estudiante;
import com.alkemy.springedumanager.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

  private final EstudianteService estudianteService;

  public EstudianteRestController(EstudianteService estudianteService) {
    this.estudianteService = estudianteService;
  }

  @GetMapping
  public List<Estudiante> listar() {
    return estudianteService.listarTodos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Estudiante> buscarPorId(@PathVariable Long id) {
    return estudianteService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
    return new ResponseEntity<>(estudianteService.guardar(estudiante), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Estudiante> actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
    return estudianteService.buscarPorId(id).map(existente -> {
      existente.setNombre(estudiante.getNombre());
      existente.setApellido(estudiante.getApellido());
      existente.setEmail(estudiante.getEmail());
      return ResponseEntity.ok(estudianteService.guardar(existente));
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    if (estudianteService.buscarPorId(id).isPresent()) {
      estudianteService.eliminar(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
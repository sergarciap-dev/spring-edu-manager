package com.alkemy.springedumanager.controller.api;

import com.alkemy.springedumanager.model.Curso;
import com.alkemy.springedumanager.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {

  private final CursoService cursoService;

  public CursoRestController(CursoService cursoService) {
    this.cursoService = cursoService;
  }

  @GetMapping
  public List<Curso> listar() {
    return cursoService.listarTodos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
    return cursoService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Curso> crear(@RequestBody Curso curso) {
    return new ResponseEntity<>(cursoService.guardar(curso), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso curso) {
    return cursoService.buscarPorId(id).map(existente -> {
      existente.setNombre(curso.getNombre());
      existente.setDescripcion(curso.getDescripcion());
      existente.setDuracionHoras(curso.getDuracionHoras());
      return ResponseEntity.ok(cursoService.guardar(existente));
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    if (cursoService.buscarPorId(id).isPresent()) {
      cursoService.eliminar(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
package com.alkemy.springedumanager.controller;

import com.alkemy.springedumanager.model.Curso;
import com.alkemy.springedumanager.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoWebController {

  private final CursoService cursoService;

  public CursoWebController(CursoService cursoService) {
    this.cursoService = cursoService;
  }

  @GetMapping
  public String listarCursos(Model model) {
    model.addAttribute("cursos", cursoService.listarTodos());
    return "cursos/lista";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/nuevo")
  public String mostrarFormularioNuevo(Model model) {
    model.addAttribute("curso", new Curso());
    return "cursos/nuevo";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/guardar")
  public String guardarCurso(@Valid @ModelAttribute("curso") Curso curso, BindingResult result) {
    if (result.hasErrors()) {
      return "cursos/nuevo";
    }
    cursoService.guardar(curso);
    return "redirect:/cursos";
  }
}
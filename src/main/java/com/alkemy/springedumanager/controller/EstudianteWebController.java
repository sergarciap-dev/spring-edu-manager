package com.alkemy.springedumanager.controller;

import com.alkemy.springedumanager.model.Estudiante;
import com.alkemy.springedumanager.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteWebController {

  private final EstudianteService estudianteService;

  public EstudianteWebController(EstudianteService estudianteService) {
    this.estudianteService = estudianteService;
  }

  @GetMapping
  public String listarEstudiantes(Model model) {
    model.addAttribute("estudiantes", estudianteService.listarTodos());
    return "estudiantes/lista";
  }

  @GetMapping("/nuevo")
  public String mostrarFormularioNuevo(Model model) {
    model.addAttribute("estudiante", new Estudiante());
    return "estudiantes/nuevo";
  }

  @PostMapping("/guardar")
  public String guardarEstudiante(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result) {
    if (result.hasErrors()) {
      return "estudiantes/nuevo";
    }
    estudianteService.guardar(estudiante);
    return "redirect:/estudiantes";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/eliminar/{id}")
  public String eliminarEstudiante(@PathVariable Long id) {
    estudianteService.eliminar(id);
    return "redirect:/estudiantes";
  }
}
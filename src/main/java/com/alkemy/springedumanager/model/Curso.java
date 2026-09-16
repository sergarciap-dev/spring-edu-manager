package com.alkemy.springedumanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cursos")
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre es obligatorio")
  private String nombre;

  private String descripcion;
  private Integer duracionHoras;

  public Curso() {
  }

  public Curso(String nombre, String descripcion, Integer duracionHoras) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.duracionHoras = duracionHoras;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getDuracionHoras() {
    return duracionHoras;
  }

  public void setDuracionHoras(Integer duracionHoras) {
    this.duracionHoras = duracionHoras;
  }
}
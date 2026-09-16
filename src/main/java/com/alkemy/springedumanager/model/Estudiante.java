package com.alkemy.springedumanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre es obligatorio")
  private String nombre;

  @NotBlank(message = "El apellido es obligatorio")
  private String apellido;

  @NotBlank(message = "El correo es obligatorio")
  @Email(message = "Debe ser un email válido")
  @Column(unique = true)
  private String email;

  public Estudiante() {
  }

  public Estudiante(String nombre, String apellido, String email) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
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

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
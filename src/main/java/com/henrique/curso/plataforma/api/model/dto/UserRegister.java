package com.henrique.curso.plataforma.api.model.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record UserRegister(String email, String password, String firstName, String lastName) {
}

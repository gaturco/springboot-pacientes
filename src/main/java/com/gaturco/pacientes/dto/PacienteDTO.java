package com.gaturco.pacientes.dto;

import java.io.Serializable;

import com.gaturco.pacientes.domain.Paciente;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public PacienteDTO() {
	}
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PacienteDTO [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
